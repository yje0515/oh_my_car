<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
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

form {
	width: 80%;
	max-width: 600px;
	background-color: #fff;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

h2 {
	color: #002F65;
	text-align: center;
	font-size: 24px;
	margin-bottom: 20px;
}

label {
	color: #333;
	font-weight: bold;
	margin-bottom: 5px;
}

input[type="text"], textarea {
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
}

textarea {
	resize: vertical;
	min-height: 150px;
}

input[type="submit"] {
	background-color: #0056b3;
	color: white;
	border: none;
	padding: 12px 20px;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
	font-weight: bold;
	text-transform: uppercase;
	transition: background-color 0.3s ease, transform 0.2s ease;
}

input[type="submit"]:hover {
	background-color: #004494;
	transform: scale(1.02);
}
</style>
</head>
<body>
	<form action="modifyBoard.jsp" method="post">
		<label for="title">제목:</label><br> <input type="text" id="title"
			name="title" value="${board.title}"><br> <label
			for="content">내용:</label><br>
		<textarea id="content" name="content">${board.content}</textarea>
		<br> <label for="writer">작성자:</label><br> <input type="text"
			id="writer" name="writer" value="${board.writer}"><br>
		<!-- 수정일자를 보여줄 수도 있으나, 보통 수정일자는 자동으로 업데이트되므로 수정 필요성이 낮을 수 있습니다. -->
		<input type="hidden" name="bno" value="${board.bno}"> <input
			type="submit" value="수정">
	</form>
</body>
</html>
