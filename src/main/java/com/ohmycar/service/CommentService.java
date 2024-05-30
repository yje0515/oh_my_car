package com.ohmycar.service;

import java.util.List;
import com.ohmycar.domain.CommentVO;

public interface CommentService {
	List<CommentVO> getCommentsByBoardId(int bno);

	void writeComment(CommentVO comment);

	void register(CommentVO comment);

	void modify(CommentVO comment);

	void remove(int id);
}
