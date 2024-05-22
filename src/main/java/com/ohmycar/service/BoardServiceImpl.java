package com.ohmycar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ohmycar.dao.BoardDAO;
import com.ohmycar.domain.BoardVO;
import com.ohmycar.mapper.BoardMapper;
import com.ohmycar.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardMapper mapper;
	
	@Autowired
    private BoardDAO boardDAO;

    @Override
    public void write(BoardVO board) {
        boardDAO.write(board);
    }

	@Override
	public List<BoardVO> getAllPosts() {
		return mapper.getAllPosts();
	}
}
