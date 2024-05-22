package com.ohmycar.service;

import java.util.List;

import com.ohmycar.domain.AuthVO;
import com.ohmycar.domain.UserVO;


public interface UserService {
	
	// 회원목록 -관리자
	public List<UserVO> getUserList();

	// 회원가입 
	public int joinUser(UserVO userVO);

	// 회원가입 
	public int joinUserAuth(AuthVO authVO);

	// 아이디로 비밀번호 확인
	public int userCheckByUserId(String userId,String password);

	
	
	// userId로 회원정보 불러오기
	public UserVO getUserByUserId(String userId);

	// email로 회원정보 불러오기
	public UserVO getUserByEmail(String email);

	// 회원정보 수정
	public int updateUser(UserVO userVO);

	// userId로 회원탈퇴
	public int deleteUser(String userId);
}
