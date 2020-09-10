<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/common/head_link.jsp" %>
    <title>${element_name}</title>
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
    <h2>${list_element.toUpperCase()}</h2>
    <p>
    <form method="post" action="${originalLink}">
        <button class="btn btn-outline-info btn-sm">
            <a href="/customers?action=create">Create Customer</a>
        </button>
        <span>&nbsp;</span>
        <button class="btn btn-outline-info btn-sm">
            <a href="/employees?action=create">Create Employee</a>
        </button>
        <span>&nbsp;</span>
        <button class="btn btn-outline-info btn-sm">
            <a href="/services?action=create">Create Service</a>
        </button>
        <span>&nbsp;</span>
        <button class="btn btn-outline-info btn-sm">
            <a href="/contracts?action=create">Create Contract</a>
        </button>
        <span>&nbsp;</span>
        <button class="btn btn-outline-info btn-sm">
            <a href="/contract-details?action=create">Create Contract Detail</a>
        </button>
        <span>&nbsp;</span>
        <button class="btn btn-outline-info btn-sm">
            <a href="/home.jsp">Back to home</a>
        </button>

        <input type="hidden" name="action" value="search">
        <input class="mr-sm-2" style="width: 200px" type="text" name="keywords" placeholder="search start date">
        <button class="btn btn-outline-info btn-sm" type="submit">Search</button>
    </form>
    </p>

    <table id="pagination" class="table table-striped table-hover">
        <thead class="thead">
        <tr class="table-info">

            <th scope="col">${title_a}</th>
            <th scope="col">${title_b}</th>
            <th scope="col">${title_c}</th>
            <th scope="col">${title_d}</th>
            <th scope="col">${title_e}</th>
            <th scope="col">${title_f}</th>
            <th scope="col">${title_g}</th>

            <th scope="col">Total Amount</th>
            <!-- Task 3.10 - CLEAR ON SCREEN -->
            <th scope="col">Clear</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${eList}" var="el">

            <tr id="${el.customerId}">
                <td scope="col">${el.customerId}</td>
                <td scope="col">${el.customerName}</td>
                <td scope="col">${el.contractId}</td>
                <td scope="col">${el.serviceId}</td>
                <td scope="col">${el.serviceName}</td>
                <td scope="col">${el.contractTotalMoney}</td>
                <td scope="col">${el.attachServiceTotalMoney}</td>
                <td scope="col">${Double.parseDouble(el.contractTotalMoney) + Double.parseDouble(el.attachServiceTotalMoney)}</td>

                <!-- Task 3.10 - CLEAR ON SCREEN -->
                <td scope="col">
                    <button type="button" class="btn btn-outline-success btn-sm" onclick="displayHiddenElement('${el.customerId}')">CLEAR</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</center>
<!-- End body -->

<!-- Footer -->
<%@ include file="/common/foot_script.jsp"%>
<%@ include file="/common/footer.jsp"%>
<!-- end -->
</body>
</html>
