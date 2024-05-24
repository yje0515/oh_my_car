package com.ohmycar.service;

import com.ohmycar.domain.BoardVO;
import com.ohmycar.domain.Criteria;

import java.util.List;

public interface BoardService {

	public void write(BoardVO boardVO);

	public List<BoardVO> getList(Criteria cri);

	public BoardVO read(int bno);

	public void modify(BoardVO boardVO);

	public void delete(int bno);
}
