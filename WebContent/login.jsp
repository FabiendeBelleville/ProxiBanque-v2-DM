<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ecran d'Authentification Conseiller</title>
<link rel="stylesheet" type="text/css" href="style2.css" />
</head>
<body>
	<h1>Bienvenue dans PROXIBANQUE-V2</h1>
	<h1>Ecran d'Authentification</h1>
	<h2><%= new Date() %></h2>

<!-- Quand on soumet ce login on repart au niveau de la Servlet avec une soumission de type Post -->
	<form method="post" action="Login">

		<center>
		
<!-- 		utilisation de EL (Expression language) via un dollar et l'accolage ouvrante
exécuté coté serveur -->


<!-- 		input pour la saisie du login ou j'injecte une chaine vide-->
			
			<h2>Login :</h2>
			<input name="txtLogin" value="${login}" autofocus /> <br />
			
<!-- 		input pour la saisie du password ou j'injecte une chaine vide-->
			<h2>Password:</h2>
			<input name="txtPassword" type="password" value="${password}" /> <br />
			<br /> 
			<input type="submit" value="Connect" /> <br /> <br />

			<div class="errorMessage">${errorMessage}</div>
		</center>

	</form>



</body>

</html>