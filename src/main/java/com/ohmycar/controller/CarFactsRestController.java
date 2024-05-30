package com.ohmycar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ohmycar.domain.CarFactsVO;
import com.ohmycar.service.CarFactsService;

@RequestMapping("/carFacts")
@RestController
public class CarFactsRestController {
	private final CarFactsService service;

	public CarFactsRestController(CarFactsService service) {
		this.service = service;
	}

	@GetMapping("/read")
	public String read() {
		return service.read();
	}

	@GetMapping("/read5")
	public List<CarFactsVO> read5() {
		List<CarFactsVO> list = new ArrayList<>();
		while (list.size() < 5) {
			String text = service.read();
			CarFactsVO vo = new CarFactsVO();
			vo.setFactText(text);
			if (!list.contains(vo)) {
				list.add(vo);
			}
		}
		return list;
	}
}
