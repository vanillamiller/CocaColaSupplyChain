<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Retailer Login Page</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<p>
<%--	TODO THE FOLLOWING LINK MAY OR MAY NOT WORK WHEN DEPLOYED. not sure. 	--%>
		<a href="/CocaColaSupplyChain">Back to Home</a>
		<br>
		Current time: <%= new java.util.Date()%>
	</p>
	<form action="retailerloggedin.jsp" method="post">
		User: <select name="user">
			<option value="retailer0">Retailer0</option>
		  	<option value="retailer1">Retailer1</option>
			<option value="retailer2">Retailer2</option>
			<option value="retailer3">Retailer3</option>
			<option value="retailer4">Retailer4</option>
			<option value="retailer5">Retailer5</option>
			<option value="retailer6">Retailer6</option>
			<option value="retailer7">Retailer7</option>
			<option value="retailer8">Retailer8</option>
		</select><br>
		Password: <input type="text" name="password"><br>
		<input type="submit" value="Login">
		<%
		if(request.getAttribute("errorMessage") != null ){ %>
		<%= request.getAttribute("errorMessage") %>
		<% } %>
	</form>
	
</body>
</html>