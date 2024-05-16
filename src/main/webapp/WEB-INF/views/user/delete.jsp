<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<body>
	<h1>Delete Confirmation</h1>
	<p>이 사이트에서 탈퇴를 하시겠습니까?</p>
	<form action="/delete" method="post">
		<input type="hidden" name="${_csrh.parameterName}" value="${_csrf.token}" />
		<button type="submit">회원 탈퇴</button>
	</form>
</body>
</html>