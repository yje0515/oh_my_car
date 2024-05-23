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
    private static final String REDIRECT_MYPAGE = "redirect:/user/mypage";

    public ConsumableController(ConsumableService consumableService) {
        this.consumableService = consumableService;
        this.calc = new ConsumableCalc();
    }

    /**
     * 부품 정보 언제 교체 했는지 언제 교체하면 되는지 알려주는 read.html 로 보내는 함수
     * 
     * @param carId 차 고유 번호
     * @param model http 해더에 쏠 model 객체
     * @throws Exception
     */
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

    /***
     * 부품 정보 즉 교체 시기를 업데이트 하는 modify.html 로 보내는 함수
     * 
     * @param carId 차 고유 번호
     * @param model 모델 객체
     */
    @GetMapping("/modify")
    public void modify(@RequestParam("carId") String carId, Model model) {
        log.info("Modifying......................................................");
        ConsumableVO vo = consumableService.read(carId);
        log.info(vo);
        model.addAttribute("consumable", vo);
        model.addAttribute(CAR_ID, carId);
    }

    /***
     * 교체 시기를 업데이트 하기 위해 service 를 통하기 위한 post mapping 함수
     * 
     * @param vo 부품 정보를 담은 VO
     * @return 되돌아가기 이 경우 read.html 로 돌아간다.
     */
    @PostMapping("/modify")
    public String modifyPost(ConsumableVO vo) {
        consumableService.modify(vo);
        return "redirect:/consumable/read?carId=" + vo.getCarId();
    }

    /**
     * 해당 페이지의 consumableVO 를 DB에서 삭제하는 함수
     * 
     * @param carId 해당하는 차 고유번호
     * @return 마이페이지로 돌아간다.
     */
    @GetMapping("/remove")
    public String remove(@RequestParam("carId") String carId) {
        consumableService.delete(carId);
        return REDIRECT_MYPAGE;
    }

    /**
     * 부품 교체 시기를 담은 consumableVO 를 만들기 위해 create.html 로 보내는 함수
     * 
     * @param carId 차 고유 번호
     * @param model 모델 객체
     * @param token 현대차 api 에서 가져온 token
     */
    @GetMapping("/create")
    public void getCreate(@RequestParam("carId") String carId, Model model, String token) {
        log.info(carId);
        model.addAttribute(CAR_ID, carId);
        model.addAttribute("token", token);
    }

    /**
     * 부품 교체 시기를 담은 consumableVO 를 DB에 저장 하는 함수
     * 
     * @param carId 차 고유 번호
     * @param vo    consumableVO 부품 교체시기를 담았다
     * @param token 현대차 api 에서 가져온 token
     * @return 마이페이지로 돌아간다.
     */
    @PostMapping("/create")
    public String create(@RequestParam("carId") String carId, ConsumableVO vo, String token, String accDist) {
        String tokenTemp = "Bearer "
                + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1aWQiOiI2NjRkYWZjZC05NmVhLTRhZjctOGI0MC1iYTYyNzgwNzI4ODciLCJpc3MiOiJibHVlbGluayIsInBpZCI6IjYyYTk3NmZhYmI4YjVkZTg5YzYzYjhmYiIsImV4cCI6NDEwMjMyNjAwMCwibGF0IjoxNzE1MTI4NDkzLCJzaWQiOiI0MDBiMzIzMS0zMGRiLTQyZjUtYWI1Mi05ZDY5YjM1YTE4NGQifQ.pZuBsie3in_l-TqVBtFPlXWgvQHbbF62yVPRfZvaJ0CCthBAlgp0Au4yxIt9ETE1S5O86EVi2y7VnkWstig-zo3pNW4BT22snQ-GshmSJ_NfOf_s5ollcqjNdqKNVmF588xP9pdWKnBB3hb_YLZLFGhUDjGaOI684mq4CCZ7V_vggTlaaXZZ6ycNvk58WhT5cpKccfHa6KkTFJhFwOJiKaG-z6snhPO33RIuNxwtrC7AikVu4B71guIJmBHcZ31HPjqVcAZwU2AR3eLNCk7XHdFFZR2gQUpGvaw81ECd1F48LSnvAY60MrsyH-nnO_sxNI8sakqGuMoSv8_Le_J5Qw";
        String accDistTemp = token != null ? calc.getAccDist(tokenTemp, carId) : accDist;
        vo.setCarId(carId);
        consumableService.create(vo, accDistTemp);
        return REDIRECT_MYPAGE;
    }

    /**
     * 정비소나 주유소를 지도에 보여주는 map.html 로 들어가는 함수
     * 
     * @param carId   차 고유번호 되돌아가기 할때 필요하다.
     * @param keyWord 주유소 인지 정비소인지 정하기 위해 받아오는 파라미터
     * @param model   모델 객체
     */
    @GetMapping("/map")
    public void showMap(String carId, @RequestParam("keyWord") String keyWord, Model model) {
        log.info("showMap");
        model.addAttribute(CAR_ID, carId);
        model.addAttribute("keyWord", keyWord);
    }

}
