<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style2.css">
<meta charset="UTF-8">
<title>Detail</title>
</head>
<body>
	<h1>detail user</h1>
	<p>idClient : ${detailUser.id}
	<p>nom : ${detailUser.nom}
	<p>prenom : ${detailUser.prenom}
	<p>adresse : ${detailUser.adresse}
	<p>codePostal : ${detailUser.codePostal}
	<p>ville : ${detailUser.ville}
	<p>telephone : ${detailUser.telephone}
	<p>compteCourant : ${detailUser.numcptC}
	<p>compteEpargne : ${detailUser.numcptE}
	
	
	
	<form method="post" action="EditerClientPres">
	
	
	
	<fieldset>
			<legend>Editer client ?</legend>
			<p>idClient : <input type="text" name="idClient" placeholder="${detailUser.id}" />
				<br>
				<br>
				nom : <input type="text" name="nom" placeholder="${detailUser.nom}" />
				<br>
				<br>
				prénom : <input type="text" name="prenom" placeholder="${detailUser.prenom}" />
				<br>
				<br>
				adresse : <input type="text" name="adresse" placeholder="${detailUser.adresse}" />
				<br>
				<br>
				Code Postal : <input type="text" name="cp" placeholder="${detailUser.codePostal}" />
				<br>
				<br>
				Ville : <input type="text" name="ville" placeholder="${detailUser.ville}" />
				<br>
				<br>
			</p>
		</fieldset>	
	<input type="submit"
			value="Editer"/>
	</form>
	
	
	
	
	<!-- boutton home et footer -->
<br>
	<br>
	<a href="index.html"> <img border="0" src="img/home.png" width="60" height="60"></a>
	<br>
	<br>
<div id="footer">© Copyright 2018</div>
</body>
</html>