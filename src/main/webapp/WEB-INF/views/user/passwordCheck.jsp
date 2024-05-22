<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Password Check</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
</head>
<body>
	<h1>Password Check</h1>
	<form id="passwordCheckForm">
		<table>
			<tr>
				<td>Password:</td>
				<td><input type="password" id="password" name="password"
					required></td>
			</tr>
			<tr>
				<td colspan="2"><button type="button" onclick="checkPassword()">Check
						Password</button></td>
			</tr>
		</table>
	</form>
	<div id="error" style="color: red;"></div>

	<script>
		function checkPassword() {
			$
					.ajax({
						type : "POST",
						url : "${pageContext.request.contextPath}/user/passwordCheck",
						data : $("#passwordCheckForm").serialize(),
						success : function(response) {
							console.log(response);
							if (response == 'success') {
								// 비밀번호가 정확한 경우 userUpdate.jsp 페이지로 이동
								window.location.href = "${pageContext.request.contextPath}/user/userUpdate";
							} else {
								// 비밀번호가 틀린 경우 오류 메시지 표시
								$("#error").text("비밀번호가 정확하지 않습니다, 다시 입력해주세요.");
							}
						},
						error : function() {
							$("#error").text(
									"An error occurred, please try again.");
						}
					});
		}
	</script>
</body>
</html>
