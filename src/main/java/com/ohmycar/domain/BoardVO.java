package com.ohmycar.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int bno; // 게시글 ID
	private String title; // 게시글 제목
	private String content; // 게시글 내용
	private String writer; // 작성자
	private Date regdate; // 작성일시
	private Date updateDate; // 수정일시

	// 생성자, Getter 및 Setter는 생략했습니다.

	// 필요에 따라 추가적인 필드나 메서드를 추가할 수 있습니다.
}
