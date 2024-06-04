package com.ohmycar.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ohmycar.domain.CarVO;
import com.ohmycar.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carInfoAPI")
@RequiredArgsConstructor
@Log4j
public class CarRestController {

    private final CarService carService;

    @GetMapping("/read")
    public CarVO getReadAPI(@RequestParam("carId") String carId) {
        log.info("getRead");
        return carService.getCarByCarId(carId);
    }

    @GetMapping("/cars")
    public List<CarVO> getCarsByUserIdAPI(@RequestParam("userId") String userId) {
        log.info("get car list");
        return carService.getCarsByUserId(userId);
    }
}
