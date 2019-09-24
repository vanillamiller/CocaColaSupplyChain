<%--
  Created by IntelliJ IDEA.
  User: tomglynch
  Date: 18/9/19
  Time: 6:16 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="domain.TransactionMapper" %>
<%@ page import="domain.Transaction" %>

<html>
<head>
    <title>Transaction Viewer</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

All transactions:
<table style="width:500px">
    <th>TransactionID</th><th>NumPallets</th><th>Date</th><th>From</th><th>To</th>
    <%
        for (Transaction i : TransactionMapper.findAllTransactions()) {
    %>
    <tr>
        <th><%=i.gettxID()%></th><th><%=i.getNumPallets()%></th><th><%=i.getDate()%></th><th><%=i.getFrom()%></th><th><%=i.getTo()%></th>
    </tr>
    <% } %>
</table>
</body>
</html>
