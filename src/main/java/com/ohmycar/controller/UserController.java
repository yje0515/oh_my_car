package com.ohmycar.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ohmycar.domain.AuthVO;
import com.ohmycar.domain.CarVO;
import com.ohmycar.domain.UserVO;
import com.ohmycar.service.CarService;
import com.ohmycar.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
@Log4j
public class UserController {

	private final UserService userService;

	private final CarService carService;
	private final PasswordEncoder passwordEncoder;

	private static final String RESULT_STRING = "result";
	private static final String USER_VO_STRING = "userVO";

	// 회원가입페이지로 이동

	@GetMapping("/join")
	public void joinGet() {
		log.info("join.....");

	}

	// 회원가입
	@PostMapping("/join")
	public String joinPost(AuthVO authVO) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		UserVO userVO = userService.getUserByUserId(userDetails.getUsername());
		userService.joinUser(userVO, authVO);
		log.info("success join.....");
		return "redirect:/user/login";
	}

	// 관리자권한 가진 사용자만 접근 가능
	@GetMapping("/admin")
	public void adminGet(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		UserVO userVO = userService.getUserByUserId(userDetails.getUsername());
		log.info("admin.....");
		model.addAttribute(USER_VO_STRING, userVO);
	}

	// 마이페이지로 이동
	@GetMapping("/mypage")
	public void mypageGet(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		UserVO userVO = userService.getUserByUserId(userDetails.getUsername());
		log.info(userVO);
		model.addAttribute(USER_VO_STRING, userVO);
		List<CarVO> carList = carService.getCarsByUserId(userVO.getUserId());
		model.addAttribute("carList", carList);
		log.info("mypage....");
	}

	// 비밀번호 확인 페이지로 이동
	@GetMapping("/passwordCheck")
	public void passwordCheckGet(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		UserVO userVO = userService.getUserByUserId(userDetails.getUsername());
		model.addAttribute(USER_VO_STRING, userVO);
	}

	// 비밀번호 확인 후 각각 페이지로 Redirect
	@PostMapping("/passwordCheck")
	public String passwordCheckPost(String password, String action, RedirectAttributes rttr) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		UserVO userVO = userService.getUserByUserId(userDetails.getUsername());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		UserVO userVO = userService.getUserByUserId(userDetails.getUsername());
		// 비밀번호 확인
		String realPwd = userService.userPasswordCheckByUserId(userVO.getUserId());
		boolean pwdChecked = passwordEncoder.matches(password, realPwd);

		// 비밀번호가 맞으면
		if (pwdChecked) {
			log.info("correctPassword.....");
			// 비밀번호 확인 후 접근 가능
			rttr.addFlashAttribute("passwordChecked", "ok");
			if ("edit".equals(action)) {
				// 회원정보수정
				return "redirect:/user/userUpdate";
			} else {
				// 회원탈퇴
				return "redirect:/user/userDelete";
			}
		}

		// 비밀번호가 틀리면
		// 비밀번호 확인 후 접근 가능
		rttr.addFlashAttribute("passwordChecked", "notYet");
		log.info("wrongPassword.....");
		rttr.addFlashAttribute(resultString, "wrongPassword");
		if ("edit".equals(action)) {
			// action값 가지고 비밀번호 재확인
			return "redirect:/user/passwordCheck?action=edit";
		} else {
			return "redirect:/user/passwordCheck?action=remove";
		}

	}

	// 회원정보수정페이지로 이동
	@GetMapping("/userUpdate")
	public void userUpdateGet(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		UserVO userVO = userService.getUserByUserId(userDetails.getUsername());
		model.addAttribute(USER_VO_STRING, userVO);

	}log.info("update...");

	}

	// 회원정보 수정
	@PostMapping("/userUpdate")
	public String userUpdatePost(RedirectAttributes rttr) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		UserVO userVO = userService.getUserByUserId(userDetails.getUsername());
		userService.updateUser(userVO);

		// 회원정보 수정시 alert
		rttr.addFlashAttribute(resultString, "success");

		return "redirect:/";
	}

	// 회원탈퇴페이지로 이동
	@GetMapping("/userDelete")
	public void userDeleteGet(Model model) {
		log.info("delete.....");
	}

	// 회원탈퇴
	@PostMapping("/userDelete")
	public String userDeleteGet(RedirectAttributes rttr) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		UserVO userVO = userService.getUserByUserId(userDetails.getUsername());
		userService.deleteUser(userVO.getUserId());

		// 로그아웃처리
		SecurityContextHolder.clearContext();

		rttr.addFlashAttribute(resultString, "deleteSuccess");

		return "redirect:/";
	}

}