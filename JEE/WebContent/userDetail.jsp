<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="fr" />
<fmt:setBundle basename="message" var="message" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="login.jsp"></jsp:include>
	<h1>User List</h1>
	<form action='<c:url value="/user/update" />' method='POST'>
		<table>
			<tr>
				<td><label><fmt:message key="th.id" bundle="${message}" /></label></td>
				<td><input type='TEXT' name='id'
					<c:if test="${empty sessionScope.user}">disabled="disabled"</c:if>
					value='${ requestScope.user.id}'></td>
			</tr>
			<tr>
				<td><label><fmt:message key="th.firstname"
							bundle="${message}" /></label></td>
				<td><input type='TEXT' name='prenom'
					<c:if test="${empty sessionScope.user}">disabled="disabled"</c:if>
					value='${ requestScope.user.prenom}'></td>
			</tr>
			<tr>
				<td><label><fmt:message key="th.lastname"
							bundle="${message}" /></label></td>
				<td><input type='TEXT'
					<c:if test="${empty sessionScope.user}">disabled="disabled"</c:if>
					name='nom' value='${ requestScope.user.nom}'></td>
			</tr>
			<tr>
				<td><label><fmt:message key="th.address"
							bundle="${message}" /></label></td>
				<td><input type='TEXT' name='adresse'
					<c:if test="${empty sessionScope.user}">disabled="disabled"</c:if>
					value='${ requestScope.user.adresse}'></td>
			</tr>
		</table>
		<br>
		<c:if test="${not empty sessionScope.user}">
			<button>Update</button>
		</c:if>
	</form>
	<br>
	<a href='<c:url value="/list" />'>Back to list</a>
</body>
</html>