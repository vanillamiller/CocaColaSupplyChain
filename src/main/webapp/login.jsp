<%--
  Created by IntelliJ IDEA.
  User: tomglynch
  Date: 18/9/19
  Time: 6:15 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="domain.RetailerMapper" %>
<%@ page import="domain.Retailer" %>
<%@ page import="domain.AppSession" %>

<html>
<head>
    <title>Retailer Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<% System.out.println("WHAT THE HELL IM HERE");%>
<form action="loginServlet" method="post">

    <% if (!AppSession.isAuthenticated()) {%>
    User: <input type="text" name="username"><br>
    Password: <input type="text" name="password"><br>
    <input type="submit" value="Login">
    <%} else{%>
        <div> you have already logged in</div>
    <% } %>
    <%
        if(request.getAttribute("errorMessage") != null ){ %>
    <%= request.getAttribute("errorMessage") %>
    <% } %>
</form>
</body>
</html>
