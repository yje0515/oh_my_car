<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<script src="/resources/js/user/userCheck.js" type="text/javascript"></script>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<script>
		var result = "${result}";

		if (result == "joinSuccess") {
			alert("성공적으로 회원가입이 완료되었습니다.")
		} else if (result == "successUpdate") {
			alert("회원정보가 수정되었습니다.");//다시 로그인 하게
		} else if (result == "failNoUser") {
			alert("회원정보가 일치하지 않습니다.");
		}
	</script>

	<jsp:include page="../includes/header.jsp"></jsp:include>
	<div class="login">
		<h1>로그인</h1>
		<%-- <p>
			<c:out value="${error}" />
			<c:out value="${logout}" />
		</p> --%>

		<form role="form" method='post' action="/login" id="loginForm">
			<ul>
				<li><input id="userid" class="loginInput" placeholder="아이디"
					name="username" type="text" autofocus></li>

				<li><input id="password" class="loginInput" placeholder="비밀번호"
					name="password" type="password"></li>
				<li><label> <input name="rememberBox" type="checkbox">아이디저장
				</label></li>
				<li><button type="submit" class="loginBtn">로그인</button></li>
			</ul>

			<!-- 누르면 /login으로 submit -->


			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	</div>


	<jsp:include page="../includes/footer.jsp"></jsp:include>

	<script>
		$(document).ready(function(){
			$('.loginBtn').click(function(e){
				e.preventDefault();
				
				if(loginCheck()){
					$("#loginForm").submit();
				}
			});
			
		});
		
		function loginCheck(){
			if($('#userid').val() == ""){
				alert("아이디를 입력 해 주세요.");
				$('#userid').focus();
				return false;
			}
			if($('#password').val() == ""){
				alert("비밀번호를 입력 해 주세요.");
				$('#password').focus();
				return false;
			}
			return true;
		}
	</script>
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