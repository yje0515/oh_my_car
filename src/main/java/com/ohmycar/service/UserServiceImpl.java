package com.ohmycar.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ohmycar.domain.AuthVO;
import com.ohmycar.domain.UserVO;
import com.ohmycar.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserMapper mapper;
	
	/* private final PasswordEncoder passwordEncoder; */
	
	private final PasswordEncoder passwordEncoder;

	@Override
	public List<UserVO> getUserList() {
		return mapper.getUserList();
	}

	@Override
	public int joinUser(UserVO uservo) {
		return mapper.joinUser(uservo);
	}

	@Override
	public int joinUserAuth(AuthVO authvo) {
		return mapper.joinUserAuth(authvo);
	}

	@Override
	public int userCheckByuserid(String userid,String password) {
		int result = 0;
		String pwd = mapper.userPasswordCheckByUserid(userid);//아이디로 비밀번호 받아옴
		boolean passwordCheck = passwordEncoder.matches(password, pwd);
		if(passwordCheck) {
			result=1;
		}else {
			result=0;
		}
		log.info("result <<<<<<<<<<<<<<"+result);
		return result; 
	}
	

	@Override
	public UserVO getUserByUserid(String userid) {
		return mapper.getUserByUserid(userid);
	}

	@Override
	public UserVO getUserByEmail(String email) {
		return mapper.getUserByEmail(email);
	}

	@Override
	public int updateUser(UserVO uservo) {
		return mapper.updateUser(uservo);
	}

	@Override
	public int deleteUser(String userid) {
		return mapper.deleteUser(userid);
	}

}
