<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="./style/css_style.css">
    <title>Customer</title>
</head>
<body>
<h2>Customer List</h2>
<p>
    <button><a href="/index.jsp">Back to home</a></button>
</p>
<table>
    <tr>
        <th>ID</th>
        <th>${title_a}</th>
        <th>${title_b}</th>
        <th>${title_c}</th>
        <th>${title_d}</th>
        <th>${title_e}</th>
        <th>${title_f}</th>
        <th>${title_g}</th>
        <th>${title_h}</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.customerId}</td>
            <td>${customer.customerName}</td>
            <td>${customer.customerBirthday}</td>
            <td>${customer.customerGender}</td>
            <td>${customer.customerIdCard}</td>
            <td>${customer.customerPhone}</td>
            <td>${customer.customerEmail}</td>
            <td>${customer.customerAddress}</td>
            <td>${customer.customerType}</td>
            <td><a href="/furama/customers?action=edit&id=${customer.customerId}">Edit</a></td>
            <td><a href="/furama/customers?action=delete&id=${customer.customerId}">Delete</a></td>
        </tr>
    </c:forEach>
</table>


<script src="http://code.jquery.com/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</body>
</html>
