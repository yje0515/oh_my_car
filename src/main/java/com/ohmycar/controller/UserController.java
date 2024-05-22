package com.ohmycar.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ohmycar.domain.AuthVO;
import com.ohmycar.domain.CarVO;
import com.ohmycar.domain.UserVO;
//import com.ohmycar.mapper.CarMapper;
import com.ohmycar.mapper.UserMapper;
import com.ohmycar.service.CarService;
import com.ohmycar.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
@Log4j
public class UserController {
	// 회원가입 로그인 sns간편로그인 간편회원가입 현대api 스프링이메일인증번호 api Spring Security csrf토큰
	// 비밀번호찾기

	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	private UserService userService;

	@Autowired
	private CarService carService;

	// JDBC 연결을 위한 DB 정보
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "oh_my_car";
	private static final String PASSWORD = "1234";

	

	// Register 페이지에 대한 GET 요청을 처리하는 메서드 추가 차량추가 기능
	@GetMapping("/register")
	public void showRegisterPage(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		UserVO userVO = userMapper.getUserByUserId(userDetails.getUsername());
		model.addAttribute("userVO", userVO); // ${userVO.userId}
	}

	@PostMapping("/register")
	public String handleCarRegistration(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		String username = userDetails.getUsername();

		String carId = request.getParameter("carId");
		String carSellName = request.getParameter("carSellName");
		String carName = request.getParameter("carName");
		String carType = request.getParameter("carType");

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
			String sql = "INSERT INTO car_tbl (userId, carId, carSellName, carName, carType) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, carId);
			statement.setString(3, carSellName);
			statement.setString(4, carName);
			statement.setString(5, carType);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				redirectAttributes.addFlashAttribute("successMessage", "자동차가 성공적으로 등록되었습니다.");
			} else {
				redirectAttributes.addFlashAttribute("errorMessage", "자동차 등록 중 오류가 발생했습니다.");
			}
		} catch (SQLException e) {
			redirectAttributes.addFlashAttribute("errorMessage", "DB 연결 또는 SQL 오류가 발생했습니다: " + e.getMessage());
		}

		return "redirect:/user/mypage";
	}

	@GetMapping("/carUpdate") // 자동차 차종 변경기능
	public String carUpdateGet(HttpServletRequest request, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		String userId = userDetails.getUsername();
		String carId = request.getParameter("carId");

		CarVO carVO = carService.getCarByUserId(userId);
		model.addAttribute("carVO", carVO);
		return "/user/carUpdate"; // 차량 정보 업데이트 페이지로 이동
	}

	@PostMapping("/carUpdate")
	public String carUpdatePost(CarVO carVO, RedirectAttributes rttr) {
		carService.updateCar(carVO);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/user/mypage"; // 수정 후 마이페이지로 이동
	}
}
