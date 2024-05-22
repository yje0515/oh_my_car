package com.ohmycar.service;

import com.ohmycar.domain.BoardVO;

import java.util.List;

public interface BoardService {

	void write(BoardVO boardVO);
	// 필요에 따라 다른 메서드를 추가할 수 있습니다.

	public List<BoardVO> getAllPosts();
}
