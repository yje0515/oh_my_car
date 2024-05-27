<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차량 정보 수정</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f9f9f9;
	margin: 0;
	padding: 0;
}

h1 {
	color:  #002F65;
	text-align: center;
	font-size: 36px;
	margin-bottom: 30px;
	font-weight: bold;
}

form {
	max-width: 600px;
	margin: 0 auto;
	padding: 20px;
	background-color: #f9f9f9;
	border-radius: 8px;
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
}

table {
	width: 100%;
}

table td {
	padding: 10px;
}

input[type="text"], select {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
	margin-bottom: 10px;
	color: #555;
}

button[type="button"] {
	background-color: #555;
	color: #fff;
	border: none;
	padding: 12px 24px;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
	font-weight: bold;
	text-transform: uppercase;
	transition: background-color 0.3s ease;
}

button[type="button"]:hover {
	background-color: #333;
}
</style>
</head>
<body>
	<h1>보유차량 정보 수정</h1>
	<form role="form" id="updateForm" name="frm">
		<table>
			<tr>
				<td>사용자 ID</td>
				<td><input type="text" id="userId" name="userId"
					placeholder="차량 ID" maxlength="20" value="${carVO.userId}" readonly></td>
			</tr>
			<tr>
				<td>차량 ID</td>
				<td><input type="text" id="carId" name="carId"
					placeholder="차량 ID" maxlength="20" value="${carVO.carId}" readonly></td>
			</tr>
			<tr>
				<td>판매차량 이름</td>
				<td><input type="text" id="carSellName" name="carSellName"
					placeholder="판매차량 이름" value="${carVO.carSellName }" required></td>
			</tr>
			<tr>
				<td>차량 모델</td>
				<td><input type="text" id="carName" name="carName"
					placeholder="차량 모델" value="${carVO.carName }" required></td>
			</tr>
			<tr>
				<td>차량 타입</td>
				<td><select id="carType" name="carType" required>
						<option value="">타입 선택</option>
						<option value="SUV"
							<c:if test="${carVO.carType == 'SUV'}">selected</c:if>>SUV</option>
						<option value="세단"
							<c:if test="${carVO.carType == '세단'}">selected</c:if>>세단</option>
						<option value="트럭"
							<c:if test="${carVO.carType == '트럭'}">selected</c:if>>트럭</option>
						<option value="경차"
							<c:if test="${carVO.carType == '경차'}">selected</c:if>>경차</option>
						<option value="밴"
							<c:if test="${carVO.carType == '밴'}">selected</c:if>>밴</option>
						<option value="스포츠카"
							<c:if test="${carVO.carType == '스포츠카'}">selected</c:if>>스포츠카</option>
				</select></td>
			</tr>
			<tr>
				<td><button type="button" id="updateBtn">수정</button></td>
			</tr>
		</table>
	</form>
	<script>
		$(document)
				.ready(
						function() {
							$('#updateBtn').on('click', function() {
								updateCar();
							});

							function updateCar() {
								$
										.ajax({
											type : "POST",
											url : "${pageContext.request.contextPath}/user/carUpdate",
											data : $("#updateForm").serialize(),
											success : function(response) {
												alert("차량 정보가 업데이트되었습니다.");
												location.href = "${pageContext.request.contextPath}/user/mypage";
											},
											error : function(xhr, status, error) {
												alert("차량 정보 업데이트 중 오류가 발생했습니다.");
												console.error(error);
											}
										});
							}
						});
	</script>
	<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>
