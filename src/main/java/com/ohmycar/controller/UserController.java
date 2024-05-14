package com.ohmycar.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ohmycar.domain.AuthVO;
import com.ohmycar.domain.UserVO;
import com.ohmycar.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
@Log4j
public class UserController {
	// 회원가입 로그인 sns간편로그인 간편회원가입 현대api 스프링이메일인증번호 api Spring Security csrf토큰
	// 비밀번호찾기

	private final UserMapper mapper;

	private final PasswordEncoder passwordEncoder;

	@GetMapping("/test")
	public void doTest(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getPrincipal() instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			UserVO uservo = mapper.getUserByUserid(userDetails.getUsername());
			model.addAttribute("user",uservo);
			log.info(uservo);
		}

		log.info("test......");

	}

	// 회원가입
	@GetMapping("/join")
	public void joinGet() {
		log.info("join.......");

	}

	@PostMapping("/join")
	public String joinPost(UserVO uservo, AuthVO authvo) {
		// DB에 UserVO(회원정보객체) 넣기 service메소드 사용으로 수정해야함~
		uservo.setPassword(passwordEncoder.encode(uservo.getPassword()));
		mapper.joinUser(uservo);
		AuthVO authAdmin = new AuthVO();
		mapper.joinUserAuth(authvo);

		// Admin의 경우 Member의 권한도 가질 수 있게
		if (authvo.getAuth().equals("ROLE_ADMIN")) {
			authAdmin.setUserid(authvo.getUserid());
			authAdmin.setAuth("ROLE_MEMBER");
			mapper.joinUserAuth(authAdmin);
		}

		log.info("success join.....");
		return "redirect:/user/login";
	}

	// 인증한 사용자만 접근 가능
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/mypage")
	public void mypageGet(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication.getPrincipal() instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			UserVO uservo = mapper.getUserByUserid(userDetails.getUsername());
			model.addAttribute("user",uservo);
					
		}
		log.info("mypage....");

	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/update")
	public String mypagePost(UserVO uservo) {
		uservo.setPassword(passwordEncoder.encode(uservo.getPassword()));
		mapper.updateUser(uservo);
		log.info("updated User : "+uservo);
		
		return "redirect:../";
	}

	// 관리자권한 가진 사용자만 접근 가능
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/admin")
	public void adminGet() {
		log.info("admin....");

	}

}
