<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Logout Page</h1>

<!-- Post형싱으로 처리되는 로그아웃 Spring Security내부에서 동작 -->
<form action="/logout" method='post'>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<button>로그아웃</button>
</form>
</body>
</html>