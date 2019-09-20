<%--
  Created by IntelliJ IDEA.
  User: tomglynch
  Date: 18/9/19
  Time: 6:16 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="domain.Persistance" %>
<%@ page import="domain.Transaction" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <%
        for (Transaction i : Persistance.getAllTransactions()) {
    %>
    <li>
        TransactionID: <%=i.getNumPallets()%> Date: <%=i.getDate()%> From:  <%=i.getFrom()%> To:  <%=i.getTo()%>
    </li>
    <% } %>
</ul>
</body>
</html>
