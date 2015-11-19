<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%	
Object title = request.getAttribute("titre");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%out.println(title); %></title>
</head>
<body>
	<h1>Hello Page 1</h1>
	<p>Entrez votre nom et prenom :</p>
	<form action='Page2' method ='POST'>
		Prénom : <br>
		<input type='TEXT' name='firstName'>
		<br>
		Nom : <br>
		<input type='TEXT' name='lastName'>
		<br>
		<br>
		<button>Envoi</button>
	</form>
</body>
</html>