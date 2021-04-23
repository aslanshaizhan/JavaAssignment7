<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="dao.LoginDao"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login Success</title>
</head>
<body>
<div align="center">
    <% System.out.println("You have logged successfully!"); %>
    <% (HttpServlet)page.log("Go to the main page!"); %>
</div>
</body>
</html>
