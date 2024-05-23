<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Board</title>
</head>
<body>
	<h1>게시글작성</h1>
	<form action="/board/write" method="post">
		<label for="title">Title:</label> <input type="text" id="title"
			name="title"><br> <label for="content">Content:</label>
		<textarea id="content" name="content"></textarea>
		<br> <label for="writer">Writer:</label> <input type="text"
			id="writer" name="writer"><br>
		<button type="submit">Submit</button>
	</form>


</body>
</html>