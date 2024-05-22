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

	@GetMapping("/test")
	public void doTest(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getPrincipal() instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			UserVO userVO = userMapper.getUserByUserId(userDetails.getUsername());
			model.addAttribute("user", userVO);
			log.info(userVO);
		}

		log.info("test......");

	}

	// 회원가입
	@GetMapping("/join")
	public void joinGet() {
		log.info("join.......");

	}

	@PostMapping("/join")
	public String joinPost(UserVO userVO, AuthVO authVO) {
		// DB에 userVO(회원정보객체) 넣기 service메소드 사용으로 수정해야함~
		userVO.setPassword(passwordEncoder.encode(userVO.getPassword()));
		userMapper.joinUser(userVO);
		AuthVO authAdmin = new AuthVO();
		userMapper.joinUserAuth(authVO);

		// Admin의 경우 Member의 권한도 가질 수 있게
		if (authVO.getAuth().equals("ROLE_ADMIN")) {
			authAdmin.setUserId(authVO.getUserId());
			authAdmin.setAuth("ROLE_MEMBER");
			userMapper.joinUserAuth(authAdmin);
		}

		log.info("success join.....");
		return "redirect:/user/login";
	}

	// 관리자권한 가진 사용자만 접근 가능
	@GetMapping("/admin")
	public void adminGet(Model model) {
		log.info("admin....");

	}

	// 회원가입시 아이디 중복확인
	@RequestMapping("/idDupCheck")
	@ResponseBody
	public String idCheckPost(@RequestParam("userId") String userId) {
		String result = "";
		if (userMapper.getUserByUserId(userId) != null) {
			result = "fail";
		} else {
			result = "success";
		}
		return result;

	}

	// 회원가입시 이메일 중복확인
	@RequestMapping("/emailDupCheck")
	@ResponseBody
	public String emailCheckPost(@RequestParam("email") String email) {
		String result = "";
		if (userMapper.getUserByEmail(email) != null) {
			result = "fail";
		} else {
			result = "success";
		}
		return result;

	}

	@GetMapping("/mypage")
	public void mypageGet(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getPrincipal() instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			UserVO userVO = userMapper.getUserByUserId(userDetails.getUsername());
			model.addAttribute("userVO", userVO);

		}

		log.info("mypage....");

	}

	@GetMapping("/passwordCheck")
	public String passwordCheckGet(Model model) {
		// 비밀번호 확인 폼으로 이동
		return "/user/passwordCheck";
	}

	@PostMapping("/passwordCheck")
	@ResponseBody
	public String passwordCheckPost(@RequestParam("password") String password) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String username = userDetails.getUsername();
		UserVO currentUser = userMapper.getUserByUserId(username);

		if (passwordEncoder.matches(password, currentUser.getPassword())) {
			return "success";
		} else {
			return "fail";
		}
	}

	@GetMapping("/userUpdate")
	public String userUpdateGet(Model model) {
		return "user/userUpdate";
	}

	@PostMapping("/userUpdate")
	public String userUpdatePost(UserVO userVO, HttpServletRequest request, RedirectAttributes rttr) {
		String password = request.getParameter("password");

		// 세션에서 로그인한 사용자 정보를 가져옴
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		String username = userDetails.getUsername();
		UserVO currentUser = userMapper.getUserByUserId(username);

		// 입력한 비밀번호가 올바른지 확인
		if (passwordEncoder.matches(password, currentUser.getPassword())) {
			// 비밀번호가 올바를 경우 사용자 정보 업데이트
			userVO.setPassword(passwordEncoder.encode(userVO.getPassword()));
			userMapper.updateUser(userVO); // 업데이트 메서드 호출
			log.info("Updated User: " + userVO);

			// 회원정보 수정시 알림창 띄우기
			rttr.addFlashAttribute("result", "success");

			return "redirect:/user/mypage"; // 수정 후 마이페이지로 이동
		} else {
			// 비밀번호가 틀릴 경우 다시 비밀번호 확인 페이지로 이동
			rttr.addFlashAttribute("msg", "비밀번호가 올바르지 않습니다.");
			return "redirect:/user/userUpdate";
		}
	}

	@GetMapping("/userDelete")
	public void userDeleteGet(Model model) {

	}

	@PostMapping("/userDelete")
	public String userDeleteGet(RedirectAttributes rttr) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getPrincipal() instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String userId = userDetails.getUsername();
			userMapper.deleteUser(userId);
			log.info(userId + "님의 정보가 삭제되었습니다.");
		}

		rttr.addFlashAttribute("result", "deleteSuccess");
		return "redirect:/user/login";
	}

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
