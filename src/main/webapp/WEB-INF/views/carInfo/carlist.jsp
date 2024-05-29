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
					<td><a
						href="/carDetails?userId=${car.userId}&carId=${car.carId}">${car.userId}</a></td>
					<td><a
						href="/carDetails?userId=${car.userId}&carId=${car.carId}">${car.carId}</a></td>
					<td><a
						href="/carDetails?userId=${car.userId}&carId=${car.carId}">${car.carSellName}</a></td>
					<td><a
						href="/carDetails?userId=${car.userId}&carId=${car.carId}">${car.carName}</a></td>
					<td><a
						href="/carDetails?userId=${car.userId}&carId=${car.carId}">${car.carType}</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>
