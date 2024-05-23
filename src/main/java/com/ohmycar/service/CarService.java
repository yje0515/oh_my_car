package com.ohmycar.service;

import com.ohmycar.domain.CarVO;

public interface CarService {

	void updateCar(CarVO carVO);

	CarVO getCarByCarId(String carId);

	boolean registerCar(CarVO carVO);

	void deleteCar(String carId);
}
