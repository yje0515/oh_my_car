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
<link rel="stylesheet" type="text/css"
	href="../../resources/css/user.css">
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
				<li><a href="/carInfo/carlist">차량 목록</a></li>
				<li><a href="/user/passwordCheck?action=delete">회원 탈퇴</a></li>
			</ul>
		</div>
		<div id="userCarINfoBox">
			<table>
				<tr>
					<th colspan="3" style="font-size: 25px;"> ${userVO.userName }
						님의 차량</th>
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
					<td><a href="/carInfo/carlist"><img
							src="../resources/img/userCarListIcon.png" alt="차량 목록 아이콘"></a></td>
					<!-- <td><a href="/carInfo/carUpdate"><img src="../resources/img/userUpdateIcon.png"
							alt="차량 관리 아이콘"></a></td> -->
					<td><a href="/user/passwordCheck?action=delete"><img
							src="../resources/img/userDeleteIcon.png" alt="회원 탈퇴 아이콘"></a></td>
				</tr>
			</table>
		</div>
	</div>
	<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>