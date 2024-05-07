package com.ohmycar.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohmycar.domain.ConsumableVO;
import com.ohmycar.service.ConsumableCycle;
import com.ohmycar.service.ConsumableService;

import lombok.extern.log4j.Log4j;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    public ConsumableController(ConsumableService consumableService) {
        this.consumableService = consumableService;
    }

    private String calcChangeDay(String before, String cycle, char op) {
        if (op == 'y') {
            int next = (int) (Double.parseDouble(cycle) * 12);
            LocalDate date = LocalDate.parse(before, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            date = date.plusMonths(next);
            return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } else if (op == 'k') {
            double beforeNum = Double.parseDouble(before);
            double cycleNum = Double.parseDouble(cycle);
            double next = beforeNum + cycleNum;
            return String.valueOf(next);
        } else {
            return "unknown";
        }
    }

    @GetMapping("/read")
    public void read(@RequestParam("carId") String carId, Model model) throws Exception {
        log.info("reading..............................................................");
        ConsumableVO vo = consumableService.read(carId);
        log.info(vo);
        model.addAttribute("consumable", vo);
        model.addAttribute("carId", carId);

        InputStream input = new FileInputStream(
                "c:/SpringWorkSpace/oh_my_car/src/main/webapp/resources/json/consumableCycle.json");
        ObjectMapper objectMapper = new ObjectMapper();
        ConsumableCycle consumableCycle = objectMapper.readValue(input, ConsumableCycle.class);

        ConsumableVO next = consumableService.read(carId);
        String st = consumableCycle.getAirConFilter();
        next.setAirConFilter(
                calcChangeDay(next.getAirConFilter(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getBattery();
        next.setBattery(
                calcChangeDay(next.getBattery(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getBreakOil();
        next.setBreakOil(
                calcChangeDay(next.getBreakOil(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getBreakPad();
        next.setBreakPad(
                calcChangeDay(next.getBreakPad(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getCoolingWater();
        next.setCoolingWater(
                calcChangeDay(next.getCoolingWater(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getEngineOil();
        next.setEngineOil(
                calcChangeDay(next.getEngineOil(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getFluidClutch();
        next.setFluidClutch(
                calcChangeDay(next.getFluidClutch(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getPowerSteeringOil();
        next.setPowerSteeringOil(
                calcChangeDay(next.getPowerSteeringOil(), st.substring(0, st.length() - 1),
                        st.charAt(st.length() - 1)));
        st = consumableCycle.getSparkPlug();
        next.setSparkPlug(
                calcChangeDay(next.getSparkPlug(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getTire();
        next.setTire(
                calcChangeDay(next.getTire(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getTransmissionOil();
        next.setTransmissionOil(
                calcChangeDay(next.getTransmissionOil(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getWiper();
        next.setWiper(
                calcChangeDay(next.getWiper(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));

        model.addAttribute("changed", next);
    }

    @GetMapping("/modify")
    public void modify(@RequestParam("carId") String carId, Model model) {
        log.info("Modifying......................................................");
        ConsumableVO vo = consumableService.read(carId);
        log.info(vo);
        model.addAttribute("consumable", vo);
        model.addAttribute("carId", carId);
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
    // TODO insert 구문을 만들어야 하는데 이때 현대 API 에서 누적 주행거리를 받아와야 한다. 자바 에서 GET 쏘는 법 찾아보자
}
