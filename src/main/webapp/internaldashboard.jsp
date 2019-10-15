<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="domain.DC" %>
<%@ page import="domain.CocaColaHQ" %>
<%@ page import="domain.CocaColaHQMapper" %>
<%@ page import="domain.AppSession" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CocaCola Supply Chain Internal</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

<h2>Welcome to the CocaCola HQ</h2>
<a href="transactionviewer.jsp" class="btn btn-primary">See all transactions</a>
<br>

    <% if (AppSession.isAuthenticatated()) {%>
        <% if(AppSession.hasRole("hq")) {%>
            Distribution Centers:
            <%  CocaColaHQ hq= CocaColaHQMapper.find(0);
                for (DC i : hq.getDistList()) {
            %>

    <form action="makePalletServlet" method="post">
        <input type="number" name="quantity" min="1" required >
        <button name="pluspallet" type="submit" value="<%=i.getID()%>" required>Add Pallet</button><%=i.getName()%> <%=i.getnumPallets()%>
        <button name="pluspallet" type="submit" value="<%=i.getID()%>" required>Add Pallet</button><%=i.getName()%> <%=i.getnumPallets()%>
        <button name="pluspallet" type="submit" value="<%=i.getID()%>" required>Add Pallet</button><%=i.getName()%> <%=i.getnumPallets()%>
    </form><br>
            <% } %>
        <% } %>
    <% } %>



</body>
</html>