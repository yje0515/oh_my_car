package com.ohmycar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ohmycar.domain.CommentVO;

@Mapper
public interface CommentMapper {
    public void insert(CommentVO comment);

    public int update(CommentVO comment);

    public int delete(int id);

    public List<CommentVO> getCommentsByBoardId(int bno);
}
