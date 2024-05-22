package com.ohmycar.security;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/security-context.xml" })
@Log4j
public class MemberTest {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private DataSource dataSource;
	
	
	@Test
	public void testInsertMember() {
		String sql = "INSERT INTO user_tbl(userid,username,password,email,nickname)VALUES(?,?,?,?,?)";
		for (int i = 0; i < 100; i++) {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				// 바인딩변수 3번째 자리(password)
				pstmt.setString(3, passwordEncoder.encode("pw" + i));
				if (i < 80) {
					pstmt.setString(1, "user" + i);
					pstmt.setString(2, "name" + i);
					pstmt.setString(4, "email" + i);
					pstmt.setString(5, "일반" + i);

				} else {
					pstmt.setString(1, "admin" + i);
					pstmt.setString(2, "name" + i);
					pstmt.setString(4, "email" + i);
					pstmt.setString(5, "관리자" + i);
				}
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (Exception e) {
						e.addSuppressed(e);
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.addSuppressed(e);
					}
				}
			}
		}
	}

	@Test
	public void testInsertAuth() {
		String sql = "INSERT INTO user_auth_tbl (userid,auth) VALUES(?,?)";
		for (int i = 0; i < 100; i++) {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				if (i < 80) {
					pstmt.setString(1, "user" + i);
					pstmt.setString(2, "ROLE_MEMBER");
				} else {
					pstmt.setString(1, "admin" + i);
					pstmt.setString(2, "ROLE_ADMIN");
				}
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (Exception e) {
						e.addSuppressed(e);
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.addSuppressed(e);
					}
				}
			}
		} // end for
	}

}
