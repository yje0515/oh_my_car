package com.ohmycar.mapper;

import java.util.List;

import com.ohmycar.domain.AuthVO;
import com.ohmycar.domain.UserVO;

public interface UserMapper {
	// 회원목록 -관리자
	public List<UserVO> getUserList();

	// 회원가입 insert
	public int joinUser(UserVO uservo);

	// 회원가입 회원등급 insert
	public int joinUserAuth(AuthVO authvo);

	//회원가입시 아이디중복확인
	public int joinIdCheck(String userid);

	//로그인시 아이디로 비밀번호 확인
	public String userPasswordCheckByUserid(String userid);
	
	
	
	// userid로 회원정보 불러오기
	public UserVO getUserByUserid(String userid);

	// email로 회원정보 불러오기
	public UserVO getUserByEmail(String email);

	// 회원정보 수정
	public int updateUser(UserVO uservo);

	// userid로 회원탈퇴
	public int deleteUser(String userid);
}
