<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0 auto;
}

a {
	text-decoration: none;
}

#footerWrap {
	margin: 0 auto;
	width: 1000px;
	height: 300px;
	background-color: skyblue;
}

#footerWrap  ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	float: right;
}

#footerWrap  li {
	float: left;
	margin: 10px 10px 0 5px;
}

#footerWrap>#logoImg {
	float: right;
}
</style>
</head>
<body>
	<div id="footerWrap">
		<ul>
			<li>회사정보 사업자정보등</li>
			<li>회사정보 사업자정보등</li>
			<li>회사정보 사업자정보등</li>
		</ul>
		<a id="logoImg" href="/"><img
			src="../resources/img/ohmycar_logo.png" style="width: 200px;"></a>
	</div>

</body>
</html>