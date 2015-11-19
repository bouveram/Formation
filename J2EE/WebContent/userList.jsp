<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="org.exemple.model.Utilisateur,java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="fr"/>
<fmt:setBundle basename="message" var="message" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="h1" bundle="${message}" /></title>
</head>
<body>
<jsp:include page="login.jsp"></jsp:include>
<h1><fmt:message key="h1" bundle="${message}" /></h1>
	 <table> 
	 <tr> 
	 <th> <fmt:message key="th.delete" bundle="${message}" /> </th> 
	 <th> <fmt:message key="th.id" bundle="${message}" /> </th> 
	 <th> <fmt:message key="th.firstname" bundle="${message}" /> </th> 
	 <th> <fmt:message key="th.lastname" bundle="${message}" /> </th> 
	 <th> <fmt:message key="th.address" bundle="${message}" /> </th> 
	 <th> <fmt:message key="th.details" bundle="${message}" /> </th> 
	 </tr>
	 <c:forEach var="user" items="${requestScope.users}">
		 <tr> 
		<td><a href='remove?id=${user.id}'>Del</a></td>
		<td>#<c:out value="${user.id}" /></td>
		 <td><c:out value="${user.prenom}" /></td>
		 <td><c:out value="${user.nom}" /></td>
		 <td><c:out value="${user.adresse}" /></td>
		 <td><a href='detail?id=${user.id}'> detail</a></td></tr>
	</c:forEach>
 <td><a href='add'>add user</a></td> 
 </table>
</body>
</html>