package com.ohmycar.domain;

import java.util.Date;
import lombok.Data;

@Data
public class CommentVO {
	private Long id;
	private Long bno; // 게시글 ID
	private String content;
	private String writer;
	private Date regdate;
}
