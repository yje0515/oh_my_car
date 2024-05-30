package com.ohmycar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ohmycar.domain.CommentVO;

@Mapper
public interface CommentMapper {
    public void insert(CommentVO comment);

    public CommentVO select(Long id);

    public int update(CommentVO comment);

    public int delete(Long id);

    public List<CommentVO> selectList(@Param("boardId") Long boardId);

    public void setBno(int bno);
}
