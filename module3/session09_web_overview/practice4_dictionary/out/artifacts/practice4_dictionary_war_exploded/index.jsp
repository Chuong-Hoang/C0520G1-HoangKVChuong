<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25/08/2020
  Time: 9:40 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Dictionary</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
<%--    <style>--%>
<%--      h2 {--%>
<%--        color: green;--%>
<%--      }--%>
<%--    </style>--%>
  </head>
  <body>
  <h2>Vietnamese Dictionary</h2>
  <form action="search" method="get">
    <input type="text" name="txtSearch" placeholder="Enter your word: ">
    <input type="submit" id="submit" value="Search">
  </form>
  </body>
</html>
