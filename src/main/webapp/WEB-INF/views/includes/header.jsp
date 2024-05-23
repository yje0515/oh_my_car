<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<!-- <link rel="stylesheet" type="text/css"
	href="../../resource/css/includes.css"> -->
<title>OhMyCar!앗!차차로 간편한 자동차관리!</title>
<style>
* {
	margin: 0 auto;
	list-style: none;
}

a {
	text-decoration: none;
	color:black;
}

#headerWrap {
	margin: 0 auto;
	width: 1000px;
	height: 150px;
	border-bottom:1px solid #1A87C6;
}

#headerWrap  ul {
	list-style-type: none;
	margin: 15px 15px 0 0px;
	padding: 0;
	float: right;
}

#headerWrap  li {
	float: left;
	margin: 0px 10px 0px 10px;
}

#headerWrap #logoImg {
	float: left;
	margin: -12px 0 0 20px;
}
</style>
</head>
<body>
	<div id="headerWrap">
		<a id="logoImg" href="/"><img
			src="../resources/img/ohmycar_logo.png" style=" height: 160px;"></a>
		<ul>
			<sec:authorize access="isAuthenticated()">
				<li>${userVO.userName }님,안녕하세요!</li>
				<li><form action="/logout" method='post'>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<button>로그아웃</button>
					</form></li>
				<li><a href="/user/mypage">마이페이지</a></li>
			</sec:authorize>
			<sec:authorize access="isAnonymous()">
				<li><a href="/user/login">로그인</a></li>
				<li><a href="/user/join">회원가입</a></li>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="/user/admin">관리자페이지</a></li>
			</sec:authorize>
		</ul>
	</div>
</body>
</html>