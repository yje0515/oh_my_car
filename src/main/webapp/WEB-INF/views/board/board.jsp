<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>1:1 문의하기</title>
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #f9f9f9;
	margin: 0;
	padding: 0;
}

h2 {
	color: #333;
	text-align: center;
	margin-top: 30px;
	font-weight: bold;
	font-size: 28px;
	text-transform: uppercase;
}

form {
	background-color: #fff;
	max-width: 600px;
	margin: 0 auto;
	padding: 30px;
	border-radius: 8px;
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
}

label {
	display: block;
	font-weight: bold;
	margin-bottom: 10px;
	color: #555;
}

input[type="text"], textarea {
	width: calc(100% - 22px);
	padding: 12px;
	margin-bottom: 20px;
	border: 1px solid #ccc;
	border-radius: 6px;
	box-sizing: border-box;
	font-size: 16px;
	color: #333;
	transition: border-color 0.3s ease;
}

textarea {
	height: 180px;
	resize: none;
}

input[type="text"]:focus, textarea:focus {
	border-color: #007bff;
	outline: none;
}

button[type="submit"] {
	background-color: #1A87C6;
	color: #fff;
	border: none;
	padding: 12px 24px;
	border-radius: 6px;
	cursor: pointer;
	font-size: 16px;
	transition: background-color 0.3s ease;
}

button[type="submit"]:hover {
	background-color: #0056b3;
}

.footer {
	background-color: #1A87C6;
	color: white;
	padding: 20px;
	font-size: 14px;
	text-align: center;
	clear: both;
	margin-top: 30px;
	border-radius: 0 0 8px 8px;
}
</style>
</head>
<body>
	<h2>1:1 문의하기</h2>
	<form action="/board/write" method="post">
		<label for="title">제목:</label> <input type="text" id="title"
			name="title"> <br> <label for="content">문의 내용:</label>
		<textarea id="content" name="content"></textarea>
		<br> <label for="writer">작성자:</label> <input type="text"
			id="writer" name="writer"> <br>
		<button type="submit">제출</button>
	</form>
	<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>
