package com.ohmycar.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.ohmycar.domain.CarVO;

@Mapper
public interface CarMapper {
	// userId로 회원정보 불러오기

	public CarVO getCarByUserId(String userId);

	public void updateCar(CarVO carVO);
}
