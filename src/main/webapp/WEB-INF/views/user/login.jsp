<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	

	<jsp:include page="../includes/header.jsp"></jsp:include>
	<div class="login">
		<h1>로그인</h1>
		<%-- <p>
			<c:out value="${error}" />
			<c:out value="${logout}" />
		</p> --%>

		<form role="form" method='post' action="/login" id="loginForm">
			<table>
				<tr>
					<td><input id="userid" class="loginInput" placeholder="아이디"
						name="username" type="text" autofocus></td>
				</tr>
				<tr>
					<td><input id="password" class="loginInput" placeholder="비밀번호"
						name="password" type="password"></td>
				</tr>
				<tr>
					<td><input name="remember-me" type="checkbox">로그인 유지하기</td>
				</tr>
				<tr>
					<td><input name="rememberId" type="checkbox">아이디 저장</td>
				</tr>
				<tr>
					<td><button type="submit" class="loginBtn">로그인</button></td>
				</tr>

			</table>



			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<a href="/user/join"><button>회원가입</button></a>
	</div>


	<jsp:include page="../includes/footer.jsp"></jsp:include>

	<script>
		$(document).ready(function() {
			$('.loginBtn').click(function(e) {
				e.preventDefault();

				if (loginCheck()) {
					$("#loginForm").submit();
				}
			});

		});

		function loginCheck() {
			if ($('#userid').val() == "") {
				alert("아이디를 입력 해 주세요.");
				$('#userid').focus();
				return false;
			}
			if ($('#password').val() == "") {
				alert("비밀번호를 입력 해 주세요.");
				$('#password').focus();
				return false;
			}
			return true;
		}
	</script>
	<!-- <script>
		var result = "${result}";

		if (result == "joinSuccess") {
			alert("성공적으로 회원가입이 완료되었습니다.")
		} else if (result == "successUpdate") {
			alert("회원정보가 수정되었습니다.");//다시 로그인 하게
		} else if (result == "failNoUser") {
			alert("회원정보가 일치하지 않습니다.");
		}
	</script> -->
	<%-- 	
	 <c:if test="${param.logout != null}">
		<script>
			$(document).ready(function() {
				alert("로그아웃되었습니다.");
			});
		</script>
	</c:if> --%>

</body>
</html>