<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="dao.UserDao"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Registration Success!</title>
</head>
<body>
<div align="center">
    <% System.out.println("You are registered successfully!"); %>
    <form action="<% response.sendRedirect("Main page");%>/index.jsp" method="post">
        <% (HttpServlet)page.log("Go to the main page!"); %>
        <input type="submit" value="Submit"/>
    </form>
</div>
</body>
</html>
