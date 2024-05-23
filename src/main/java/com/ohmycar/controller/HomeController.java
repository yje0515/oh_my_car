package com.ohmycar.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ohmycar.domain.UserDAO;
import com.ohmycar.domain.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	private final UserDAO userDAO;

	public HomeController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping(value = "/")
	public String home(Locale locale, Model model) {

		// 인증된 사용자 정보 불러와서 userVO객체에 담아준다.
		UserVO userVO = userDAO.getUser();
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
