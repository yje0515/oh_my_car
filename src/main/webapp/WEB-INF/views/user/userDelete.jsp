<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
</head>
<body>

	<jsp:include page="../includes/header.jsp"></jsp:include>
	<form id="deleteForm" name="deleteForm" action="/user/userDelete"
		method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<button type="button" id="deleteBtn">회원탈퇴</button>
	</form>
	<script>
		$(document).ready(function() {
			$("#deleteBtn").on('click', function() {
				var result = confirm("정말 탈퇴하시겠습니까?");
				if (result) {
					$("#deleteForm").submit();
				} else {
					$("#deleteForm").attr("action", "/user/mypage").attr("method","get").submit();
				}

			})
			if(${passwordChecked != 'ok'}){
				history.back();
				alert("비밀번호 확인 후 접근가능합니다.");
				
			}

		});
	</script>
</body>
</html>