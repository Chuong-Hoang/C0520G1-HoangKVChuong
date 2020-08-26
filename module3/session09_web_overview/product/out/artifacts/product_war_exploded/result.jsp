<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 26/08/2020
  Time: 4:07 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Discount Result</title>
</head>
<body>
<h1>Discount Calculation Result</h1>
<h3>Description: <%= request.getParameter("description")%></h3>
<h3>Price: <%= request.getParameter("price")%></h3>
<h3>Discount: <%= request.getParameter("discount")%></h3>
<h3>Discount Amount: <%= request.getAttribute("discountAmount")%></h3>
<h3>Discount Price: <%= request.getAttribute("discountPrice")%></h3>
</body>
</html>
