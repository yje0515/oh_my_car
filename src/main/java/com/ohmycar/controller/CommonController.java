package com.ohmycar.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ohmycar.domain.AuthVO;
import com.ohmycar.domain.UserVO;

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
	
	
	//로그인
	@GetMapping("/user/login")
	public void loginGet(String error,String logout,Model model,RedirectAttributes rttr) {
		log.info("error>>>>>>>>>>>>"+error);
		log.info("logout>>>>>>>>>>>>"+logout);
		
		if(error !=null) {
			rttr.addFlashAttribute("error","error");
		}
		
		if(logout !=null) {
			rttr.addFlashAttribute("logout","logout");
		}
		
	}
	
	
	@GetMapping("/user/logout")
	public void logoutGet() {
		log.info("logout....");
	}
}


