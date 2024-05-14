package com.ohmycar.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

//로그인에 성공하면 오는 페이지
//Authentication 객체로 로그인한 사람의 정보 사용자의 이름 권한 인증된 시간 등을 알 수 있다.
@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// 사용자의 권한을 확인하고 이를 RoleNames 리스트에 추가
		log.warn("Login Success");
		List<String> roleNames = new ArrayList<String>();

		// authentication.getAuthorities() 메서드를 사용해서 사용자의 권한을 확인
		authentication.getAuthorities().forEach(authority -> roleNames.add(authority.getAuthority()));
		
		log.warn("ROLE NAMES : " + roleNames);

		// ROLE_ADMIN과 ROLE_MEMBER권한을 가진 사용자를 구분
		// 사용자 권한을 가져오는 메소드로 List roleNames에 해당 사용자 권한을 담고, 그에 따라 정해진 페이지로
		// redirect한다.
		
		if (roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/");
			return;
		}
		if (roleNames.contains("ROLE_MEMBER")) {
			response.sendRedirect("/");
			return;
		}
		
		response.sendRedirect("/");

		/* response.sendRedirect("/user/main"); */

	}

}
