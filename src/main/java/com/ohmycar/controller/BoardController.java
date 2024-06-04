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
import com.ohmycar.domain.CommentVO;
import com.ohmycar.domain.UserVO;
import com.ohmycar.service.BoardService;
import com.ohmycar.service.CommentService;
import com.ohmycar.service.UserService;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController {

    private final BoardService boardService;
    private final UserService userService;
    private final CommentService commentService;

    private static final String USER_VO_STRING = "userVO";
    private static final String REDIRECT_BEFORE_PAGE = "redirect:/board/read";

    public BoardController(BoardService boardService, UserService userService, CommentService commentService) {
        this.boardService = boardService;
        this.userService = userService;
        this.commentService = commentService;
    }

    @GetMapping("/write")
    public String writeBoardPage(Model model) {
        log.info("Writing");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            UserVO userVO = userService.getUserByUserId(userDetails.getUsername());
            model.addAttribute(USER_VO_STRING, userVO);
            return "/board/write";
        } else {
            return "/board/list";
        }
    }

    @PostMapping("/write")
    public String writePost(BoardVO boardVO) {
        boardService.write(boardVO);
        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public void getList(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserVO userVO = userService.getUserByUserId(userDetails.getUsername());
        model.addAttribute(USER_VO_STRING, userVO);
        List<BoardVO> boardList = boardService.getAllPosts();
        model.addAttribute("boardList", boardList);
    }

    @PostMapping("/list")
    public void postList(Model model, BoardVO boardVO) {
        boardService.write(boardVO); // 게시글 작성 서비스 호출
        List<BoardVO> boardList = boardService.getAllPosts(); // 갱신된 게시글 목록을 다시 가져옴
        model.addAttribute("boardList", boardList); // 모델에 추가
    }

    // 게시글 읽기
    @GetMapping("/read")
    public String read(@RequestParam("bno") int bno, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserVO userVO = userService.getUserByUserId(userDetails.getUsername());
        model.addAttribute(USER_VO_STRING, userVO);
        BoardVO board = boardService.read(bno);
        model.addAttribute("board", board);

        // 게시글에 해당하는 댓글 목록을 가져옵니다.
        List<CommentVO> commentList = commentService.getCommentsByBoardId(bno);
        model.addAttribute("commentList", commentList);

        return "board/read";
    }

    @PostMapping("/comment")
    public String writeComment(@RequestParam("bno") int bno, @RequestParam("content") String content, Model model) {
        // 현재 사용자 정보 가져오기 (사용자 인증 및 사용자 정보 관리 로직에 따라 달라질 수 있음)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String writer = authentication.getName(); // 현재 사용자의 이름 또는 아이디

        // 댓글 객체 생성
        CommentVO comment = new CommentVO();
        comment.setBno(bno);
        comment.setContent(content);
        comment.setWriter(writer); // 작성자 설정

        // 댓글 서비스를 통해 댓글 작성
        commentService.writeComment(comment);

        // 게시글 읽기 페이지로 리다이렉트
        model.addAttribute("bno", bno);
        return REDIRECT_BEFORE_PAGE;
    }

    // BoardController.java

    @PostMapping("/comment/register")
    public String registerComment(CommentVO comment, Model model) {
        commentService.register(comment);
        model.addAttribute("bno", comment.getId());
        return REDIRECT_BEFORE_PAGE;
    }

    @PostMapping("/comment/modify")
    public String modifyComment(CommentVO comment, Model model) {
        commentService.modify(comment);
        model.addAttribute("bno", comment.getId());
        return REDIRECT_BEFORE_PAGE;
    }

    @PostMapping("/comment/remove")
    public String removeComment(@RequestParam("id") int id, @RequestParam("bno") int bno, Model model) {
        commentService.remove(id);
        model.addAttribute("bno", bno);
        return REDIRECT_BEFORE_PAGE;
    }

    @GetMapping("/modify")
    public String modify(@RequestParam("bno") int bno, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserVO userVO = userService.getUserByUserId(userDetails.getUsername());
        model.addAttribute(USER_VO_STRING, userVO);
        BoardVO board = boardService.read(bno);
        model.addAttribute("board", board);
        log.info("move to modify.jsp");
        return "board/modify";
    }

    @PostMapping("/modify")
    public String postModify(BoardVO boardVO, Model model) {
        boardService.modify(boardVO);
        model.addAttribute("bno", boardVO.getBno());
        return REDIRECT_BEFORE_PAGE + "?bno=" + boardVO.getBno(); // 수정된 게시글 읽기 페이지로 리다이렉트
    }

    @GetMapping("/delete")
    public String getDelete(@RequestParam("bno") int bno) {
        boardService.delete(bno);
        return "redirect:/board/list";
    }

}