<%--
  Created by IntelliJ IDEA.
  User: tomglynch
  Date: 18/9/19
  Time: 6:16 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="domain.DBTransactionMapper" %>
<%@ page import="domain.Transaction" %>

<html>
<head>
    <title>Transaction Viewer</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<ul>
    <%
        for (Transaction i : DBTransactionMapper.findAllTransactions()) {
    %>
    <li>
        TransactionID: <%=i.getNumPallets()%> &#9 Date: <%=i.getDate()%> &#9 From:  <%=i.getFrom()%> &#9 To:  <%=i.getTo()%>
    </li>
    <% } %>
</ul>
</body>
</html>
