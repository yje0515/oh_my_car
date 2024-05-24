package com.ohmycar.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ohmycar.domain.UserVO;
import com.ohmycar.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	private final UserService userService;

	public HomeController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping(value = "/")
	public String home(Locale locale, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object o = authentication.getPrincipal();
		UserDetails userDetails = o.getClass() == UserDetails.class ? (UserDetails) o : null;
		UserVO userVO = userDetails != null ? userService.getUserByUserId(userDetails.getUsername()) : new UserVO();
		if (userVO != null) {
			model.addAttribute("userVO", userVO);
		}
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "home";
	}

}
