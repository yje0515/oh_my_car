package com.ohmycar.service;

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
    public List<CommentVO> getCommentsByBoardId(int bno) {
        return commentMapper.getCommentsByBoardId(bno);
    }

    @Override
    public void writeComment(CommentVO comment) {
        commentMapper.insert(comment);
    }

    @Override
    public void register(CommentVO comment) {
        commentMapper.insert(comment);
    }

    @Override
    public void modify(CommentVO comment) {
        commentMapper.update(comment);
    }

    @Override
    public void remove(int id) {
        commentMapper.delete(id);
    }
}
