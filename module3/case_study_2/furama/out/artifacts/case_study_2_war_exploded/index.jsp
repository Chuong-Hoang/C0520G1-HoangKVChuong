<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/common/head_link.jsp" %>
    <title>Furama Resort</title>
</head>
<body style="background-color: lavenderblush">
<center>
    <br>
    <h3 style="color: blue;">FURAMA RESORT MANAGEMENT</h3>
    <hr class="my-5" width="97%">
    <div style="height: 400px">
        <p><span class="msg-invalid">${msg_login}</span></p>
        <form method="post" action="/login" style="border: 1px solid lightgray; width: 20%; color: blue; padding: 5px">
            <fieldset>
                <input type="hidden" name="action" value="login">
                <label>Username</label><br>
                <input type="text" id="username" name="username" placeholder="username" value="${username}"><br>
                <br>
                <label>Password</label><br>
                <input type="password" id="password" name="password" placeholder="password"  value="${password}"><br>
                <input type="checkbox" id="remember" name="remember"> Remember me?<br>
                <br>
                <button class="btn btn-outline-success btn-sm" type="submit">Login</button>
            </fieldset>
        </form>
    </div>
</center>
<!-- End body -->

<!-- Footer -->
<%@ include file="/common/footer.jsp" %>
<%@ include file="/common/foot_script.jsp" %>
<!-- end -->
</body>
</html>
