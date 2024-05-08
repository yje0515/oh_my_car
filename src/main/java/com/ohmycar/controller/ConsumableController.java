package com.ohmycar.controller;

import com.ohmycar.domain.ConsumableCalc;
import com.ohmycar.domain.ConsumableVO;
import com.ohmycar.service.ConsumableService;

import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j
@RequestMapping("/consumable")
@Controller
public class ConsumableController {
    private final ConsumableService consumableService;
    private final ConsumableCalc calc;
    private static final String CAR_ID = "carId";

    public ConsumableController(ConsumableService consumableService) {
        this.consumableService = consumableService;
        this.calc = new ConsumableCalc();
    }

    @GetMapping("/read")
    public void read(@RequestParam("carId") String carId, Model model) throws Exception {
        log.info("reading..............................................................");
        ConsumableVO vo = consumableService.read(carId);
        log.info(vo);
        model.addAttribute("consumable", vo);
        model.addAttribute(CAR_ID, carId);

        ConsumableVO next = calc.getNextConsumableVO(consumableService.read(carId));

        model.addAttribute("changed", next);
    }

    @GetMapping("/modify")
    public void modify(@RequestParam("carId") String carId, Model model) {
        log.info("Modifying......................................................");
        ConsumableVO vo = consumableService.read(carId);
        log.info(vo);
        model.addAttribute("consumable", vo);
        model.addAttribute(CAR_ID, carId);
    }

    @PostMapping("/modify")
    public String modifyPost(ConsumableVO vo) {
        consumableService.modify(vo);
        return "redirect:/consumable/read?carId=" + vo.getCarId();
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("carId") String carId) {
        consumableService.delete(carId);
        return "redirect:/consumable/read?carId=" + carId;
    }

    @GetMapping("/create")
    public void getCreate(@RequestParam("carId") String carId, Model model) {
        log.info(carId);
        model.addAttribute(CAR_ID, carId);
    }

    @PostMapping("/create")
    public String create(@RequestParam("carId") String carId, ConsumableVO vo) {
        String accDist = calc.getAccDist();
        vo.setCarId(carId);
        consumableService.create(vo, accDist);
        return "redirect:/consumable/main";// TODO 주소 마이페이지로 바꿀 것
    }

}
