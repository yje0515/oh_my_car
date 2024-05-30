package com.ohmycar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ohmycar.domain.CommentVO;

@Mapper
public interface CommentMapper {
    List<CommentVO> getCommentsByBoardId(Long bno);
    void insert(CommentVO comment);
    void update(CommentVO comment);
    void delete(Long id);
}
