<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Registration</title>
</head>
<body>
<div align="center">
    <h1>User Register Form</h1>
    <form action="<%= request.getContextPath() %>/register" method="post">
        <table style="with: 100%">
            <tr>
                <td>First Name: </td>
                <td><input type="text" name="firstname"/></td>
            </tr>
            <tr>
                <td>Last Name: </td>
                <td><input type="text" name="lastname"/></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><input type="text" name="email"/></td>
            </tr>
            <tr>
                <td>Phone Number: </td>
                <td><input type="text" name="phoneNumber"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"/></td>
            </tr>
        </table>
        <input type="submit" value="Submit"/>
    </form>
</div>
</body>
</html>
