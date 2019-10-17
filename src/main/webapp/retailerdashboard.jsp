<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="domain.*" %>


<%--
  Created by IntelliJ IDEA.
  User: tomglynch
  Date: 18/9/19
  Time: 6:16 pm
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Retailer Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h2>Welcome to the Retailer Dashboard</h2>

<%--<br>--%>
<%--<h3>Buy Pallets:</h3>--%>
<%--<form action="purchasePalletServlet" method="post">--%>
<%--    <input type="hidden" name="retailerID" value=<%=session.getAttribute("retailerID")%>>--%>
<%--    How many Pallets: <input type="number" name="quantity" min="1" required><br>--%>
<%--    From which DC?:<br>--%>
<%--    <ul>--%>
<%--    <%--%>
<%--        TransactorMapper dcmap=new TransactorMapper();--%>
<%--        Integer x = Integer.parseInt((String)session.getAttribute("retailerID"));--%>
<%--        for (DC i : dcmap.findMyDCs(x)) {--%>
<%--    %>--%>
<%--    <li><input type="radio" name="DCID" value="<%=i.getID()%>" checked required><%=i.getName()%> (<%=i.getnumPallets()%> available)</input></li>--%>
<%--     <% } %>--%>
<%--    </ul>--%>
<%--    <input type="submit" value="Buy">--%>
<%--            <%--%>
<%--        if(request.getAttribute("errorMessage") != null ){ %>--%>
<%--            <%= request.getAttribute("errorMessage") %>--%>
<%--            <% } %>--%>
<%--</form><br>--%>


<% if (AppSession.isAuthenticated()) {%>

Suppliers:
<form action="pullServlet" method="post">
    <%  Transactor hq= AppSession.getUser();
        for (Transactor i : hq.getMyTransactors()) {
    %>
    <input type="number" name="quantity" min="1" required >
    <button name="pluspallet" type="submit" value="<%=i.getID()%>" required>Buy Product</button><%=i.getName()%> DESERIALISED STOCKDTO GOES HERE <br>

    <% } %>
</form><br>
<% } %>



</body>
</html>

