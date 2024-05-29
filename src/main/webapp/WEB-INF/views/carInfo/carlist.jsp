<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>차량 목록</title>
<!-- CSS 파일 추가 -->
<link rel="stylesheet" type="text/css" href="/resources/css/carlist.css">
<style>
</style>
</head>
<body>
	<h1>차량 목록</h1>
	<table>
		<thead>
			<tr>
				<th>User ID</th>
				<th>Car ID</th>
				<th>Car Sell Name</th>
				<th>Car Name</th>
				<th>Car Type</th>
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
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
