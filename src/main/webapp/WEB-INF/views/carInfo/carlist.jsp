<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="kor">
<head>
<title>Car List</title>
<link rel="stylesheet" type="text/css" href="/resources/css/carlist.css">
<style>
</style>
</head>
<body>
	<jsp:include page="../includes/header.jsp"></jsp:include>
	<h1 class="carTitle">차량 목록</h1>
	<table class="carTable">
		<thead>
			<tr>
				<th>User ID</th>
				<th>Car ID</th>
				<th>Car Sell Name</th>
				<th>Car Name</th>
				<th>Car Type</th>
				<th>Button</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="car" items="${carList}">
				<tr>
					<td>${car.userId}</td>
					<td>${car.carId}</td>
					<td>${car.carSellName}</td>
					<td>${car.carName}</td>
					<td>${car.carType}</td>
					<td>
						<form action="/consumable/read" method="get">
							<input type="hidden" name="carId" value="${car.carId}"/>
							<input type="submit" value="부품정보보기" onclick="javascript: form.action='/consumable/read';"/>
							<input type="submit" value="차량정보수정" onclick="javascript: form.action='/carInfo/update';"/>
							<input type="submit" value="차량삭제" onclick="javascript: form.action='/carInfo/delete';"/>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>
