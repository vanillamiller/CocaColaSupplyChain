<%--
  Created by IntelliJ IDEA.
  User: tomglynch
  Date: 18/9/19
  Time: 6:16 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="domain.TransactorMapper" %>
<%@ page import="domain.*" %>

<html>
<head>
    <title>Transaction Viewer</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

All transactions:


<table style="width:500px">
    <thead>
    <th>TransactionID</th><th>NumPallets</th><th>Date</th><th>From</th><th>To</th>
    </thead>
    <tbody>
    <%
//        CocaColaHQ hq=CocaColaHQMapper.find(0);

        Transactor t = Transactor.get(AppSession.getUser());


        int curr, prev=-1;
        for (Transaction i : hq.getTransactions()) {
            System.out.println();
    %>

    <%      curr=i.getFrom();
            if(curr!=prev){%>
                <tr><th colspan="5"><%=dcmap.find(i.getFrom()).getName()%></th></tr>
            <% } %>
        <tr>
<%--            <td><%=i.gettxID()%></td>--%>
<%--            <td><%=i.getNumPallets()%></td>--%>
            <td><%=i.getDate()%></td>
            <td><%=dcmap.find(i.getFrom()).getName()%></td>
            <td><%=rmap.find(i.getTo()).getName()%></td>
        </tr>

    <%      prev=i.getFrom();
        } %>
    </tbody>
    </table>

</body>
</html>
