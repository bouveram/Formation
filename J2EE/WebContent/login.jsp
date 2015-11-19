<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<c:if test="${not empty sessionScope.user}">
	<c:out value="Bonjour ${user.prenom}"></c:out>
</c:if>

<c:if test="${empty sessionScope.user}"> 
	<p>Entrez votre nom et prenom :</p>
	<form action='login' method ='POST'>
		login : <br>
		<input type='TEXT' name='login'>
		<br>
		password : <br>
		<input type="password" name='password'>
		<br>
		<button>Login</button>
	</form>
</c:if>

</body>
</html>