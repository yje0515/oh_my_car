package com.ohmycar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ohmycar.domain.CarFactsVO;
import com.ohmycar.service.CarFactsService;

import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j
@RequestMapping("/carFacts")
@Controller
public class CarFactsController {
    private final CarFactsService service;
    private static final String REDIRECT_LIST = "redirect:/carFacts/list";

    public CarFactsController(CarFactsService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public void getList(Model model) {
        log.info("Getting List of CarFacts");
        model.addAttribute("list", service.getAll());
    }

    @PostMapping("/create")
    public String create(@RequestParam String factText) {
        CarFactsVO vo = new CarFactsVO();
        vo.setFactText(factText);
        service.create(vo);
        return REDIRECT_LIST;
    }

    @GetMapping("/delete")
    public String delete(String factId) {
        service.delete(Integer.parseInt(factId));
        return REDIRECT_LIST;
    }

    @PostMapping("/modify")
    public String modify(CarFactsVO vo) {
        service.modify(vo);
        return REDIRECT_LIST;
    }
}
