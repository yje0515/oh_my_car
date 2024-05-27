<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<meta charset="UTF-8">
<title>로그인</title>
<style>
#loginWrap {
	width: 400px;
	height: 680px;
	text-align: center;
}

#loginWrap h1 {
	text-align: center;
	padding: 150px 0 30px 0;
}

#loginBtn {
	width: 250px;
	height: 50px;
	background-color: #002F65;
	color: white;
	border-radius: 5px;
	font-size: 18px;
	margin:5px auto;
}

.loginInput {
	width: 250px;
	height: 35px;
	padding: 0 0 0 5px;
}

#loginJoinBtn {
	width: 250px;
	height: 50px;
	color: #002F65;
	background-color: white;
	border: 1px solid #002F65; border-radius : 5px;
	font-size: 18px;
	border-radius: 5px;
	margin:5px auto;
}
</style>
</head>
<body>
	<jsp:include page="../includes/header.jsp"></jsp:include>

	<div id="loginWrap">
		<h1>로그인</h1>
		<form role="form" method='post' action="/login" id="loginForm"
			name="loginForm">
			<table>
				<tr>
					<td><input class="loginInput" type="text" id="userId"
						placeholder="아이디" name="username" autofocus></td>
				</tr>
				<tr>
					<td><input type="password" id="password" class="loginInput"
						placeholder="비밀번호" name="password"></td>
				</tr>
				<tr>
					<td style="text-align: left;"><input name="remember-me"
						type="checkbox">로그인 유지하기</td>
				</tr>
				<tr>
					<td><input type="submit" id="loginBtn" value="로그인"></td>
				</tr>

			</table>



			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>

		<p id="wrongAccess" style="color: red; font-size: 12px">
			아이디 또는 비밀번호를 잘못 입력했습니다.<br>입력하신 내용을 다시 확인해주세요.
		</p>
		<a href="/user/join"><button id="loginJoinBtn">회원가입</button></a>


	</div>


	<jsp:include page="../includes/footer.jsp"></jsp:include>

	<script>
		$(document).ready(function() {
			$('#loginBtn').on('click',loginCheck);
			$("#wrongAccess").hide();
			
			if(${error!=null}){
				$("#userId").focus();
				$("#wrongAccess").show();
				return false;
			}
			
			function loginCheck(token,header) {
				var form = document.loginForm;
				var token = $("meta[name='_csrf']").attr(
				"content");
				var header = $("meta[name='_csrf_header']")
				.attr("content");

				if ($('#userId').val() == "") {
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
					datatype : "text",
					data : {
						"userId" : loginForm.userId.value,
						"password" : loginForm.password.value
					},
					beforeSend : function(xhr) {
						xhr.setRequestHeader(header, token);
					},
					success : function(data) {
						if (data.trim() === 'success') {//로그인 성공
							form.submit();
						} else {//아이디가 없거나,비밀번호가 틀림
							 $("#wrongAccess").show();
						}
					},
					error : function(xhr,status,error) {
						alert("서버요청실패");
					}
				});
			}
			

		});

		
	</script>


</body>
</html>