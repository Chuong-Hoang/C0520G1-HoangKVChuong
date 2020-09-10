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
            <option selected>Import</option>
            <option>Export</option>
        </select>

        <fieldset>${element_name.toUpperCase()} INFORMATION
            <table class="table table-striped table-hover" style="width: 35%">
                <tr>
                    <td scope="col">${title_id}</td>
                    <td scope="col"><input type="text" name="id" id="id" value="${id}">
                        <span class="msg-invalid">(*)</span><br>
                        <span class="msg-invalid">${msg_invalid_id}</span>
                    </td>
                </tr>
                <tr>
                    <td scope="col">${title_a}</td>
                    <td scope="col"><input type="text" name="a" id="a" value="${a}">
                        <span class="msg-invalid">(*)</span><br>
                        <span class="msg-invalid">${msg_invalid_a}</span>
                    </td>
                </tr>
                <tr>
                    <td scope="col">${title_b}</td>
                    <td scope="col"><input type="text" name="b" id="b" value="${b}">
                        <span class="msg-invalid">(*)</span><br>
                        <span class="msg-invalid">${msg_invalid_b}</span>
                    </td>
                </tr>
                <tr>
                    <td scope="col">${title_c}</td>
                    <td scope="col"><input type="text" name="c" id="c" value="${c}">
                        <span class="msg-invalid">(*)</span><br>
                        <span class="msg-invalid">${msg_invalid_c}</span>
                    </td>
                </tr>
                <tr>
                    <td scope="col">${title_d}</td>
                    <td scope="col"><input type="text" name="d" id="d" value="${d}">
                        <span class="msg-invalid">(*)</span><br>
                        <span class="msg-invalid">${msg_invalid_d}</span>
                    </td>
                </tr>
                <tr>
                    <td scope="col">${title_e}</td>
                    <td scope="col"><input type="text" name="e" id="e" value="${e}">
                        <span class="msg-invalid">(*)</span><br>
                        <span class="msg-invalid">${msg_invalid_e}</span>
                    </td>
                </tr>

                <%-- Import Product --%>
                <tr id="f-row">
                    <td scope="col">${title_f}</td>
                    <td scope="col"><input type="text" name="f" id="f" value="${f}">
                        <span class="msg-invalid">(*)</span><br>
                        <span class="msg-invalid">${msg_invalid_f}</span>
                    </td>
                </tr>
                <tr id="g-row">
                    <td scope="col">${title_g}</td>
                    <td scope="col"><input type="text" name="g" id="g" value="${g}">
                        <span class="msg-invalid">(*)</span><br>
                        <span class="msg-invalid">${msg_invalid_g}</span>
                    </td>
                </tr>
                <tr id="h-row">
                    <td scope="col">${title_h}</td>
                    <td scope="col"><input type="text" name="h" id="h" value="${h}">
                        <span class="msg-invalid">(*)</span><br>
                        <span class="msg-invalid">${msg_invalid_h}
                        </span>
                    </td>
                </tr>

                <%-- Export Product --%>
                <tr id="i-row">
                    <td scope="col">${title_i}</td>
                    <td scope="col"><input type="text" name="i" id="i" value="${i}">
                        <span class="msg-invalid">(*)</span><br>
                        <span class="msg-invalid">${msg_invalid_i}</span>
                    </td>
                </tr>
                <tr id="j-row">
                    <td scope="col">${title_j}</td>
                    <td scope="col"><input type="text" name="j" id="j" value="${j}">
                        <span class="msg-invalid">(*)</span><br>
                        <span class="msg-invalid">${msg_invalid_j}</span>
                    </td>
                </tr>
                <tr>
                    <td scope="col"><button type="submit"  class="btn btn-outline-danger btn-sm">
                        Create ${element_name}</button>
                    </td>
                    <td scope="col"><button type="button" class="btn btn-outline-info btn-sm">
                        <a href=${originalLink}>Back to ${element_name} list</a></button>
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
</center>
<!-- End body -->

<!-- Footer -->
<script src="../all/style/service_option.js"></script>
<%@ include file="/common/foot_script.jsp"%>
<%@ include file="/common/footer.jsp"%>
<!-- end -->
</body>
</html>
