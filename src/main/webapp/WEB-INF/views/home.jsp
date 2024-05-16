<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>앗!차차로 간편한 자동차관리!</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>

	<!-- 각자 roleName에 맞춰서 -->
	<a href="/user/mypage">마이페이지</a>
	<a href="/user/admin">관리자페이지</a>
	
	<!-- 로그인 된 상태에서만 -->
	<!-- Post형식으로 처리되는 로그아웃 Spring Security내부에서 동작 -->
	<form action="/logout" method='post'>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<button>로그아웃</button>
	</form>
	
	<!-- 로그인되지 않은 상태에서만 -->
	<a href="/user/login">로그인</a>
	
	<!-- 로그인되지 않은 상태에서만 -->
	<a href="/user/join">회원가입</a>
</body>
</html>
