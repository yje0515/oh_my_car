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
	background-color: lightgray;
	margin: 0 auto;
}
#mainWrap ul{
float:left;
}
#mainWrap ul li{
float:left;
}
.someContents {
	text-align: center;
	width: 100%;
	height: 200px;
	background-color: lightyellow;
	margin: 0px 0 10px 0px;
}

#mainBoard {
	float: left;
}
</style>
</head>
<body>
	<jsp:include page="includes/header.jsp"></jsp:include>

	<div id="mainWrap">
		<div class="someContents">(사이트소개 이미지 or 글)</div>
		<div id="mainIcons" class="someContents">
			<ul>
			<!-- 경로 확인해야함 -->
				<li><a href="/carInfo/register"><img src="" alt="차량 등록 아이콘"></a></li>
				<li><a href="#"><img src="" alt="차량 관리 아이콘"></a></li>
				<li><a href="/board/list"><img src="" alt="게시판 아이콘"></a></li>
			</ul>
		</div>
		<div class="someContents">자동차간단상식 리스트 랜덤으로 보이게</div>
		<div class="someContents">사이트 주요 서비스 소개</div>

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
