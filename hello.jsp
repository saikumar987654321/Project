<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Login</title>
</head>
<body>
    <h1>User Login</h1>
    <% if (request.getParameter("error") != null) { %>
        <p style="color: red;">Invalid username or password</p>
    <% } %>
    <form action="HelloServlet
    " method="post">
        <input type="text" name="username" placeholder="Username" required><br>
        <input type="password" name="password" placeholder="Password" required><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
