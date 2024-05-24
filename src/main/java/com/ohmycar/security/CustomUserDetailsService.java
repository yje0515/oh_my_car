package com.ohmycar.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ohmycar.domain.UserVO;
import com.ohmycar.mapper.UserMapper;
import com.ohmycar.security.domain.CustomUser;

import lombok.extern.log4j.Log4j;

//Spring Security에서 사용자 인증 및 권한 부여를 위한 사용자 정의 서비스 구형
@Log4j
public class CustomUserDetailsService implements UserDetailsService {

	private final UserMapper userMapper;

	public CustomUserDetailsService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	// loadUserByUsername 메서드를 통해 사용자 이름을 입력, 입력받은 이름으로 DB에서 사용자 정보를 조회
	// 조회된 사용자 정보를 Spring Security의 UserDetails 객체로 변환하여 반환한다.
	// 여기서 username은 우리가 아는 userid
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// username => userid
		UserVO vo = userMapper.getUserByUserId(username);
		log.warn("Load User By UserName : " + username);

		if (vo == null) {
			log.warn("User not found");
			throw new UsernameNotFoundException("User not found with username : " + username);
		}
		return new CustomUser(vo);
	}

}
