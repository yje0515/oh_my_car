package com.ohmycar.mapper;

import java.util.List;

import com.ohmycar.domain.BoardVO;

public interface BoardMapper {
	public List<BoardVO> getAllPosts();

	public void write(BoardVO boardVO);
}
