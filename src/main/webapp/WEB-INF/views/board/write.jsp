<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<style>
body {
	font-family: 'Segoe UI', sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

h1 {
	color: #002F65;
	text-align: center;
	font-size: 24px;
	margin-bottom: 20px;
}

form {
	width: 80%;
	max-width: 600px;
	background-color: #fff;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

label {
	display: block;
	margin-bottom: 10px;
}

input[type="text"], textarea {
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
}

button[type="submit"] {
	background-color: #0056b3;
	color: white;
	border: none;
	padding: 10px 20px;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
	font-weight: 700;
	text-transform: uppercase;
	transition: background-color 0.3s ease, transform 0.2s ease;
	outline: none;
	width: 100%;
}

button[type="submit"]:hover {
	background-color: #004494;
	transform: scale(1.02);
}
</style>
</head>
<body>
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
