package com.ohmycar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ohmycar.service.CarFactsService;

import org.springframework.web.bind.annotation.GetMapping;

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

}
