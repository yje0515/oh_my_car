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
	background-color: #1A87C6;
	column-count: 3;
}

#footerWrap  ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	float: left;
}

#footerWrap  li {
	float: left;
	margin: 10px 10px 0 5px;
	color: white;
}

#footerWrap>#logoImg {
	float: right;
	position: absolute;
	margin:180px 0 0 410px;
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
			src="../resources/img/ohmycar_logo.png" style="width: 250px;"></a>
	</div>

</body>
</html>