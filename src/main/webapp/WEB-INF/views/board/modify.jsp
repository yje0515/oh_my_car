<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<link rel="stylesheet" type="text/css" href="/resources/css/modify.css">
<style>
</style>
</head>
<body>
	<form action="/board/modify" method="post">
		<label for="title">제목:</label><br> <input type="text" id="title"
			name="title" value="${board.title}"><br> <label
			for="content">내용:</label><br>
		<textarea id="content" name="content">${board.content}</textarea>
		<br> <label for="writer">작성자:</label><br> <input type="text"
			id="writer" name="writer" value="${board.writer}"><br>
		<!-- 수정일자를 보여줄 수도 있으나, 보통 수정일자는 자동으로 업데이트되므로 수정 필요성이 낮을 수 있습니다. -->
		<input type="hidden" name="bno" value="${board.bno}"> <input
			type="submit" value="수정"> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>
