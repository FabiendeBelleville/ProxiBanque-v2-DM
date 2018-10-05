<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="style2.css">
<meta charset="ISO-8859-1">
<title>Proxi Banque SI</title>
</head>
<body>

	<h1>Créer client</h1>
	<h2><%= new Date() %></h2>
	
	<p>Cher ${connectedUser.login}, merci de bien vouloir renseigner les informations concernant le nouveau client</p>

	<form method="post" action="CreerClient">
		<fieldset>
			<legend>Informations client</legend>

			<p>
			<center>
			
				<li>nom : <input type="text" name="nom" placeholder="Dupont" /></li>
				<br>
				<br>
				<li>prénom : <input type="text" name="prenom" placeholder="Marc" /></li>
				<br>
				<br>
				<li>adresse : <input type="text" name="adresse" placeholder="48 Avenue des Champs Elysés" /></li>
				<br>
				<br>
				<li>Code Postal : <input type="text" name="cp" placeholder="75008" /><li>
				<br>
				<br>
				<li>Ville : <input type="text" name="ville" placeholder="Paris" /><li>
				<br>
				<br>
				<li>montant du 1er dépot sur compte courant : <input type="number" name="depotCC" placeholder="5000" /></li>
				<br>
				<br>
				<li>montant du 1er dépot sur compte épargne : <input type="text" name="depotCE" placeholder="2000" /></li>
				<br>
				<br>
				
				</center>
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
<div id="footer">© Copyright 2018</div>
</body>
</html>