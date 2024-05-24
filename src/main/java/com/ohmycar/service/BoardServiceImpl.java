package com.ohmycar.service;

import org.springframework.stereotype.Service;

import com.ohmycar.domain.BoardVO;
import com.ohmycar.domain.Criteria;
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
	public List<BoardVO> getList(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}

	@Override
	public void delete(int bno) {
		mapper.delete(bno);
	}

	@Override
	public void modify(BoardVO boardVO) {
		mapper.update(boardVO);
	}

	@Override
	public BoardVO read(int bno) {
		return mapper.read(bno);
	}
}
