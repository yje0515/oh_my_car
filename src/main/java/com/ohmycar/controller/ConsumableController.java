package com.ohmycar.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ohmycar.service.ConsumableService;

import lombok.extern.log4j.Log4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Log4j
@RequestMapping("/consumable")
public class ConsumableController {
    private final ConsumableService consumableService;

    public ConsumableController(ConsumableService consumableService) {
        this.consumableService = consumableService;
    }

    @GetMapping("/read")
    public void read() {
        log.info("read");
    }

}
