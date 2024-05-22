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
    public CarVO getCarByUserId(String userId) {
        return carMapper.getCarByUserId(userId);
    }

    @Override
    public void updateCar(CarVO carVO) {
        carMapper.updateCar(carVO);
    }
    
    @Override
    public void registerCar(CarVO carVO) {
    	carMapper.registerCar(carVO);
    }
}
