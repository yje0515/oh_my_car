package com.ohmycar.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ohmycar.domain.AuthVO;
import com.ohmycar.domain.UserVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/security-context.xml" })
@Log4j
public class UserMapperTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	public void testGetUserList() {
		List<UserVO> list = userMapper.getUserList();

		list.forEach(user -> log.info(user));
	}

	/* 회원가입 테스트 */
	@Test
	public void testJoinUser() {
		/* String encodedPassword = passwordEncoder.encode("1234"); */
		UserVO vo = new UserVO();
		vo.setUserId("user01");
		vo.setUserName("박유저");
		vo.setPassword("1234");
		vo.setEmail("useruser@gmail.com");
		vo.setNickName("저유박");

		AuthVO authvo = new AuthVO();
		authvo.setUserId("user01");
		authvo.setAuth("ROLE_MEMBER");

		int result = userMapper.joinUser(vo) + userMapper.joinUserAuth(authvo);
		log.info(result);
	}

	@Test
	public void testGetUserByUserid() {
		UserVO vo = userMapper.getUserByUserId("user01");
		log.info(vo);
		log.info(vo.getAuthList());
	}

	@Test
	public void testGetUserByEmail() {
		String email = "useruser@gmail.com";
		log.info(userMapper.getUserByEmail(email));
	}

	@Test
	public void testUpdateUser() {
		UserVO vo = userMapper.getUserByEmail("useruser@gmail.com");
		vo.setPassword("1234");
		vo.setNickName("수정수정");

		int result = userMapper.updateUser(vo);
		log.info(result);

	}

	@Test
	public void testDeleteUser() {
		int result = userMapper.deleteUser("user6");
		log.info(result);
	}

	@Test
	public void testGetPassword() {
		String userid = "user1";
		String pwd = userMapper.userPasswordCheckByUserId(userid);
		log.info(pwd);
	}

	@Test
	public void testEncode() {
		log.info(passwordEncoder.encode("1234"));
	}

	@Test
	public void testIdDup() {
		if (userMapper.getUserByUserId("user1") != null) {
			log.info("이미 있는 아이디입니다.");
		} else {
			log.info("사용 가능한 아이디입니다.");
		}
	}
	
	@Test
	public void testLogin() {
		String userId = "admin82";
		String password = "pw82";
		if(passwordEncoder.matches(password,userMapper.userPasswordCheckByUserId(userId))) {
			log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@로그인 성공");
		}else {
			log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@로그인 실패!");
		}
	}
	
	@Test
	public void testDelete() {
		String userId = "admin1";
		log.info("삭제할 회원 아이디 : "+userId);
		if(userMapper.deleteUserAuth(userId)==1) {
			userMapper.deleteUser(userId);
		log.info(userId+"님 탈퇴완료.");
		}
		log.info("탈퇴 실패");
		
	}
}
