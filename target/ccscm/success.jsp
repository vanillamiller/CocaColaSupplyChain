<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Success Page</title>
</head>
<body>
	<p>
		<a href="retailer.jsp">Back to Login Page</a>
		<br>
		The time is now <%= new java.util.Date()%>
	</p>
	<h2>Hello {{retailer.name}}</h2>
	
	<form action="DoJobServlet" method="post">
		Number of pallets/liters: <input type="number" name="quantity" min="1" max="5">
		<br>
		<input type="submit" value="DoJob">
	</form>
</body>
</html>