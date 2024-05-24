<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<style>
#mypageWrap {
	position: relative;
	width: 1000px;
	height: 800px;
	margin: 0 auto;
}

/* 마이페이지 메뉴 */
#mypageMenuBox {
	position: fixed;
	height: 800px;
	float: left;
	position: absolute;
	margin: 0px 0 0 0px;
	text-align: left;
	border-right: 1px solid #1A87C6;
}

#mypageMenuBox ul {
	margin: 120px 40px 0px -255px;
}

#mypageMenuBox ul li {
	margin: 20px 0 50px 0px;
	font-size: 18px;
}

/* 마이페이지 간단 회원차량정보 */
#userCarINfoBox {
	position: absolute;
	border: 1px solid #1A87C6;
	border-radius: 5px;
	width: 700px;
	background-color: white;
	text-align: left;
	margin: 300px 0px 0 250px;
	max-height: 400px;
	overflow: auto;
	min-height: 200px;
}

#userCarINfoBox table {
	border-collapse: separate;
	border-spacing: 90px 20px;
}

#userCarINfoBox table th td {
	border: 1px solid gray;
}

/* 마이페이지 아이콘으로 바로가기 */
#mypageIconBox {
	position: absolute;
	width: 800px;
	margin: 50px 0 0 200px;
}

#mypageIconBox img {
	width: 150px;
}
</style>
</head>
<body>
	<jsp:include page="../includes/header.jsp"></jsp:include>
	<div id="mypageWrap">

		<div id="mypageMenuBox">
			<ul>
				<li>

					<h3>마이페이지</h3>

				</li>
				<li><a href="/user/passwordCheck?action=edit">회원 정보 수정</a></li>
				<li><a href="/carInfo/register">차량 등록</a></li>
				<li><a href="/carInfo/carUpdate">차량 정보 수정</a></li>
				<li><a href="/carInfo/carUpdate">차량 관리</a></li>
				<li><a href="/user/passwordCheck?action=delete">회원 탈퇴</a></li>
			</ul>
		</div>
		<div id="userCarINfoBox">
			<table>
				<tr>
					<th colspan="3" style="font-size: 25px;">[ ${userVO.userName }
						] 님의 차량</th>
				</tr>
				<tr>
					<th>carId</th>
					<th>carSellName,carName</th>
					<th>carType</th>
				</tr>
				<c:forEach var="car" items="${carList }">
					<tr>
						<td>${car.carId }</td>
						<td>${car.carSellName }${car.carName }</td>
						<td>${car.carType }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div id="mypageIconBox">
			<table>
				<tr>
					<td><a href="/user/passwordCheck?action=edit"><img
							src="../resources/img/userUpdateIcon.png" alt="회원 정보 수정 아이콘"></a></td>
					<td><a href="/carInfo/register"><img
							src="../resources/img/carRegisterIcon.png" alt="차량 등록 아이콘"></a></td>
					<td><a href="/carInfo/carUpdate"><img
							src="../resources/img/carUpdateIcon.png" alt="차량 정보 수정 아이콘"></a></td>
					<!-- <td><a href="/carInfo/carUpdate"><img src="../resources/img/userUpdateIcon.png"
							alt="차량 관리 아이콘"></a></td> -->
					<td><a href="/user/passwordCheck?action=delete"><img
							src="../resources/img/userDeleteIcon.png" alt="회원 탈퇴 아이콘"></a></td>
				</tr>
			</table>
		</div>
	</div>


	<jsp:include page="../includes/footer.jsp"></jsp:include>

	<c:if test="${result eq 'success'}">
		<script>
			alert("회원정보가 성공적으로 수정되었습니다.");
		</script>
	</c:if>
</body>
</html>