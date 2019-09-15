<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Retailer Logged In</title>
</head>
<body>
	<p>
		<a href="/CocaColaSupplyChain">Back to Home</a>
		<br>
		Current time: <%= new java.util.Date()%>
	</p>
	Welcome to the retailer logged in page.
	
	<form action="BuyPallet" method="post">
		Buy pallet of Coke: <input type="submit" value="Buy Pallet">
	</form>

	
</body>
</html>