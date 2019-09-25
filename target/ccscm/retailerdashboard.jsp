<%@ page import="mappers.DCMapper" %>
<%@ page import="domain.DC" %><%--
  Created by IntelliJ IDEA.
  User: tomglynch
  Date: 18/9/19
  Time: 6:16 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Retailer Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h2>Welcome to the Retailer Dashboard</h2>

<br>
<h3>Buy Pallets:</h3>
<form action="purchasePalletServlet" method="post">
    <input type="hidden" name="retailerID" value=<%=session.getAttribute("retailerID")%>>
    How many Pallets: <input type="number" name="quantity" min="1" required><br>
    From which DC?:<br>
    <ul>
    <%
        Integer x = Integer.parseInt((String)session.getAttribute("retailerID"));
        for (DC i : DCMapper.findMyDCs(x)) {
    %>
    <li><input type="radio" name="DCID" value="<%=i.getDCID()%>" checked required><%=i.getname()%> (<%=i.getnumPallets()%> available)</input></li>
     <% } %>
    </ul>
    <input type="submit" value="Buy">
            <%
        if(request.getAttribute("errorMessage") != null ){ %>
            <%= request.getAttribute("errorMessage") %>
            <% } %>
</form><br>

</body>
</html>

