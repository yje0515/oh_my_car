package com.ohmycar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ohmycar.domain.CommentVO;

public interface CommentMapper {
    void insert(CommentVO comment);
    CommentVO select(Long id);
    int update(CommentVO comment);
    int delete(Long id);
    List<CommentVO> selectList(@Param("boardId") Long boardId);
    void setBno(int bno);
}
