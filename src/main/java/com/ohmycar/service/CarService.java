package com.ohmycar.service;

import com.ohmycar.domain.CarVO;

public interface CarService {
//	CarVO getCarByCarId(String carId);

	void updateCar(CarVO carVO);

	CarVO getCarByUserId(String userId);
}
