<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index page</title>
</head>
<body>

<h1>Email Validation</h1>
<h3 style="color:red">${message}</h3>

<form method="post" action="/validate">
    <input type="text" name="email"><br>
    <br>
    <input type="submit" value="Validate">
</form>
</body>
</html>
