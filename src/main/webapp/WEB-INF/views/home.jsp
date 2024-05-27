<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<html>
<head>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<title>앗!차차로 간편한 자동차관리!</title>
</head>
<body>
<jsp:include page="includes/header.jsp"></jsp:include>
	<h1>홈페이지</h1>
	
	<!-- 로그인된 상태->마이페이지 로그인되지않은 상태->로그인페이지 -->
	<a href="/user/mypage">마이페이지</a>
	
	<!-- 관리자(ROLE_ADMIN) 권한이 있는 경우에만 -->
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	<a href="/user/admin">관리자페이지</a>  
	</sec:authorize>
	
	<!-- list.jsp로 이동하는 링크 -->
	<a href="/board/list">목록 보기</a>

	<div id="mainWrap">
		<h1>메인페이지</h1>
		<p>${userVO.userName}님의차량정보</p>
	</div>
	<!-- 인증된사용자(로그인 한 상태에서만) -->
	<sec:authorize access="isAuthenticated()">
	<p>${userVO.userName }님, 안녕하세요!</p>
	<!-- Post형식으로 처리되는 로그아웃 Spring Security내부에서 동작 -->
	<form action="/logout" method='post'>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<button>로그아웃</button>
	</form>
	</sec:authorize>

	<!-- 로그인되지 않은 상태에서만 (익명의 사용자의 경우) -->
	<sec:authorize access="isAnonymous()"> 
	<a href="/user/login">로그인</a>
	</sec:authorize>

	<!-- 로그인되지 않은 상태에서만 (익명의 사용자의 경우) -->
	<sec:authorize access="isAnonymous()"> 
	<a href="/user/join">회원가입</a>
	</sec:authorize>
	
	<jsp:include page="includes/footer.jsp"></jsp:include>
</body>
</html>
