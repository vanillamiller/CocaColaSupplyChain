<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="auth.DCGateway"%>
<%@ page import="java.util.*"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CocaCola Supply Chain Internal</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
	<p>
		<a href="/CocaColaSupplyChain">Back to Home</a>
		<br>
		Current time: <%= new java.util.Date()%>
	</p>
	<h2>Hello CocaCola HQ</h2>

	<br><br>
	
	<form action="mbsdc" method="post">
		Distribution Center: <select name="user">
		<!-- TODO make this a loop that gets all Distribution centers from DB -->
			<option value="dcusa1">DistributionCenterUSA1</option>
			<option value="dcusa2">DistributionCenterUSA2</option>
			<option value="dccn1">DistributionCenterCN1</option>
			<option value="dcaus1">DistributionCenterAUS1</option>
			<option value="dcaus2">DistributionCenterAUS2</option>
		</select>
		<input type="submit" value="Mix, Bottle and Send to DC">
	</form>	
	
	
	Distribution Center's Pallets:
	{{pallets per distribution center}}
	
	List of distribution centers:
	TODOTODOTODOTODOTODOTODOTODO
	<%-- <% for (DC d : (List<DC>)request.getAttribute("err not sure TODOTODO")) {%>
			<form action="cart" method="post">
				<tr><td><%=d.getDCId()%></td>
					<td><%=d.getName()%></td>
					<td><%=d.getaccountBookID()%></td>
					<td><%=d.getaccountBookID()%></td>
					<td colspan="2" align="center">
						<button type="submit" name="dcid" value=<%=d.s()%> class="btn">
							New DC
						</button>
					</td>
				</tr>
			</form>
			<%}%>
	 --%>
	
</body>
</html>