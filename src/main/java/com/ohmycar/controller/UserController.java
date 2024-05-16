package com.ohmycar.controller;

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

	private final UserMapper userMapper;

	private final PasswordEncoder passwordEncoder;

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

	@GetMapping("/userUpdate")
	public void userUpdateGet(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getPrincipal() instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			UserVO userVO = userMapper.getUserByUserId(userDetails.getUsername());
			model.addAttribute("userVO", userVO);

		}
		log.info("update...");
	}

	@PostMapping("/userUpdate")
	public String userUpdatePost(UserVO userVO, RedirectAttributes rttr) {
		userVO.setPassword(passwordEncoder.encode(userVO.getPassword()));
		userMapper.updateUser(userVO);
		log.info("updated User : " + userVO);

		// 회원정보 수정시 알림창뜨게
		rttr.addFlashAttribute("result", "success");

		return "redirect:/user/mypage";
	}
	
	@GetMapping("/userDelete")
	public void userDeleteGet(Model model) {
		
	}
	
	@PostMapping("/userDelete")
	public String userDeleteGet(RedirectAttributes rttr) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication.getPrincipal() instanceof UserDetails) {
			UserDetails userDetails = (UserDetails)authentication.getPrincipal();
			String userId = userDetails.getUsername();
			userMapper.deleteUser(userId);
			log.info(userId+"님의 정보가 삭제되었습니다.");
		}
		
		rttr.addFlashAttribute("result","deleteSuccess");
		return "redirect:/";
	}

}
