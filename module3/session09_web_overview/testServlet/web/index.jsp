<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 26/08/2020
  Time: 2:52 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Hello World!</h1>
  <form action="/testServlet" method="get">
  <input type="text" name="username">
  <input type="submit" value="Send name">
  </form>

  <a href="/testServlet?username=admin111">Click to servlet</a>

  <a href="result.jsp">Click to Result</a>
  </body>
</html>
