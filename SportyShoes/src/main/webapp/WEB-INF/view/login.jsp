<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login Page</title>
</head>
<body>
 <div class="container">


  
      <form method="POST" action="${contextPath}/authenticate">
     <h2>Sporty Shoes - User Login</h2>

        <div >
          <c:if test="${param.error!=null }">
          <p style="color: red"> Invalid user credentials</p>
          </c:if>
           <c:if test="${param.logout!=null }">
          <p style="color: green"> You have been successfully logged out!</p>
          </c:if>
           <div>Username:<input name="username" type="text"/></div> 
           <div>Password: <input name="password" type="password" /></div>
            
           <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button type="submit">Log In</button>
          
        </div>
      </form>
    </div>
</body>
</html>