<%@ page import="domain.AppSession" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>CocaCola POS</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-light bg-light">
    <span class="navbar-brand mb-0 h1">CocaCola POS Portal</span>
</nav>
<div class="container">

    <div class="container d-flex justify-content-center">

        <div class="card">
            <div class="card-header">
                <h2>Welcome to the CocaCola's Point of Sales system</h2>
            </div>
            <div class="card-body">
                <% if (!AppSession.isAuthenticated()) {%>
                <form action="loginServlet" method="post">
                    Username: <input type="text" name="username">
                    Password: <input type="text" name="password">
                    <input type="submit" value="login">
                </form>
                <%} else{%>
                <div> you have already logged in</div>
                <% } %>
                <%
                    if(request.getAttribute("errorMessage") != null ){ %>
                <%= request.getAttribute("errorMessage") %>
                <% } %>

            </div>
        </div>

    </div>

</div>

<div class="fixed-bottom">
    <nav class="navbar navbar-light bg-light">
        <span class="navbar-brand mb-0 h1">CocaCola POS Portal</span>
    </nav>
</div>
</body>
</html>