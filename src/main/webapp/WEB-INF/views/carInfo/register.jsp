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
<!-- <link rel="stylesheet" type="style/css" href="/css/register.css"> -->
<style>
body {
	font-family: 'Segoe UI', sans-serif;
	background-color: #f4f4f4;
	margin: 0 auto;
	padding: 0;
	display: flex;
	justify-content: center;
	/* align-items: center; 이 줄을 제거하여 수직 정렬을 없앰 */
	min-height: 100vh;
}

h1 {
	color: #333;
	text-align: center;
	font-size: 36px;
	margin-bottom: 10px; /* 아래쪽 여백을 줄임 */
	font-weight: 700;
	letter-spacing: 1px;
}

form {
	background-color: #fff;
	padding: 20px 30px; /* 패딩을 줄임 */
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	width: 100%;
	max-width: 500px;
	margin-top: 30px; /* 위쪽 여백을 조정 */
}

form div {
	margin-bottom: 15px; /* 아래쪽 여백을 줄임 */
}

label {
	display: block;
	font-weight: 500;
	margin-bottom: 8px;
	color: #555;
}

input[type="text"], select {
	width: 100%;
	padding: 10px; /* 패딩을 줄임 */
	border: 1px solid #ccc;
	border-radius: 6px;
	font-size: 16px;
	box-sizing: border-box;
	transition: border-color 0.3s;
}

input[type="text"]:focus, select:focus {
	border-color: #1A87C6;
}

input[type="text"]:read-only {
	background-color: #e9ecef;
}

button[type="submit"] {
	background-color: #333;
	color: white;
	border: none;
	padding: 12px 20px; /* 패딩을 줄임 */
	border-radius: 20px;
	cursor: pointer;
	font-size: 16px;
	width: 100%;
	font-weight: 700;
	text-transform: uppercase;
	transition: background-color 0.3s ease, transform 0.2s ease;
	outline: none; /* 포커스시 파란 테두리 제거 */
}

button[type="submit"]:hover {
	background-color: #0056b3;
	transform: scale(1.02);
}
</style>
</head>
<body>
	<form id="carForm"
		action="${pageContext.request.contextPath}/user/register"
		method="post">
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

