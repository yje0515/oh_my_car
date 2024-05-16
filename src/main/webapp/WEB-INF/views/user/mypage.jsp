<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MYPAGE</h1>
	<p>${userVO.userName }님</p>
<a href="/user/userUpdate">내 정보 수정</a>
<c:if test="${result eq 'success'}">
	<script>
	alert("회원정보가 성공적으로 수정되었습니다.");
	</script>
</c:if>

	차량등록 회원탈퇴
</body>
</html>