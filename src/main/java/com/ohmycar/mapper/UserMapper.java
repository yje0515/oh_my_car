package com.ohmycar.mapper;

import java.util.List;

import com.ohmycar.domain.AuthVO;
import com.ohmycar.domain.UserVO;

public interface UserMapper {
	
	// 회원목록 -관리자
	public List<UserVO> getUserList();

	// 회원가입 insert
	public int joinUser(UserVO userVO);

	// 회원가입 회원등급 insert
	public int joinUserAuth(AuthVO authVO);

	//회원가입시 아이디중복확인
	public int joinIdCheck(String userId);

	//아이디로 비밀번호 확인
	public String userPasswordCheckByUserId(String userId);
	
	
	
	// userId로 회원정보 불러오기
	public UserVO getUserByUserId(String userId);

	// email로 회원정보 불러오기
	public UserVO getUserByEmail(String email);

	// 회원정보 수정
	public int updateUser(UserVO userVO);

	// userId로 회원탈퇴
	public int deleteUser(String userId);
	public int deleteUserAuth(String userId);
}
