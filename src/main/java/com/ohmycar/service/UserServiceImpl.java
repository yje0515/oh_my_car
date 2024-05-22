package com.ohmycar.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ohmycar.domain.AuthVO;
import com.ohmycar.domain.UserVO;
import com.ohmycar.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;

	private final PasswordEncoder passwordEncoder;

	@Override
	public List<UserVO> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void joinUser(UserVO userVO,AuthVO authVO) {
		userVO.setPassword(passwordEncoder.encode(userVO.getPassword()));
		userMapper.joinUser(userVO);
		userMapper.joinUserAuth(authVO);

		// 이용자의 권한이 Admin인 경우 Member의 권한도 가질 수 있음
		if (authVO.getAuth().equals("ROLE_ADMIN")) {
			AuthVO authAdmin = new AuthVO();
			authAdmin.setUserId(authVO.getUserId());
			authAdmin.setAuth("ROLE_MEMBER");
			userMapper.joinUserAuth(authAdmin);
		}
	}


	@Override
	public String joinIdCheck(String userId) {
		return userMapper.joinIdCheck(userId);
	}
	
	@Override
	public String joinEmailCheck(String email) {
		return userMapper.joinEmailCheck(email);
	}

	@Override
	public String userPasswordCheckByUserId(String userId) {
		return userMapper.userPasswordCheckByUserId(userId);
	}

	@Override
	public UserVO getUserByUserId(String userId) {
		return userMapper.getUserByUserId(userId);
	}

	@Override
	public UserVO getUserByEmail(String email) {
		return userMapper.getUserByEmail(email);
	}

	@Override
	public int updateUser(UserVO userVO) {
		userVO.setPassword(passwordEncoder.encode(userVO.getPassword()));
		return userMapper.updateUser(userVO);
	}

	@Override
	public void deleteUser(String userId) {
		userMapper.deletePersistentLogins(userId); //자동로그인정보삭제
		userMapper.deleteUserAuth(userId);//자식테이블(fk) 먼저 삭제
		userMapper.deleteUser(userId);//부모테이블(pk)나중에 삭제
	}

}
