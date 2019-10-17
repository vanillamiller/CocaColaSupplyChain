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
        <% if(AppSession.hasRole("hq")) {%>
            <h2>Welcome to the CocaCola HQ</h2>
            <a href="transactionviewer.jsp" class="btn btn-primary">See all transactions</a>
            <br>
            Distribution Centers:
            <%  CocaColaHQ hq= CocaColaHQMapper.find(0);
                for (Transactor i : hq.getDistList()) {
            %>

    <form action="makePalletServlet" method="post">
        <input type="number" name="quantity" min="1" required >
        <button name="pluspallet" type="submit" value="<%=i.getID()%>" required>Add Pallet</button><%=i.getName()%>
        <button name="pluspallet" type="submit" value="<%=i.getID()%>" required>Add Pallet</button><%=i.getName()%>
        <button name="pluspallet" type="submit" value="<%=i.getID()%>" required>Add Pallet</button><%=i.getName()%>
    </form><br>
            <% } %>
        <% } %>
        <% if(AppSession.hasRole("bt")) {%>
            <h2>Welcome to <%=AppSession.getUser().getName()%> Dashboard</h2>
        <%}%>
        <% if(AppSession.hasRole("dc")) {%>
            <h2>Welcome to <%=AppSession.getUser().getName()%> Dashboard</h2>
            <div>hello </div>
        <%}%>
    <% } %>

</div>




</body>
</html>