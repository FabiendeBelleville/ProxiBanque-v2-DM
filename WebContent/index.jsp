<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style2.css">
<meta charset="ISO-8859-1">
<title>Proxi Banque SI</title>
</head>
<body>

	<h1>Menu</h1>
	<h2><%= new Date() %></h2>
	<p>Bienvenue ${connectedUser.login}, veuillez sélectionner un service</p>
	<center>
		
			<li><a href="formulaireCreationClient.jsp">1-Créer client</a></li>
			<li><a href="formulaireFindClient.jsp">2-Consulter client</a></li>
			<li><a href="formulaireFindAllClient.html">3-Consulter tous
					les clients</a></li>
			<li><a href="http://www.fabiendrouin.fr">4-Supprimer client</a></li>
			<li><a href="formulaireVirement.jsp">5-Faire virement</a></li>
			<li><a href="http://www.fabiendrouin.fr">6-Simuler crédit</a></li>
			<li><a href="http://www.fabiendrouin.fr">7-Faire audit</a></li>
			<li><a href="http://www.fabiendrouin.fr">8-Quitter le
					service</a></li>
		
	</center>


	<!-- boutton home et footer -->
	<br>
	<br>
	<a href="index.jsp"> <img border="0" src="img/home.png" width="60"
		height="60"></a>
	<br>
	<br>
	<center><div id="footer">© Copyright 2018</div></center>
</body>
</html>