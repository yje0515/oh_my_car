<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<!-- mypage에 기능을 추가, UserController에 차량등록과 차량 변경이 있음 -->
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>자동차 등록</title>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap"
	rel="stylesheet">
<!-- CSS 파일 추가 -->
<link rel="stylesheet" type="text/css" href="/resources/css/register.css">
<style>
</style>
</head>
<body>
<jsp:include page="../includes/header.jsp"></jsp:include>
	<form id="carForm"
		action="${pageContext.request.contextPath}/carInfo/register"
		method="post">			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		<h1>보유차량 등록</h1>
		<div>
			<label for="userId">유저 ID:</label> <input type="text" id="userId"
				name="userId" value="${userVO.userId}" readonly>
		</div>
		<div>
			<label for="carId">자동차 ID:</label> <input type="text" id="carId"
				name="carId" required>
		</div>
		<div>
			<label for="carSellName">판매차량 이름:</label> <input type="text"
				id="carSellName" name="carSellName" required>
		</div>
		<div>
			<label for="carName">차량 모델:</label> <input type="text" id="carName"
				name="carName" required>
		</div>
		<div>
			<label for="carType">차량 타입:</label> <select id="carType"
				name="carType" required>
				<option value="">타입 선택</option>
				<option value="SUV">SUV</option>
				<option value="세단">세단</option>
				<option value="트럭">트럭</option>
				<option value="경차">경차</option>
				<option value="밴">밴</option>
				<option value="스포츠카">스포츠카</option>
			</select>
		</div>
		<div>
			<button type="submit">등록</button>
		</div>
	</form>
	<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>

