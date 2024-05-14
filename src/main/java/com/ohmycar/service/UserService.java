package com.ohmycar.service;

import java.util.List;

import com.ohmycar.domain.AuthVO;
import com.ohmycar.domain.UserVO;

public interface UserService {
	// 회원목록 -관리자
	public List<UserVO> getUserList();

	// 회원가입 -userid username password email nickname
	public int joinUser(UserVO uservo);

	// 회원가입 -userid auth
	public int joinUserAuth(AuthVO authvo);

	// 로그인시 아이디로 비밀번호 확인
	public int userCheckByuserid(String userid,String password);

	
	
	// userid로 회원정보 불러오기
	public UserVO getUserByUserid(String userid);

	// email로 회원정보 불러오기
	public UserVO getUserByEmail(String email);

	// 회원정보 수정
	public int updateUser(UserVO uservo);

	// userid로 회원탈퇴
	public int deleteUser(String userid);
}
