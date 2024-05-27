<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
	<h1>게시글 작성</h1>
	<form action="/board/write" method="post">
		<label for="title">제목:</label> <input type="text" id="title"
			name="title"><br> <label for="content">게시글 내용:</label>
		<textarea id="content" name="content"></textarea>
		<br> <label for="writer">작성자:</label> <input type="text"
			id="writer" name="writer" value="${username}" readonly><br>
		<button type="submit">제출</button>
	</form>
</body>
</html>
