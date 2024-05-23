package com.ohmycar.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
	public void showRegisterPage(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		CarVO carVO = carService.getCarByCarId(userDetails.getUsername());
		model.addAttribute("carVO", carVO);
	}

	@PostMapping("/register")
	public String handleCarRegistration(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		String username = userDetails.getUsername();

		String carId = request.getParameter("carId");
		String carSellName = request.getParameter("carSellName");
		String carName = request.getParameter("carName");
		String carType = request.getParameter("carType");

		CarVO carVO = new CarVO();
		carVO.setUserId(username);
		carVO.setCarId(carId);
		carVO.setCarSellName(carSellName);
		carVO.setCarName(carName);
		carVO.setCarType(carType);

		boolean isSuccess = carService.registerCar(carVO);
		if (isSuccess) {
			redirectAttributes.addFlashAttribute("successMessage", "자동차가 성공적으로 등록되었습니다.");
		} else {
			log.info("failed to register car");
			redirectAttributes.addFlashAttribute("errorMessage", "자동차 등록 중 오류가 발생했습니다.");
		}

		return REDIRECT_MYPAGE;
	}

	@GetMapping("/carUpdate") // 자동차 차종 변경기능
	public String carUpdateGet(HttpServletRequest request, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		String userId = userDetails.getUsername();

		CarVO carVO = carService.getCarByCarId(userId);
		model.addAttribute("carVO", carVO);
		return "/user/carUpdate"; // 차량 정보 업데이트 페이지로 이동
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

	@GetMapping("/delete")
	public String getDelete(@RequestParam("carId") String carId) {
		carService.deleteCar(carId);
		return REDIRECT_MYPAGE; // 삭제 후 마이페이지로 이동
	}

}
