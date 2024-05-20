<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
</head>
<body>
	<h1>MYPAGE</h1>
	<p>${userVO.userName }님</p>
	<a href="/user/passwordCheck?action=edit">내 정보 수정</a>
	
	<!-- Post형식으로 처리되는 로그아웃 Spring Security내부에서 동작 -->
	<form action="/logout" method='post'>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<button>로그아웃</button>
	</form>
	<c:if test="${result eq 'success'}">
		<script>
			alert("회원정보가 성공적으로 수정되었습니다.");
		</script>
	</c:if>

	차량등록
	<a href="/user/passwordCheck?action=delete">회원 탈퇴</a>
</body>
</html>