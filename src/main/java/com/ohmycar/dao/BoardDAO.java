package com.ohmycar.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ohmycar.domain.BoardVO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String NAMESPACE = "com.ohmycar.mapper.BoardMapper";

	public void write(BoardVO board) {
		try {
			// MyBatis를 사용하여 INSERT 쿼리를 실행합니다.
			// Mapper 인터페이스의 write 메서드를 호출하고, BoardVO 객체를 전달합니다.
			sqlSession.insert(NAMESPACE + ".write", board);
		} catch (Exception e) {
			e.printStackTrace();
			// 예외 처리
		}
	}
}