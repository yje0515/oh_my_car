package com.ohmycar.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ohmycar.domain.UserVO;
import com.ohmycar.mapper.UserMapper;
import com.ohmycar.security.domain.CustomUser;

import lombok.extern.log4j.Log4j;

//Spring SEcurity에서 사용자 인증 및 권한 부여를 위한 사용자 정의 서비스 구형
@Log4j
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserMapper usermapper;

	//loadUserByUsername 메서드를 통해 사용자 이름을 입력, 입력받은 이름으로 DB에서 사용자 정보를 조회
	//조회된 사용자 정보를 Spring Security의 UserDetails 객체로 변환하여 반환한다.
	//여기서 username은 우리가 아는 userid
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("Load User By UserName : "+username);

		//username => userid
		UserVO vo = usermapper.getUserByUserid(username);
		log.warn("queried by user mapper : "+vo);
		return vo == null ? null : new CustomUser(vo);
	}
	
	
}
