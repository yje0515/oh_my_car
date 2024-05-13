package com.ohmycar.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public void doTest() {
		log.info("test......");
	}

	// 회원가입
	@GetMapping("/join")
	public void joinGet() {
		log.info("join.......");

	}

	@PostMapping("/join")
	public String joinPost(UserVO uservo, AuthVO authvo, RedirectAttributes rttr) {
		// DB에 UserVO(회원정보객체) 넣기 service메소드 사용으로 수정해야함~
		uservo.setPassword(passwordEncoder.encode(uservo.getPassword()));
		mapper.joinUser(uservo);
		AuthVO authAdmin = new AuthVO();
		mapper.joinUserAuth(authvo);

		//Admin의 경우 Member의 권한도 가질 수 있게
		if (authvo.getAuth().equals("ROLE_ADMIN") ) {
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
	public void mypageGet() {
		log.info("mypage....");

	}

	// 관리자권한 가진 사용자만 접근 가능
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/admin")
	public void adminGet() {
		log.info("admin....");

	}
	
}
