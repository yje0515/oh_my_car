<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html lang="kor">
<head>
<meta charset="UTF-8">
<!-- 폰트 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css"href="../../resources/css/common.css">
<link rel="stylesheet" type="text/css"href="../../resources/css/includes.css">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<title>OH MY CAR 앗!차차로 간편한 자동차관리!</title>
</head>
<body>
	<div id="headerWrap">
		<a id="logoImg" href="/"><img
			src="../resources/img/logo_dark.png" style="height: 175px" alt="앗차차 로고"></a>
		<ul>
			<sec:authorize access="isAuthenticated()">
				<li style="font-size: 18px;">${userVO.userName } 님, 안녕하세요!</li>
				<li><form action="/logout" method='post'>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<button id="headerBtn_logout">로그아웃</button>
					</form></li>
				<li><a href="/user/mypage"><button class="headerBtn">마이페이지</button></a></li>
			</sec:authorize>
			<sec:authorize access="isAnonymous()">
				<li><a href="/user/login"><button class="headerBtn">로그인</button></a></li>
				<li><a href="/user/join"><button class="headerBtn">회원가입</button></a></li>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="/user/admin"><button class="headerBtn">관리자페이지</button></a></li>
			</sec:authorize>
		</ul>
	</div>
</body>
</html>