package com.ohmycar.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@PostMapping("/delete")
	public ResponseEntity<String> deleteCarFacts(@RequestBody List<Integer> carFactIds) {
		for (Integer carFactId : carFactIds) {
			service.delete(carFactId);
		}
		return ResponseEntity.ok("delete success");
	}
}
