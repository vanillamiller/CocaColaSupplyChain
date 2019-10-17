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

<h2>Welcome to <%=AppSession.getUser().getName()%> Dashboard</h2>

<a href="transactionviewer.jsp" class="btn btn-primary">See all transactions</a>
<br>

    <% if (AppSession.isAuthenticated()) {%>
        <% if (AppSession.hasRole("hq")) {%>
            Hi CCHQ. No need to make syrup, it's done automatically when the bottler requests more!
<%--            <form action="makeSyrupServlet" method="post">--%>
<%--                <input type="number" name="quantity" min="1" required >--%>
<%--                <button name="plussyrup" type="submit" required>Make Syrup</button>--%>
<%--            </form><br>--%>
        <% } else { %>
            Submit your order from a supplier:
            <form action="pullServlet" method="post">
            <%  Transactor t= AppSession.getUser();
                for (Transactor i : t.getMyTransactors()) {
            %>
                <b><%=i.getName()%></b><br>
                <input type="hidden" name="toID" value=<%=t.getID()%>>
                Regular: <input type="number" name="quantityreg" value="0" min="0" required >
                Vanilla: <input type="number" name="quantityvan" value="0" min="0" required >
                Zero: <input type="number" name="quantityzero" value="0" min="0" required >
                <button name="fromID" type="submit" value="<%=i.getID()%>" required>Place Order</button>
                <br>
                Current stock: <%=StockDTO.toJson(i.getStock())%> TODO in JSON atm, need to make it back to regular.<br>



            <% } %>
            </form><br>
    <% } %>
<% } %>
</div>
</body>
</html>