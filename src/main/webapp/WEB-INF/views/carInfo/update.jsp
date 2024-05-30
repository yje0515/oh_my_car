<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차량 정보 수정</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/carUpdate.css">
<style>
</style>
</head>
<body>
<jsp:include page="../includes/header.jsp"></jsp:include>
<div id="carUpdate">
	<h1>보유차량 정보 수정</h1>
	<form role="form" id="updateForm" name="frm">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
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
	</div>
	<jsp:include page="../includes/footer.jsp"></jsp:include>
	<script>
		$(document).ready(function() {
				$('#updateBtn').on('click', updateCar);
				function updateCar() {
					$.ajax({
						type: "POST",
						url: "/carInfo/update",
						data: $("#updateForm").serialize(),
							success: function(response) {
								alert("차량 정보가 업데이트되었습니다.");
								location.href = "/carInfo/carlist";
							},
							error: function(xhr, status, error) {
								alert("차량 정보 업데이트 중 오류가 발생했습니다.");
								console.error(error);
							}
					});
				}
			}
		);
	</script>
</body>
</html>
