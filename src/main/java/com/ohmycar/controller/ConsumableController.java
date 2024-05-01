package com.ohmycar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

import org.springframework.web.bind.annotation.GetMapping;

@RequestMapping("consumable")
@RestController
@Log4j
public class ConsumableController {
    @GetMapping("/read")
    public void read() {
        log.info("read");
    }

}
