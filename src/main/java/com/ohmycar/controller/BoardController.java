package com.ohmycar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ohmycar.domain.BoardVO;
import com.ohmycar.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("")
	public String showBoardPage(Model model) {
		return "board";
	}

	@PostMapping("/write")
	public String writePost(BoardVO boardVO) {
		boardService.write(boardVO);
		return "redirect:/user/mypage";
	}

}
