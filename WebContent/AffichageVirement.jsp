<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style2.css">
<meta charset="UTF-8">
<title>ProxiBanque-v2-DM</title>
<style>
table {
	border: medium solid #6495ed;
	border-collapse: collapse;
	width: 50%;
}

th {
	font-family: monospace;
	border: thin solid #6495ed;
	width: 50%;
	padding: 5px;
	background-color: #D0E3FA;
	background-image: url(sky.jpg);
}

td {
	font-family: sans-serif;
	border: thin solid #6495ed;
	width: 50%;
	padding: 5px;
	text-align: center;
	background-color: #ffffff;
}

caption {
	font-family: sans-serif;
}
</style>
</head>
<body>
	<h1>Résultat du virement</h1>


	<br>
	<br>
	<table class="der">

		<tr>
			<c:forEach var="detailUser" items="${laListeConsole}">
				<tr>
					<td>${detailUser}</td>
					<%-- 					<td>${detailUser.prenom}</td> --%>

				</tr>
				<p>
			</c:forEach>
		</tr>
	</table>







	<!-- boutton home et footer -->
	<br>
	<br>
	<a href="index.jsp"> <img border="0" src="img/home.png" width="60"
		height="60"></a>
	<br>
	<br>
	<div id="footer">© Copyright 2018</div>
</body>
</html>