<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create page</title>
</head>
<body>
<form:form action="email/create" method="post" modelAttribute="el">
    <table>
        <tr>
            <td><form:label path="language">Language</form:label></td>
            <td><form:select path="language" items="${languageArray}" /></td>
        </tr>

        <tr>
            <td><form:label path="pageSize">Page Size</form:label></td>
            <td>Show &nbsp;<form:select path="pageSize" items="${pageSizeArray}" />&nbsp; emails per page</td>
        </tr>

        <tr>
            <td><form:label path="spamsFilter">Spams Filter</form:label></td>
            <td>
                <form:checkbox path="spamsFilter" value="Enable spams filter" />&nbsp;&nbsp;
                <form:label path="spamsFilter">Enable spams filter</form:label>
            </td>
        </tr>

        <tr>
            <td><form:label path="signature">Signature</form:label></td>
            <td><form:textarea path="signature" /></td>
        </tr>

        <tr>
            <td>
                <input type="submit" value="Update"/>
            </td>
            <td>
                <button type="button"><a href="/email">Cancel</a></button>
            </td>
        </tr>
    </table>


</form:form>
</body>
</html>
