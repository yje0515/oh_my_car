package com.ohmycar.service;

import java.util.List;

import com.ohmycar.domain.CarVO;

public interface CarService {

    void updateCar(CarVO carVO);

    CarVO getCarByCarId(String carId);

    List<CarVO> getCarsByUserId(String userId);

    boolean registerCar(CarVO carVO);

    void deleteCar(String carId);
}
