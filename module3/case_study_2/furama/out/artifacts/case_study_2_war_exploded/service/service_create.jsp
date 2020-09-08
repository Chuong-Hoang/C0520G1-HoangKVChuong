<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/common/head_link.jsp" %>
    <title>${create_element}</title>
</head>
<body>
<!-- Header -->
<%@ include file="/common/header.jsp"%>
<!-- end -->

<!-- Navigation -->
<%@ include file="/common/navigation.jsp"%>
<!-- end -->

<!-- Body page -->
<center>
    <h2>${create_element}</h2>
    <p><span class="msg-info">${msg_create}</span></p>
    <form method="post">
        <input type="hidden" name="action" value="create">
        <label>Select an option</label>
        <select name="option" id="option" onchange="getOption();">
            <option selected>Villa</option>
            <option>House</option>
            <option>Room</option>
        </select>

        <fieldset>${element_name.toUpperCase()} INFORMATION
            <table class="table table-striped table-hover" style="width: 25%">
                <tr>
                    <td scope="col">${title_id}</td>
                    <td scope="col"><input type="text" name="id" id="id"></td>
                </tr>
                <tr>
                    <td scope="col">${title_a}</td>
                    <td scope="col"><input type="text" name="a" id="a"></td>
                </tr>
                <tr>
                    <td scope="col">${title_b}</td>
                    <td scope="col"><input type="text" name="b" id="b"></td>
                </tr>
                <tr>
                    <td scope="col">${title_c}</td>
                    <td scope="col"><input type="text" name="c" id="c"></td>
                </tr>
                <tr>
                    <td scope="col">${title_d}</td>
                    <td scope="col"><input type="text" name="d" id="d"></td>
                </tr>
                <tr>
                    <td scope="col">${title_e}</td>
                    <td scope="col"><input type="text" name="e" id="e"></td>
                </tr>
                <tr>
                    <td scope="col">${title_f}</td>
                    <td scope="col"><input type="text" name="f" id="f"></td>
                </tr>
                <tr>
                    <td scope="col">${title_g}</td>
                    <td scope="col"><input type="text" name="g" id="g"></td>
                </tr>
                <tr>
                    <td scope="col">${title_h}</td>
                    <td scope="col"><input type="text" name="h" id="h"></td>
                </tr>
                <tr>
                    <td scope="col">${title_i}</td>
                    <td scope="col"><input type="text" name="i" id="i"></td>
                </tr>
                <tr>
                    <td scope="col">${title_j}</td>
                    <td scope="col"><input type="text" name="j" id="j"></td>
                </tr>
                <tr>
                    <td scope="col"><button type="submit"  class="btn btn-outline-danger btn-sm">Create ${element_name}</td>
                    <td scope="col"><button type="button" class="btn btn-outline-info btn-sm"><a href=${originalLink}>Back to ${element_name} list</a></button></td>
                </tr>
            </table>
        </fieldset>
    </form>
</center>
<!-- End body -->

<!-- Footer -->
<script src="../style/service_option.js"></script>
<%@ include file="/common/foot_script.jsp"%>
<%@ include file="/common/footer.jsp"%>
<!-- end -->
</body>
</html>
