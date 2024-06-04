package com.ohmycar.service;

import com.ohmycar.domain.BoardVO;
import com.ohmycar.domain.Criteria;

import java.util.List;

public interface BoardService {

    void write(BoardVO boardVO);

    List<BoardVO> getList(Criteria cri);

    BoardVO read(int bno);

    void modify(BoardVO boardVO);

    void delete(int bno);

    BoardVO getBoard(int bno);

    List<BoardVO> getAllPosts();
}