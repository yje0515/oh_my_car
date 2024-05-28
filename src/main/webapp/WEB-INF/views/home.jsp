<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<title>앗!차차로 간편한 자동차관리!</title>

<style>

/* 메인페이지 */
#mainWrap {
	width: 1000px;
	height: 1400px;
	margin: 50px auto;
}

#mainLowerImg {
	text-align: center;
	width: 100%;
	height: 300px;
	background-color: lightyellow;
}

#ramdomCarFactsBox {
	width: 100%;
	height: 444px;
	margin: 55px auto;
	border: 1px solid lightgray;
}

#ramdomCarFactsBox h2 {
	margin: 20px auto;
	font-size: 28px;
}

#ramdomCarFactsBox  table {
	margin: 40px 55px 0 55px;
	border-collapse: collapse;
}

#ramdomCarFactsBox td {
	width: 885px;
	border: 1px solid lightgray;
	height: 50px;
	padding: 0 0 0 20px;
}

/* 아이콘 */
#mainIconBox {
	width: 100%;
	height: 300px;
	margin: 0px 0 -53px 0px;
}

#mainIconBox ul {
	float: left;
	margin: 47px 0 0 0px;
}

#mainIconBox ul li {
	float: left;
	margin: 0 0 0 27px;
}

#mainIconBox img {
	width: 150px;
}

/* 메인페이지 슬라이드 */
#mainSlideBox {
	width: 100%;
	height: 300px;
	background-color: lightyellow;
	position: relative;
}

#mainSlideBox img {
	width: 1000px;
	height: 300px;
	position: absolute;
	margin: 0 0 0 -40px;
	position: absolute;
}

#mainSlideBox li:not(:first-child) {
	display: none;
}
</style>
</head>
<body>
	<jsp:include page="includes/header.jsp"></jsp:include>

	<div id="mainWrap">
		<div id="mainSlideBox">
			<ul>
				<li><img src="../../resources/img/mainSlide1.png"
					alt="슬라이드 이미지1"></li>
				<li><img src="../../resources/img/mainSlide2.png"
					alt="슬라이드 이미지2"></li>
				<li><img src="../../resources/img/mainSlide3.png"
					alt="슬라이드 이미지3"></li>
			</ul>
		</div>
		<div id="mainIconBox">
			<ul>
				<!-- 경로 확인해야함 -->
				<li><a href="#"><img
						src="../../resources/img/userCarListIcon.png" alt="차량 목록 아이콘"></a></li>
				<li><a href="#"><img
						src="../../resources/img/carManagementIcon.png" alt="차량 관리 아이콘"></a></li>
				<li><a href="#"><img
						src="../../resources/img/boardIcon.png" alt="게시판 아이콘"></a></li>
				<li><a href="#"><img
						src="../../resources/img/nearGasStationIcon.png" alt="가까운 주유소 아이콘"></a></li>
				<li><a href="#"><img
						src="../../resources/img/nearRepairShopIcon.png" alt="가까운 정비소 아이콘"></a></li>
			</ul>
		</div>
		<div id="ramdomCarFactsBox">

			<table>
				<tr>
					<th><h2>자동차 랜덤 간단상식</h2></th>
				</tr>
				<c:forEach var="carFact" items="${randomCarFacts}">
					<tr>
						<td>${carFact.factText }</td>
					</tr>
				</c:forEach>
			</table>
			<%-- <ul>
				<c:forEach var="carFact" items="${randomCarFacts}">
					<li>${carFact.factText }</li>
				</c:forEach>
			</ul> --%>
		</div>
		<div id="mainLowerImg">
			<a href="#"><img src="../../resources/img/mainLowerImg.png"
				alt="하단 이미지"></a>
		</div>

	</div>

	<jsp:include page="includes/footer.jsp"></jsp:include>
	<script>
		$(document).ready(function(){
			/* 슬라이드 */
			var i = 0;
			function slideShow(){
				i++;
				if(i>$("#mainSlideBox li:last").index()){
					i=0;
				}
				$("#mainSlideBox li").eq(i).stop().fadeIn("slow");
				$("#mainSlideBox li").eq(i-1).stop().fadeOut("slow");
			}
			setInterval(slideShow,4000);//4초마다
			
			
			if(${result eq 'deleteSuccess'}){
				alert("회원탈퇴가 성공적으로 처리되었습니다. 감사합니다.");
			}
			if(${result eq 'updateSuccess'}){
				alert("회원정보 수정이 성공적으로 처리되었습니다.");
			}
		});
	</script>
</body>
</html>
