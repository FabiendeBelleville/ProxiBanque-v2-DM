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

	<h1>Effectuer un virement</h1>
	<h2><%= new Date() %></h2>
	<p>Cher ${connectedUser.login}, merci de bien vouloir entrer les informations du virement</p>

	<form method="post" action="Virement">
		<fieldset>
			<legend>Virement</legend>

			<p>
				montant : <input type="text" name="montant" placeholder="1000" />
				<br>
				<br>
			</p>
			<p>
				compte emetteur : <input type="text" name="cptemetteur" placeholder="6253625" />
				<br>
				<br>
			</p>
			<p>
				compte desinataire : <input type="text" name="cptdestinataire" placeholder="1283829" />
				<br>
				<br>
			</p>


		</fieldset>


		<input type="reset" value="reset" /> <input type="submit"
			value="Valider" />
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