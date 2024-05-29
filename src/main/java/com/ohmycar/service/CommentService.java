package com.ohmycar.service;

import java.util.List;

import com.ohmycar.domain.CommentVO;

public interface CommentService {
    void register(CommentVO comment);
    CommentVO get(Long id);
    boolean modify(CommentVO comment);
    boolean remove(Long id);
    List<CommentVO> getList(Long boardId);
	List<CommentVO> getCommentsByBoard(int bno);
	void writeComment(CommentVO comment);
}
