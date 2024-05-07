package com.ohmycar.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j
@Controller
public class UserController {
    @GetMapping("/consumable/main")
    public void getMethodName() {
        log.info("......................................");
    }

}
