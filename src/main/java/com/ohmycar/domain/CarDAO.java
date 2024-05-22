package com.ohmycar.domain;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ohmycar.domain.CarVO;
import org.apache.ibatis.exceptions.TooManyResultsException;

@Repository
public class CarDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String NAMESPACE = "com.ohmycar.mapper.CarMapper";

	public CarVO getCarByUserId(int userId) {
		List<CarVO> cars = sqlSession.selectList(NAMESPACE + ".getCarByUserId", userId);
		if (cars.size() == 1) {
			return cars.get(0);
		} else if (cars.isEmpty()) {
			return null; // 결과가 없는 경우
		} else {
			throw new TooManyResultsException("Expected one result (or null) but found multiple results.");
		}
	}
}
