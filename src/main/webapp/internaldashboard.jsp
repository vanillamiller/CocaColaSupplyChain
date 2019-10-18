<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="domain.*" %>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CocaCola Supply Chain Internal</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-light bg-light">
    <span class="navbar-brand mb-0 h1">CocaCola Supply Chain Portal</span>
</nav>
<div class="container">



    <% if (AppSession.isAuthenticated()) {%>
    <h2>Welcome <%=AppSession.getUser().getName()%> to the Dashboard</h2><br>
    All values are the quantity in pallets<br>
    <b>Your current stock levels: </b><br>
    <% StockDTO user = StockDTO.readJsonString(AppSession.getUser().getStock());%>
    Regular: <%=user.getNumRegular()%> Vanilla: <%=user.getNumVanilla()%> Zero: <%=user.getNumZero()%><br>


    <a href="transactionviewer.jsp" class="btn btn-primary">See all transactions</a>

    <br>
        <% if (AppSession.hasRole("hq")) {%>
            Hi CCHQ. No need to make syrup, it's done automatically when the bottler requests more!
            <form action="makeSyrupServlet" method="post">
                <input type="number" name="quantity" min="1" required >
                <button name="toID" type="submit" value="<%=AppSession.getUser().getID()%>" required>Make Syrup</button>
            </form><br>
        <% } else if(AppSession.hasRole("bt")) { %>
            Submit your order from a supplier:
            <form action="pullServlet" method="post">
            <%  Transactor t= AppSession.getUser();
                for (Transactor i : t.getMyTransactors()) {
            %>
                <h3><%=i.getName()%></h3><br>
                <input type="hidden" name="toID" value=<%=t.getID()%>>
                Regular Syrup Barrels: <input type="number" name="quantityreg" value="0" min="0" required >
                Vanilla Syrup Barrels: <input type="number" name="quantityvan" value="0" min="0" required >
                Zero Syrup Barrels: <input type="number" name="quantityzero" value="0" min="0" required >
                <button name="fromID" type="submit" value="<%=i.getID()%>" required>Order barrels and bottle coke</button>
                <br>
                Barrels are available at all times
<%--                <% StockDTO fromuser = StockDTO.readJsonString(i.getStock());%>--%>
<%--                Current stock: Regular: <%=fromuser.getNumRegular()%> Vanilla: <%=fromuser.getNumVanilla()%> Zero: <%=fromuser.getNumZero()%><br><br>--%>

            <% } %>
            </form><br>
            <% } else { %>
            Submit your order from a supplier:
            <form action="pullServlet" method="post">
                <%  Transactor t= AppSession.getUser();
                    for (Transactor i : t.getMyTransactors()) {
                %>
                <h3><%=i.getName()%></h3><br>
                <% StockDTO fromuser = StockDTO.readJsonString(i.getStock());%>
                Current available stock: Regular: <%=fromuser.getNumRegular()%> Vanilla: <%=fromuser.getNumVanilla()%> Zero: <%=fromuser.getNumZero()%><br>
                <input type="hidden" name="toID" value=<%=t.getID()%>>
                Regular Pallets: <input type="number" name="quantityreg" value="0" min="0" required >
                Vanilla Pallets: <input type="number" name="quantityvan" value="0" min="0" required >
                Zero Pallets: <input type="number" name="quantityzero" value="0" min="0" required >
                <button name="fromID" type="submit" value="<%=i.getID()%>" required>Order Pallets</button>
                <%
                    if(request.getAttribute("errorMessage") != null ){ %>
                <%= request.getAttribute("errorMessage") %>
                <% } %>
                <br>
                <br>

                <% } %>
            </form><br>
            <% } %>
<% } %>
</div>
</body>
</html>