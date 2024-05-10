package com.ohmycar.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j
@Controller
public class UserController {
    /**
     * 마이페이지 대신 만든 main.html 임시이며 나중에 마이페이지로 바꿔야한다.
     * TODO 마이페이지로 바꾸기
     */
    @GetMapping("/consumable/main")
    public void getMethodName() {
        log.info("......................................");
    }

}
