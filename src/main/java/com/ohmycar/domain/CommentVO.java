package com.ohmycar.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CommentVO {
    private Long id;
    private Long boardId;
    private String content;
    private String writer;
    private Date regDate;
    private Date updateDate;
    public void setBno(Long bno) {
        this.boardId = bno;
    }
}
