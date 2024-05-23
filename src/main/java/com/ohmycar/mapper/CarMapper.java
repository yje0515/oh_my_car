package com.ohmycar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.ohmycar.domain.CarVO;

@Mapper
public interface CarMapper {
	// carId 로 차량 정보 CRUD

	public CarVO getCarByCarId(String carId);

	public List<CarVO> getCarsByUserId(String userId);

	public void updateCar(CarVO carVO);

	public int registerCar(CarVO carVO);

	public void deleteCar(String carId);
}
