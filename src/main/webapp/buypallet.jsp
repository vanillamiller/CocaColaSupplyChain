<%--
  Created by IntelliJ IDEA.
  User: tomglynch
  Date: 17/9/19
  Time: 6:16 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%
System.out.println("pallet bought! ");
System.out.println(request.getAttribute("pallets"));
System.out.println((String)request.getAttribute("pallets"));
//request.setAttribute("pallets", (String)(Integer.parseInt((String)request.getAttribute("pallets")) + 1));
request.getRequestDispatcher("/retailerloggedin.jsp").forward(request, response);
%>



<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
