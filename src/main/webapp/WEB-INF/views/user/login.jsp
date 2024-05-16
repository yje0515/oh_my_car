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

		<form role="form" method='post' action="/login" id="loginForm"
			name="loginForm">
			<table>
				<tr>
					<td><input type="text" id="userId"  placeholder="아이디"
						name="username" autofocus></td>
				</tr>
				<tr>
					<td><input  type="password"id="password" class="loginInput" placeholder="비밀번호"
						name="password"></td>
				</tr>
				<tr>
					<td><input name="remember-me" type="checkbox">로그인 유지하기</td>
				</tr>
				<tr>
					<td><input name="rememberId" type="checkbox">아이디 저장</td>
				</tr>
				<tr>
					<td><button id="loginBtn">로그인</button></td>
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
			$('#loginBtn').on('click',loginCheck);

			
			function loginCheck() {
				var form = document.loginForm;
				var token = $("meta[name='_csrf']").attr("content");
				var header = $("meta[name='_csrf_header']").attr("content");

				if ($('#username').val() == "") {
					alert("아이디를 입력 해 주세요.");
					$('#userId').focus();
					return false;
				}
				if ($('#password').val() == "") {
					alert("비밀번호를 입력 해 주세요.");
					$('#password').focus();
					return false;
				}

				$.ajax({
					url : "/user/loginCheck",
					type : "post",
					dataType : "text",
					data : {
						"userId" : loginForm.username.value,
						"password" : loginForm.password.value
					},
					beforeSend : function(xhr) {
						xhr.setRequestHeader(header, token);
					},
					success : function(data) {
						if (data === 'success') {
							form.submit();
						}else{
							alert(" 아이디 또는 비밀번호를 잘못 입력했습니다.입력하신 내용을 다시 확인해주세요.");
							return false;
						}
					},
					error : function() {
						alert("로그인 과정에서 문제발생");
					}

				});
			}

		});

		
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