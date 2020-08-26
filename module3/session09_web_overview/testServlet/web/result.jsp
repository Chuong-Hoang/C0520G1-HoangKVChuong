<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 26/08/2020
  Time: 3:06 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style_css.css">
    <title>Result</title>
</head>
<body>
<h1>Result is: <%= request.getParameter("username") %></h1>
<h1>Full Name is: <%= request.getAttribute("full_name") %></h1>
</body>
</html>
