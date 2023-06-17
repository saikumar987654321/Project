<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calculator</title>
</head>
<body>
    <h1>Calculator</h1>
    <form action="CalculatorServlet" method="post">
        <input type="number" name="num1" placeholder="Enter number 1" required><br>
        <input type="number" name="num2" placeholder="Enter number 2" required><br>
        <select name="operator">
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="*">*</option>
            <option value="/">/</option>
        </select><br>
        <input type="submit" value="Calculate">
    </form>

    <% if (request.getAttribute("result") != null) { %>
        <h2>Result: <%= request.getAttribute("result") %></h2>
    <% } %>
</body>
</html>
