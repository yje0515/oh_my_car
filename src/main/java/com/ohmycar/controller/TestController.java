package com.ohmycar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequiredArgsConstructor
@Log4j
public class TestController {

	@GetMapping("/main")
	public void mainGet() {
		log.info("main....");
	}
}
