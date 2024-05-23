package com.ohmycar.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ohmycar.domain.BoardVO;
import com.ohmycar.domain.Criteria;
import com.ohmycar.domain.UserVO;
import com.ohmycar.service.BoardService;
import com.ohmycar.service.UserService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {

	private final BoardService boardService;
	private final UserService userService;

	private static final String REDIRECT_BEFORE_PAGE = "redirect:/user/mypage";// TODO 게시판 버튼 있는 곳으로 바꾸기

	public BoardController(BoardService boardService, UserService userService) {
		this.boardService = boardService;
		this.userService = userService;
	}

	@GetMapping("/board")
	public String showBoardPage(Model model) {
		return "/board/board";
	}

	@PostMapping("/write")
	public String writePost(BoardVO boardVO) {
		boardService.write(boardVO);
		return "redirect:/board/list";
	}

}
