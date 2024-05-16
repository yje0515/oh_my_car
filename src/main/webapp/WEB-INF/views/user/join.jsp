<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<script src="/resources/js/user/userCheck.js" type="text/javascript"></script>
</head>
<body>
	<div class="join">
		<h1>회원가입</h1>

		<form role="form" method="post" action="/user/join" id="joinForm">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" id="userid" name="userid"
						placeholder="아이디" autofocus></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" id="username" name="username"
						placeholder="이름"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" id="password" name="password"
						placeholder="비밀번호"></td>
				</tr>
				<tr>
					<td>비밀번호확인</td>
					<td><input type="password" id="password" name="passwordCheck"
						placeholder="비밀번호확인"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" id="email" name="email"
						placeholder="이메일"></td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td><input type="text" id="nickname" name="nickname"
						placeholder="닉네임"></td>
				</tr>
				<tr>
					<td>회원등급</td>
					<td><input type="radio" name="auth" value="ROLE_MEMBER"
						checked="checked">일반회원 <input type="radio" name="auth"
						value="ROLE_ADMIN">관리자</td>
				</tr>
				<tr>
					<td>
					<button type="submit" id="joinBtn">회원가입</button>
					</td>
				</tr>

			</table>

		</form>

	</div>
	<script>
	$(document).ready(function(){
		$().on('click',)//빈칸 확인하는 메서드
		
		
		
		
		function 
	});
	</script>
</body>
</html>