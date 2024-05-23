package com.ohmycar.service;

import org.springframework.stereotype.Service;
import com.ohmycar.domain.CarVO;
import com.ohmycar.mapper.CarMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarMapper carMapper;

    @Override
    public CarVO getCarByCarId(String carId) {
        return carMapper.getCarByCarId(carId);
    }

    @Override
    public void updateCar(CarVO carVO) {
        carMapper.updateCar(carVO);
    }

    @Override
    public boolean registerCar(CarVO carVO) {
        return carMapper.registerCar(carVO) > 0;
    }

    @Override
    public void deleteCar(String carId) {
        carMapper.deleteCar(carId);
    }

}
