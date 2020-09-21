<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create page</title>
</head>

<body>
<center>
    <form method="post" action="/product/create">
        <label>${id_tit}</label>
        <input type="text" name="id"><br><br>

        <label>${a_tit}</label>
        <input type="text" name="a"><br><br>

        <label>${b_tit}</label>
        <input type="text" name="b"><br><br>

        <label>${c_tit}</label>
        <input type="text" name="c"><br><br>

        <label>${d_tit}</label>
        <input type="text" name="d"><br><br>

        <label>${e_tit}</label>
        <input type="text" name="e"><br><br>

        <label>${f_tit}</label>
        <input type="text" name="f"><br><br>

        <input type="submit" value="Save">
    </form>
</center>
</body>
</html>