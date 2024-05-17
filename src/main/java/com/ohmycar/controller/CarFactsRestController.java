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
        return service.read();// TODO 자동차 토막 상식을 넣고 싶은 페이지 에서 /carFacts/read 를 ajax 로 부르든 해서 반환 받은 String 을 쏴 주기.
    }

}
