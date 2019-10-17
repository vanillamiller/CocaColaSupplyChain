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

<h2>Welcome to the Internal Dashboard</h2>
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
            Suppliers:
            <form action="pullServlet" method="post">
            <%  Transactor hq= AppSession.getUser();
                for (Transactor i : hq.getMyTransactors()) {
            %>
                <input type="number" name="quantity" min="1" required >
                <button name="pluspallet" type="submit" value="<%=i.getID()%>" required>Pull Product</button><%=i.getName()%> DESERIALISED STOCKDTO GOES HERE <br>

            <% } %>
            </form><br>
    <% } %>
<% } %>

</body>
</html>