package com.ohmycar.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ohmycar.domain.CarVO;
import com.ohmycar.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/carInfo/")
@RequiredArgsConstructor
@Log4j
public class CarController {

	private final CarService carService;

	private static final String REDIRECT_MYPAGE = "redirect:/user/mypage";

	// Register 페이지에 대한 GET 요청을 처리하는 메서드 추가 차량추가 기능
	@GetMapping("/register")
	public void showRegisterPage() {
		log.info("Register");
	}

	@PostMapping("/register")
	public String handleCarRegistration(CarVO car, RedirectAttributes redirectAttributes) {

		boolean isSuccess = carService.registerCar(car);
		if (isSuccess) {
			redirectAttributes.addFlashAttribute("successMessage", "자동차가 성공적으로 등록되었습니다.");
		} else {
			log.info("failed to register car");
			redirectAttributes.addFlashAttribute("errorMessage", "자동차 등록 중 오류가 발생했습니다.");
		}

		return REDIRECT_MYPAGE;
	}

	@GetMapping("/carUpdate") // 자동차 차종 변경기능
	public String carUpdateGet(CarVO carVO, Model model) {
		model.addAttribute("carVO", carVO);
		return "/carInfo/update"; // 차량 정보 업데이트 페이지로 이동
	}

	@PostMapping("/carUpdate")
	public String carUpdatePost(CarVO carVO, RedirectAttributes rttr) {
		carService.updateCar(carVO);
		rttr.addFlashAttribute("result", "success");
		return REDIRECT_MYPAGE; // 수정 후 마이페이지로 이동
	}

	@GetMapping("/read")
	public void getRead(@RequestParam("carId") String carId, Model model) {
		CarVO carVO = carService.getCarByCarId(carId);
		model.addAttribute("car", carVO);
	}

	@GetMapping("/cars")
	public void getCarsByUserId(String userId, Model model) {
		List<CarVO> cars = carService.getCarsByUserId(userId);
		model.addAttribute("cars", cars);
	}

	@GetMapping("/delete")
	public String getDelete(@RequestParam("carId") String carId) {
		carService.deleteCar(carId);
		return REDIRECT_MYPAGE; // 삭제 후 마이페이지로 이동
	}

}
