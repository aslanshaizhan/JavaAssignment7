<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Servlet Form</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            font-family: Arial, Helvetica, sans-serif;
        }

        /* Style the header */
        header {
            background-color: #666;
            padding: 30px;
            text-align: center;
            font-size: 35px;
            color: white;
        }

        /* Create two columns/boxes that floats next to each other */
        nav {
            float: left;
            width: 30%;
            height: 300px; /* only for demonstration, should be removed */
            background: #ccc;
            padding: 20px;
        }

        /* Style the list inside the menu */
        nav ul {
            list-style-type: none;
            padding: 0;
        }

        article {
            float: left;
            padding: 20px;
            width: 70%;
            background-color: #f1f1f1;
            height: 300px; /* only for demonstration, should be removed */
        }

        /* Clear floats after the columns */
        section::after {
            content: "";
            display: table;
            clear: both;
        }

        /* Style the footer */
        footer {
            background-color: #777;
            padding: 10px;
            text-align: center;
            color: white;
        }

        /* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
        @media (max-width: 600px) {
            nav, article {
                width: 100%;
                height: auto;
            }
        }
    </style>
</head>
<body>

<%@include file="header.jsp"%>

<section>
    <nav>
        <ul>
            <li><a href="userRegister.jsp">Registration</a></li>
            <li><a href="userLogin.jsp">Login</a></li>
            <li><a href="postsList.jsp">List of Posts</a></li>
            <li><a href="contacts.jsp">Contacts</a></li>
        </ul>
    </nav>

    <article>
        <h1>This is a Forum website</h1>
        <p>Forums have a specific set of jargon associated with them; example: a single conversation is called a "thread", or topic.
            A discussion forum is hierarchical or tree-like in structure: a forum can contain a number of subforums, each of which may have several topics. Within a forum's topic, each new discussion started is called a thread and can be replied to by as many people as so wish.
        </p>
        <p>In this Forum we can add your posts and comments</p>

        <%@ page import="java.util.Date" %>
        Today is: <%= new Date() %>
    </article>
</section>

<%@include file="footer.jsp"%>

</body>
</html>
