<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String pw = request.getParameter("password");
	String user = request.getParameter("user");
	request.setAttribute("pallets", 0);
	if(pw.equals("a")){ //TODO
		System.out.println("Retail user " + user + " successfully logged in");
	}else{
		System.out.println("Retail user " + user + " failed to log in");
		request.setAttribute("errorMessage", "Invalid user or password");
		request.getRequestDispatcher("/retailer.jsp").forward(request, response);

}

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Retailer Logged In</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<p>
		<a href="/CocaColaSupplyChain">Back to Home</a>
		<br>
		Current time: <%= new java.util.Date()%>
	</p>
	Welcome <%= request.getParameter("user")%>

	<form action="buypallet.jsp" method="post">
		Buy pallet of Coke: <input type="submit" value="Buy Pallet">
	</form><br>
	Number of pallets:
	<%= request.getAttribute("pallets") %>
	
</body>
</html>