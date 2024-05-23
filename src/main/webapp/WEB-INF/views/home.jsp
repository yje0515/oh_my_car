<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<html>
<head>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<title>앗!차차로 간편한 자동차관리!</title>
<style>
#mainWrap {
	width: 1000px;
	height: 1000px;
	background-color:lightgray;
	margin: 0 auto;
}
</style>
</head>
<body>
	<jsp:include page="includes/header.jsp"></jsp:include>

	<div id="mainWrap">
		<h1>메인페이지</h1>
		<sec:authorize access="isAuthenticated()">
			<p>${userVO.userName}님의차량정보</p>
			<a href="/carInfo/read">보러가기</a>
		</sec:authorize>
	</div>


	<jsp:include page="includes/footer.jsp"></jsp:include>
	<script>
		$(document).ready(function(){
			if(${result eq 'deleteSuccess'}){
				alert("회원탈퇴가 성공적으로 처리되었습니다. 감사합니다.");
			
			}
		});
	</script>
</body>
</html>
