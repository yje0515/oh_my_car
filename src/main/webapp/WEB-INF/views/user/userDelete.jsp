<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<script src="../../resources/js/user/userDelete.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="../../resources/css/user.css">
</head>
<body>

	<jsp:include page="../includes/header.jsp"></jsp:include>

	<div id="userDeleteWrap">
		<form id="deleteForm" name="deleteForm" action="/user/userDelete"
			method="post">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<button type="button" id="deleteBtn">
				<img src="../../resources/img/userDeleteIcon.png" alt="회원탈퇴이미지">
			</button>
		</form>
	</div>

	<jsp:include page="../includes/footer.jsp"></jsp:include>
	<script>
		
		if(${passwordChecked != 'ok'}){
				history.back();
				alert("비밀번호 확인 후 접근가능합니다.");
				
			}
	</script>
</body>
</html>