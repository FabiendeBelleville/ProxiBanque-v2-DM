<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Ecran d'Authentification Conseiller</title>
		<link rel="stylesheet" type="text/css" href="style2.css" />
	</head>
	<body>

			<h1>Ecran d'Authentification</h1>
			
		
			
			<form method="post" action="Login">
			
			Login :
			<input name ="txtLogin" value= "${login}" autofocus/>
			<br/>
			Password: 
            <input name="txtPassword" type="password" value="${password}" />
            <br/> <br/>
	        
	        <input type="submit" value="Connect" />
	        <br/><br/>
	        
            <div class="errorMessage">${errorMessage}</div>
            
	    </form>
			
			

	</body>
</html>