<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MYPAGE</h1>
	<form role="form" method="post" action="/user/update" id="updateForm"
		name="frm">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" id="userid" name="userid"
					placeholder="아이디" maxlength="20" value="${user.userid }" readonly></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" id="username" name="username"
					placeholder="이름" value="${user.username }" readonly></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="password" name="password"
					placeholder="비밀번호"></td>
			</tr>
			<tr>
				<td>비밀번호확인</td>
				<td><input type="password" id="passwordCheck"
					name="passwordCheck" placeholder="비밀번호확인"></td>
				<td><p id="checkMsg">비밀번호가 일치하지 않습니다.</p></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" id="email" name="email"
					placeholder="이메일" value="${user.email }"></td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td><input type="text" id="nickname" name="nickname"
					placeholder="닉네임" value="${user.nickname }"></td>
			</tr>
			<tr>
				<td>회원등급</td>
				<td><input type="radio" name="auth" value="${user.authList }"
					checked="checked">${user.authList }</td>
			</tr>
			<tr>
				<td>
					<button type="submit" id="updateBtn">회원정보수정</button>
				</td>
			</tr>

		</table>

	</form>


	차량등록 회원탈퇴
</body>
</html>