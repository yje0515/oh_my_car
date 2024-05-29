package com.ohmycar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ohmycar.domain.CommentVO;
import com.ohmycar.mapper.CommentMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    @Override
    public void register(CommentVO comment) {
        commentMapper.insert(comment);
    }

    @Override
    public CommentVO get(Long id) {
        return commentMapper.select(id);
    }

    @Override
    public boolean modify(CommentVO comment) {
        return commentMapper.update(comment) == 1;
    }

    @Override
    public boolean remove(Long id) {
        return commentMapper.delete(id) == 1;
    }

    @Override
    public List<CommentVO> getList(Long boardId) {
        return commentMapper.selectList(boardId);
    }

    @Override
    public List<CommentVO> getCommentsByBoard(int bno) {
        return new ArrayList<>();
    }

    @Override
    public void writeComment(CommentVO comment) {
        lombok.extern.log4j.Log4j.class.getName();
    }
}
