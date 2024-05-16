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

	private final PasswordEncoder passwordEncoder;

	@Override
	public List<UserVO> getUserList() {
		return mapper.getUserList();
	}

	@Override
	public int joinUser(UserVO userVO) {
		return mapper.joinUser(userVO);
	}

	@Override
	public int joinUserAuth(AuthVO authvo) {
		return mapper.joinUserAuth(authvo);
	}

	@Override
	public int userCheckByUserId(String userId, String password) {
		int result = 0;
		String pwd = mapper.userPasswordCheckByUserId(userId);// 아이디로 비밀번호 받아옴
		boolean passwordCheck = passwordEncoder.matches(password, pwd);
		if (passwordCheck) {
			result = 1;
		} else {
			result = 0;
		}
		log.info("result <<<<<<<<<<<<<<" + result);
		return result;
	}

	@Override
	public UserVO getUserByUserId(String userId) {
		return mapper.getUserByUserId(userId);
	}

	@Override
	public UserVO getUserByEmail(String email) {
		return mapper.getUserByEmail(email);
	}

	@Override
	public int updateUser(UserVO userVO) {
		return mapper.updateUser(userVO);
	}

	@Override
	public int deleteUser(String userId) {
		return mapper.deleteUser(userId);
	}

}
