<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<body>
	<h1>회원정보 수정</h1>
	<form method="post" action="/user/update">
		<label for="userid">아이디:</label><br> <input type="text"
			id="userid" name="userid" value="${user.userid }" readonly><br>

		<label for="username">이름:</label><br> <input type="text"
			id="username" name="username" value="${user.username }"><br>

		<label for="password">비밀번호:</label><br> <input type="password"
			id="password" name="password"><br> 
			
		<label for="email">이메일:</label><br>
		<input type="text" id="email" name="email" value="${user.email }"><br>

		<label for="nickname">닉네임:</label><br> <input type="text"
			id="nickname" name="nickname" value="${user.nickname }"><br>

		<input type="submit" value="수정">
	</form>
</body>
</html>