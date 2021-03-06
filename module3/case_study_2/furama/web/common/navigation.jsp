<div class="container-fluid" style="height: 66px">
    <nav class="navbar navbar-expand-md navbar-light bg-light fixed-top">
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarResponsive">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav mr-auto">

                <li class="nav-item active">
                    <a class="nav-link" href="/home.jsp">Home
                        <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link" href="/employees">Employee
                        <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/customers">Customer
                        <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/services">Service
                        <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/contracts">Contract
                        <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/contract-details">Contract-Detail
                        <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/customer-using-services">Customer-Using-Service
                        <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/amounts">View Amount
                        <span class="sr-only">(current)</span></a>
                </li>
            </ul>
        </div>
        <p style="color: blue"><%=session.getAttribute("account_name")%></p>
        <form class="form-inline my-2 my-lg-0">
<%--            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"--%>
<%--                   style="width: 300px">--%>
<%--            <button class="btn btn-outline-success my-2 my-sm-2" type="submit">Search</button>--%>
        </form>
    </nav>
</div>
<hr class="my-4" style="width: 98%">