<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard Page</title>
</head>
<body>
<h2>welcome to dashboard</h2>

<p>

Hello Admin you can do following things:

</p>
<ol>
<li><a href="${contextPath}/changePassword">change password</a></li>
<li>modify items</li>
<li>show reports</li>
</ol>

<form:form action="${contextPath}/logout" method="POST">
<input type="submit" value="Logout"/>
</form:form>
</body>
</html>