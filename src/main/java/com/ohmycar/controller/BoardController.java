package com.ohmycar.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ohmycar.domain.BoardVO;
import com.ohmycar.domain.Criteria;
import com.ohmycar.domain.UserDAO;
import com.ohmycar.domain.UserVO;
import com.ohmycar.service.BoardService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {

	private final BoardService boardService;
	private final UserDAO userDAO;

	private static final String REDIRECT_BEFORE_PAGE = "redirect:/user/mypage";// TODO 게시판 버튼 있는 곳으로 바꾸기

	public BoardController(BoardService boardService, UserDAO userDAO) {
		this.boardService = boardService;
		this.userDAO = userDAO;
	}

	@GetMapping("/write")
	public String writeBoardPage(Model model) {
		log.info("Writing");
		UserVO userVO = userDAO.getUser();
		if (userVO != null) {
			model.addAttribute("userVO", userVO);
			return "/board/write";
		} else {
			return REDIRECT_BEFORE_PAGE;
		}
	}

	@PostMapping("/write")
	public String writePost(BoardVO boardVO) {
		boardService.write(boardVO);
		return REDIRECT_BEFORE_PAGE;
	}

	@GetMapping("/list")
	public void getList(Criteria cri, Model model) {
		List<BoardVO> list = boardService.getList(cri);
		model.addAttribute("list", list);
	}

	@GetMapping("/read")
	public void read(@RequestParam("bno") int bno) {
		boardService.read(bno);
	}

	@GetMapping("/modify")
	public void modify(@RequestParam("board") BoardVO board, Model model) {
		model.addAttribute("board", board);
		log.info("move to modify.jsp");
	}

	@PostMapping("/modify")
	public String postModify(@RequestParam("board") BoardVO board, Model model) {
		boardService.modify(board);
		model.addAttribute("bno", board.getBno());
		return "/board/read";
	}

	@GetMapping("/delete")
	public String getDelete(@RequestParam("bno") int bno) {
		return REDIRECT_BEFORE_PAGE;
	}

}
