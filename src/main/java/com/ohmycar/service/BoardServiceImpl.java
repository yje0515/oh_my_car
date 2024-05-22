package com.ohmycar.service;

import org.springframework.stereotype.Service;

import com.ohmycar.domain.BoardVO;
import com.ohmycar.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardMapper mapper;

	@Override
	public void write(BoardVO board) {
		mapper.write(board);
	}

	@Override
	public List<BoardVO> getAllPosts() {
		return mapper.getAllPosts();
	}
}
