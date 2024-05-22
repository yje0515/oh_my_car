package com.ohmycar.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {
	// 접근 거부 페이지 핸들러
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied : " + auth);
		model.addAttribute("msg", "Access Denied");
	}

	// 로그인
	@GetMapping("/user/login")
	public void loginGet(String error, String logout, Model model) {

		log.info("error>>>>>>>>>>>>" + error);
		log.info("logout>>>>>>>>>>>>" + logout);

		if (error != null) {
			model.addAttribute("error", "error");
		}

		if (logout != null) {
			model.addAttribute("logout", "logout");
		}

	}

	@GetMapping("/user/logout")
	public void logoutGet() {
		log.info("logout....");
	}
}
