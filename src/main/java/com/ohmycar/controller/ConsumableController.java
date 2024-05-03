package com.ohmycar.controller;

import com.ohmycar.domain.ConsumableVO;
import com.ohmycar.service.ConsumableService;

import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j
@RequestMapping("/consumable")
@Controller
public class ConsumableController {
    private final ConsumableService consumableService;

    public ConsumableController(ConsumableService consumableService) {
        this.consumableService = consumableService;
    }

    @GetMapping("/read")
    public void read(@RequestParam("carId") String carId, Model model) {
        log.info("reading..............................................................");
        ConsumableVO vo = consumableService.read(carId);
        log.info(vo);
        model.addAttribute("consumable", vo);
    }

}
