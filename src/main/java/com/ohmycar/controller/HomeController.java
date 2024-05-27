package com.ohmycar.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ohmycar.domain.CarFactsVO;
import com.ohmycar.domain.UserVO;
import com.ohmycar.service.CarFactsService;
import com.ohmycar.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	private final UserService userService;

	private final CarFactsService carFactsService;

	public HomeController(UserService userService, CarFactsService carFactsService) {
		this.userService = userService;
		this.carFactsService = carFactsService;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping(value = "/")
	public String home(Locale locale, Model model) {

		// 인증된 사용자 정보 불러와서 userVO객체에 담아준다.
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getPrincipal() instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			UserVO userVO = userService.getUserByUserId(userDetails.getUsername());
			model.addAttribute("userVO", userVO);
		}

		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		
		
		List<CarFactsVO> randomCarFacts = carFactsService.getRandom();
		model.addAttribute("randomCarFacts",randomCarFacts);
		return "home";
	}

}