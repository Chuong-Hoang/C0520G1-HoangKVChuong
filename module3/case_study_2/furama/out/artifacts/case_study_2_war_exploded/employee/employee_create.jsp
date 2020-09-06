<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../style/css_style.css">

    <title>${create_element}</title>
</head>
<body>
<center>
    <h2>${create_element}</h2>
    <p><span>${msg_create}</span></p>
    <form method="post">
        <input type="hidden" name="action" value="create">

        <fieldset>${element_name.toUpperCase()} INFORMATION
            <table>
                <tr>
                    <td>${title_id}</td>
                    <td><input type="text" name="id" id="id"></td>
                </tr>
                <tr>
                    <td>${title_a}</td>
                    <td><input type="text" name="a" id="a"></td>
                </tr>
                <tr>
                    <td>${title_b}</td>
                    <td><input type="text" name="b" id="b"></td>
                </tr>
                <tr>
                    <td>${title_c}</td>
                    <td><input type="text" name="c" id="c"></td>
                </tr>
                <tr>
                    <td>${title_d}</td>
                    <td><input type="text" name="d" id="d"></td>
                </tr>
                <tr>
                    <td>${title_e}</td>
                    <td><input type="text" name="e" id="e"></td>
                </tr>
                <tr>
                    <td>${title_f}</td>
                    <td><input type="text" name="f" id="f"></td>
                </tr>
                <tr>
                    <td>${title_g}</td>
                    <td><input type="text" name="g" id="g"></td>
                </tr>
                <tr>
                    <td>${title_h}</td>
                    <td><input type="text" name="h" id="h"></td>
                </tr>
                <tr>
                    <td>${title_i}</td>
                    <td><input type="text" name="i" id="i"></td>
                </tr>
                <tr>
                    <td>${title_j}</td>
                    <td><input type="text" name="j" id="j"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Create ${element_name}"></td>
                    <td><button type="button"><a href=${originalLink}>Back to ${element_name} list</a></button></td>
                </tr>
            </table>
        </fieldset>
    </form>
</center>

<script src="http://code.jquery.com/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>
