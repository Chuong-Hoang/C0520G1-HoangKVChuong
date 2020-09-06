<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../style/css_style.css">

    <title>${element_name}</title>
</head>
<body>

<center>
<h2>${list_element.toUpperCase()}</h2>
<p>
    <form method="post" action="${originalLink}">
        <button><a href="${originalLink}?action=create">${create_element}</a> </button>
        <button><a href="/index.jsp">Back to home</a></button>
        <span>&nbsp;</span>
        <button><a href="${originalLink}">Back to ${element_name} list</a></button>
        <span>&nbsp;</span>
        <button><a href="${originalLink}?action=sort-by-name">Sort Name</a> </button>
        <input type="hidden" name="action" value="search">
        <input type="text" name="keywords" placeholder="search name">
        <input type="submit" value="Search">
    </form>
</p>

<table>
    <tr>
        <th>${title_id}</th>
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
        <th>View</th>
    </tr>
    <c:forEach items="${eList}" var="el">
        <tr>
            <td>${el.customerId}</td>
            <td>${el.customerName}</td>
            <td>${el.customerBirthday}</td>
            <td>${el.customerGender}</td>
            <td>${el.customerIdCard}</td>
            <td>${el.customerPhone}</td>
            <td>${el.customerEmail}</td>
            <td>${el.customerAddress}</td>
            <td>${el.customerTypeId}</td>
            <td><a href="${originalLink}?action=edit&id=${el.customerId}">Edit</a></td>
            <td><a href="${originalLink}?action=delete&id=${el.customerId}">Delete</a></td>
            <td><a href="${originalLink}?action=view&id=${el.customerId}">View</a></td>
        </tr>
    </c:forEach>
</table>
</center>

<script src="http://code.jquery.com/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>
