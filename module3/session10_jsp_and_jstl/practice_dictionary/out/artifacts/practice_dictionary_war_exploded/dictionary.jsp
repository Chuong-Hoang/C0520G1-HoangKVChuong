<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27/08/2020
  Time: 10:07 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<%!
    Map<String, String> dic = new HashMap<>();
%>

<%
    dic.put("hello", "xin chào");
    dic.put("how", "thế nào");
    dic.put("notebook", "quyển vở");
    dic.put("love", "tình yêu");

    String search = request.getParameter("searchWord");
    String result = dic.get(search);
    if(result != null) {
        out.println("Word: " + search);
        out.println("<br>");
        out.println("Result: " + result);
    } else {
        out.print("Not found");
    }
%>
</body>
</html>
