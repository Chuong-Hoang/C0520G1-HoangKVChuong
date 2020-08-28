<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27/08/2020
  Time: 9:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator Mini</title>
</head>
<body>
<h2>Result:</h2>
<p><c:out value="${firstOperand}"/>
<c:out value="${operator}"/>
<c:out value="${secondOperand}"/>
<c:out value="${' = '}"/>
<c:out value="${result}"/>
</p>
</body>
</html>
