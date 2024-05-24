<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap"
	rel="stylesheet">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<!-- <link rel="stylesheet" type="text/css"
	href="../../resource/css/includes.css"> -->
<title>OH MY CAR 앗!차차로 간편한 자동차관리!</title>
<style>
* {
	margin: 0 auto;
	font-family: "Noto Sans KR", sans-serif;
}

a {
	text-decoration: none;
	color: black;
}

ul, li {
	list-style: none;
}

.sticky {
	position: fixed;
}

.sticky + #underHeader {
	padding-top: 150px;
}

#headerWrap {
	margin: 0 auto;
	width: 100%;
	height: 150px;
	border-bottom: 1px solid #1A87C6;
	background-color: white;
	z-index: 1000;
}

#headerWrap  ul {
	list-style-type: none;
	margin: 15px 15px 0 0px;
	float: right;
}

#headerWrap  li {
	float: left;
	margin: 0px 10px 0px 10px;
}

#headerWrap #logoImg {
	position: absolute;
	float: left;
	margin: -12px 0 0 20px;
	float: left;
}

.headerBtn {
	background-color: #1A87C6;
	border: 1px solid #1A87C6;
	color: white;
	border-radius: 5px;
	font-size: 16px;
}

.headerBtn:hover {
	background-color: white;
	border: 1px solid #1A87C6;
	color: #1A87C6;
	cursor: pointer;
}

#headerBtn_logout {
	background-color: white;
	border: 1px solid #1A87C6;
	color: #1A87C6;
	border-radius: 5px;
	font-size: 16px;
}

#headerBtn_logout:hover {
	background-color: #1A87C6;
	border: 1px solid #1A87C6;
	color: white;
	cursor: pointer;
}
</style>
</head>
<body>
	<div id="headerWrap">
		<a id="logoImg" href="/"><img
			src="../resources/img/ohmycar_logo.png" style="height: 160px;"></a>
		<ul>
			<sec:authorize access="isAuthenticated()">
				<li>[ ${userVO.userName } ] 님, 안녕하세요!</li>
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
	<!--footer랑 연결되어있음 sticky설정  -->
	<div id="underHeader">
		<script>
			window.onscroll = function() {
				myFunction()
			};

			var header = document.getElementById("headerWrap");
			var sticky = header.offsetTop;

			function myFunction() {
				if (window.pageYOffset > sticky) {
					header.classList.add("sticky");
				} else {
					header.classList.remove("sticky");
				}
			}
		</script>
</body>
</html>