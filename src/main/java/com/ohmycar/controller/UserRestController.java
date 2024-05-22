package com.ohmycar.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ohmycar.domain.UserVO;
import com.ohmycar.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/user/*")
@RequiredArgsConstructor
@Log4j
public class UserRestController {

	private final UserService userService;

	private final PasswordEncoder passwordEncoder;

	private static String successString = "success";

	// 회원가입시 아이디 중복확인
	@PostMapping("/idDupCheck")
	public String idCheckPost(@RequestParam("userId") String userId) {
		if (userService.joinIdCheck(userId) != null) {
			return "fail";
		} else {
			return successString;
		}
	}

	// 회원가입시 이메일 중복확인
	@PostMapping("/emailDupCheck")
	public String emailCheckPost(@RequestParam("email") String email) {
		String result = "";
		if (userService.joinEmailCheck(email) != null) {
			result = "fail";
		} else {
			result = successString;
		}
		return result;
	}

	// 로그인 ajax로 회원존재여부 확인...
	@PostMapping("/loginCheck")
	public String loginCheckPost(@RequestParam("userId") String userId, @RequestParam("password") String password) {
		String result = "";

		UserVO userVO = userService.getUserByUserId(userId);
		if (userVO == null) {
			log.info("User not found");
			return "fail";
		}

		// userVO가 null이 아닌 경우(id가 존재하는 경우)
		boolean pwdCheck = passwordEncoder.matches(password, userVO.getPassword());
		if (pwdCheck) {
			result = successString;
		} else {
			result = "fail";
		}
		log.info("Login " + result + ".....");

		return result;
	}

}
