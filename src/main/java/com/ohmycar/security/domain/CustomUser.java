package com.ohmycar.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.ohmycar.domain.UserVO;

import lombok.Getter;

@Getter
public class CustomUser extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private UserVO userVO;

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public CustomUser(UserVO VO) {

		super(VO.getUserId(), VO.getPassword(), VO.getAuthList().stream()
				.map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));

		this.userVO = VO;
	}

}
