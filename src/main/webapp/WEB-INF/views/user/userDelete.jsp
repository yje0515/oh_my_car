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
<form name="deleteForm" action="/user/userDelete" method="post">
	<button type="button" id="deleteBtn">회원탈퇴</button>
</form>
<script>
$(document).ready(function(){
	$("#deleteBtn").on('click',function(){
		var result = confirm("정말 탈퇴하시겠습니까?");
		if(result){
			document.deleteForm.action="/user/userDelete";
		}else{
			document.deleteForm.action="/user/mypage";
		}
		document.deleteForm.submit();
		
	})
	
});
	
</script>
</body>
</html>