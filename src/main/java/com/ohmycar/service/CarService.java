package com.ohmycar.service;

import com.ohmycar.domain.CarVO;

public interface CarService {

	void updateCar(CarVO carVO);

	CarVO getCarByUserId(String userId);

	void registerCar(CarVO carVO);
}
