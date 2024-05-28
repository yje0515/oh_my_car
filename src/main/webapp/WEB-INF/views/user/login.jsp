<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<script src="../../resources/js/user/login.js" type="text/javascript"></script>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="../../resources/css/user.css">
<title>로그인</title>
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
					<td style="text-align: left;"><input id="remember-me"
						name="remember-me" type="checkbox"><label
						for="remember-me">로그인 유지하기</label></td>
				</tr>
				<tr>
					<td><input type="submit" id="loginBtn" value="로그인"></td>
				</tr>

			</table>



			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>

		<p id="wrongAccess" style="display: none; color: red; font-size: 12px">
			아이디 또는 비밀번호를 잘못 입력했습니다.<br>입력하신 내용을 다시 확인해주세요.
		</p>
		<a href="/user/join"><button id="loginJoinBtn">회원가입</button></a>

		<h3>현대자동차 로그인</h3>
		<a
			href="https://prd.kr-ccapi.hyundai.com/api/v1/user/oauth2/authorize?client_id=400b3231-30db-42f5-ab52-9d69b35a184d&redirect_uri=http://localhost:8282&response_type=code&state=test"><button
				id="hyndaiLoginBtn">
				<img src="../../resources/img/hyndai_logo_original.png"
					alt="현대자동차 로그인">
			</button></a>
	</div>


	<jsp:include page="../includes/footer.jsp"></jsp:include>

	<script>
	 if (${ error != null }){
		   $("#userId").focus();
		   $("#wrongAccess").show();
		   return false;
	}
	if(${result eq 'joinSuccess'}){
		alert("회원가입이 성공적으로 처리되었습니다.");
	}
		
	</script>


</body>
</html>