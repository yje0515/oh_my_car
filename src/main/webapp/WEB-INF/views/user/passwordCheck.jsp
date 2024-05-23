<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<style>
#passwordCheckWrap {
	text-aligh: center;
	width: 400px;
	height: 450px;
}

#passwordCheckBox {
	width: 400px;
	height: 180px;
	border: 1px solid #1A87C6;
	border-radius: 5px;
	margin: 200px 0 0 0px;
}

#passwordCheckBox tr {
	text-align: center;
}

#passwordCheckBox tr th {
	font-size: 20px;
	padding: 20px 0 0px 0px;
	color: #1A87C6;
}

#passwordCheckBox tr td input {
	width: 200px;
	height: 25px;
	font-size: 12px;
	margin: 0 0 20px 30px;
	padding:0 0 0 5px;
	border: 1px solid #1A87C6;
}

.submitBtn {
	width: 70px;
	height: 30px;
	color: white;
	background-color: #1A87C6;
	border-radius: 5px;
	border: 1px #1A87C6 solid;
}

#passwordCheckBox .submitBtn {
	margin:0px 30px 16px 0px;
}
</style>
</head>
<body>
	<jsp:include page="../includes/header.jsp"></jsp:include>
	<div id="passwordCheckWrap">
		<form action="/user/passwordCheck" method="post">
			<table id="passwordCheckBox">
				<tr>
					<th colspan="2">비밀번호 확인</th>
				</tr>
				<tr>
					<td><input type="password" placeholder="비밀번호" id="password"
						name="password" autofocus></td>
					<td><button class="submitBtn" type="submit">확인</button></td>
				</tr>
				<tr>
					<td colspan="2" id="wrongPassword"
						style="font-size: 14px; color: red; display: none;">회원정보와
						일치하지 않습니다.</td>
				</tr>
			</table>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> <input type="hidden" name="action"
				value="${param.action }">
			<!-- <input type="hidden" name="passwordChecked" > -->

		</form>
	</div>
	<jsp:include page="../includes/footer.jsp"></jsp:include>
	<script>
    $(document).ready(function(){
    	$("#wrongPassword").hide();
        if (${result eq 'wrongPassword'}) {
            $("#wrongPassword").show();
        }
    });
</script>

</body>
</html>