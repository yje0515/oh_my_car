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

<style>
#mypageWrap {
	width: 1000px;
	height: 800px;
	background-color: lightgray;
	margin: 0 auto;
}

#mypageWrap #mypageList {
	background-color: lightyellow;
	float: left;
}

#userCarINfoBox {
	width: 400px;
	height: 100px;
	background-color: white;
}

#mypageIcon img{
width:100px;

}
</style>
</head>
<body>
	<jsp:include page="../includes/header.jsp"></jsp:include>
	<div id="mypageWrap">

		<h1>마이페이지</h1>

		<div id="mypageList">
			<table>
				<tr>
					<td>
						<h2>마이페이지</h2>
					</td>
				</tr>
				<tr>
					<td><a href="/user/passwordCheck?action=edit">회원 정보 수정</a></td>
				</tr>
				<tr>
					<td><a href="/carInfo/register">차량 등록</a></td>
				</tr>
				<tr>
					<td><a href="/carInfo/carUpdate">차량 정보 수정</a></td>
				</tr>
				<tr>
					<td><a href="/carInfo/carUpdate">차량 관리</a></td>
				</tr>
				<tr>
					<td><a href="/user/passwordCheck?action=delete">회원 탈퇴</a></td>
				</tr>
			</table>
		</div>
		<div id="userCarINfoBox">
			<table>
				<tr>
					<th>${userVO.userName }님의차량</th>
				</tr>
				<tr>
					<th>차종</th>
					<th>누적주행거리</th>
				</tr>
				<tr>
				
					<td>ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ${carVO.carSellName }</td>
					<td>ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ${Odometer.value }</td>
				</tr>
			</table>
		</div>
		<div id="mypageIcon">
			<table>
				<tr>
					<td><a href="/user/passwordCheck?action=edit"><img
							src="../resources/img/userUpdateIcon.png" alt="회원 정보 수정 아이콘"></a></td>
					<td><a href="/carInfo/register"><img src="../resources/img/carRegisterIcon.png"
							alt="차량 등록 아이콘"></a></td>
					<td><a href="/carInfo/carUpdate"><img src="../resources/img/carUpdateIcon.png"
							alt="차량 정보 수정 아이콘"></a></td>
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