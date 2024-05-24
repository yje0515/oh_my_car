package com.ohmycar.controller;

import java.util.List;

import org.springframework.ui.Model;
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
	public CarVO getRead(@RequestParam("carId") String carId, Model model) {
		log.info("getRead");
		return carService.getCarByCarId(carId);
	}

	@GetMapping("/cars")
	public List<CarVO> getCarsByUserId(String userId, Model model) {
		log.info("get car list");
		return carService.getCarsByUserId(userId);
	}
}
