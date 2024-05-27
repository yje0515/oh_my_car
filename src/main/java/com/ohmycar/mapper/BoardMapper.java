package com.ohmycar.mapper;

import java.util.List;

import com.ohmycar.domain.BoardVO;
import com.ohmycar.domain.Criteria;

public interface BoardMapper {
	public List<BoardVO> getAllPosts();

	public void write(BoardVO boardVO);

	public BoardVO read(int bno);

	public void update(BoardVO boardVO);

	public void delete(int bno);

	public List<BoardVO> getListWithPaging(Criteria cri);
	
	BoardVO getBoard(int bno);
}
