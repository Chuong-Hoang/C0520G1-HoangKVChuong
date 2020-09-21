<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit page</title>
</head>
<body>
<center>
    <form method="post" action="/product/edit">
        <label>${id_tit}</label>
        <input type="text" name="id" value="${el.productId}" readonly style="background-color: #d5d5d5"><br><br>

        <label>${a_tit}</label>
        <input type="text" name="a" value="${el.productName}"><br><br>

        <label>${b_tit}</label>
        <input type="text" name="b" value="${el.productPrice}"><br><br>

        <label>${c_tit}</label>
        <input type="text" name="c" value="${el.productQuantity}"><br><br>

        <label>${d_tit}</label>
        <input type="text" name="d" value="${el.productColor}"><br><br>

        <label>${e_tit}</label>
        <input type="text" name="e" value="${el.productDescription}"><br><br>

        <label>${f_tit}</label>
        <input type="text" name="f" value="${el.productCategory}"><br><br>

        <input type="submit" value="Update">
    </form>
</center>
</body>
</html>
