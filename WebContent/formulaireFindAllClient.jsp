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

	<h1>Consulter tous les clients</h1>
	<h2><%= new Date() %></h2>
	<p>Cher ${connectedUser.login}, merci de bien vouloir entrer l'id du client recherch�</p>

	<form method="post" action="ConsulterTousLesClients">
<!-- 		<fieldset> -->
<!-- 			<legend>Trouver client</legend> -->

<!-- 			<p> -->
<!-- 				id Client : <input type="text" name="id" placeholder="6253625" /> -->
<!-- 				<br> -->
<!-- 				<br> -->
<!-- 			</p> -->


<!-- 		</fieldset> -->


	<input type="submit"
			value="Consulter !"/>
	</form>
<!-- boutton home et footer -->
<br>
	<br>
	<a href="index.jsp"> <img border="0" src="img/home.png" width="60" height="60"></a>
	<br>
	<br>
<div id="footer">� Copyright 2018</div>
</body>
</html>