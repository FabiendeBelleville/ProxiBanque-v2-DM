<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style2.css">
<meta charset="UTF-8">
<title>Detail</title>
</head>
<body>
	<h1>detail user</h1>
	<h2><%= new Date() %></h2>
	<center>
	<ul>
	<p>idClient : ${detailUser.id}
	<p>nom : ${detailUser.nom}
	<p>prenom : ${detailUser.prenom}
	<p>adresse : ${detailUser.adresse}
	<p>codePostal : ${detailUser.codePostal}
	<p>ville : ${detailUser.ville}
	<p>telephone : ${detailUser.telephone}
	<p>compteCourant : ${detailUser.compteCourant}
	<p>compteEpargne : ${detailUser.compteEpargne}
	<!-- boutton home et footer -->
	</ul>
	</center>
<br>
	<br>
	<a href="index.jsp"> <img border="0" src="img/home.png" width="60" height="60"></a>
	<br>
	<br>
<div id="footer">© Copyright 2018</div>
</body>
</html>