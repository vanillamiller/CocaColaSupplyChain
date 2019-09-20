<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="domain.Persistance" %>
<%@ page import="domain.DC" %>
<%@ page import="domain.Pallet" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CocaCola Supply Chain Internal</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

<h2>Welcome to the CocaCola HQ</h2>

<br>


    Distribution Centers:
    <%
        for (DC i : Persistance.getAllDCs()) {
    %>
    <form action="amakePalletServlet" method="post">
        <%=i.getname() + ": "%><button name="pluspallet" type="submit" value="<%=i.getDCId()%>">+1 Pallet</button>
<%--        <option value="<%=i.getDCId()%>"><%=i.getname()%></option>--%>
<%--        <input type="submit" value="Mix, Bottle and Send to DC">--%>
    </form><br>
    <% } %>

    <h3>All Pallets:</h3>
    <ul>
    <%
        for (Pallet i : Persistance.getAllPallets()) {
    %>
        <li>
            PalletID: <%=i.getPalletID()%> Date: <%=i.getDate()%> Flavour:  <%=i.getFlavour()%>
        </li>
    <% } %>
    </ul>

</body>
</html>