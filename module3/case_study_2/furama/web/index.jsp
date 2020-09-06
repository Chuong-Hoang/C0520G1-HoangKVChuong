<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="./style/css_style.css">
    <title>Furama Resort</title>
</head>
<body>

<!-- Header -->
<header>
    <div class="row container-fluid">
        <div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4" style="float:left">Furama</div>
        <div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4">Welcome to Furama Home Page</div>
        <div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4" style="float:right">Hoang Kim Van Chuong</div>
    </div>
</header>

<!-- Navigation -->
<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"><img src="image/logo_furama.jfif" height="50"/></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarResponsive">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/employees">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/customers">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/services">Service</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/contracts">Contract</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/contract-details">Contract Detail</a>
                </li>
            </ul>
        </div>

        <div class="input-group">
            <span class="input-group-btn">
                <button class="btn btn-success" type="button">Search</button>
            </span>
            <input type="text" class="form-control" placeholder="search for...">
        </div><!-- /input-group -->

    </div>
</nav>

<!-- Page Body -->
<div class="row container-fluid padding">
    <div class="col-12 col-sm-3 col-md-3 col-lg-3">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item"><a class="nav-link" href="#">Item One</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Item Two</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Item Three</a></li>
        </ul>
    </div>
    <div class="col-12 col-sm-9 col-md-9 col-lg-9">
        <!-- Carousel -->
        <div id="slides" class="carousel slide" data-ride="carousel">
            <ul class="carousel-indicators">
                <li data-target="#slides" data-slide-to="0" class="active"></li>
                <li data-target="#slides" data-slide-to="1"></li>
                <li data-target="#slides" data-slide-to="2"></li>
                <li data-target="#slides" data-slide-to="3"></li>
            </ul>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="./image/view_1.jpg"/>
                    <div class="carousel-caption">
                        <h2 class="display-2">Furama Resort</h2>
                        <h4>Make your life more beautiful</h4>
                        <button type="button" class="btn btn-primary btn-lg">Book now</button>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="./image/view_2.jpg">
                    <div class="carousel-caption">
                        <button type="button" class="btn btn-primary btn-lg">Book now</button>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="./image/view_3.jpg">
                    <div class="carousel-caption">
                        <button type="button" class="btn btn-primary btn-lg">Book now</button>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="./image/view_4.jpg">
                    <div class="carousel-caption">
                        <button type="button" class="btn btn-primary btn-lg">Book now</button>
                    </div>
                </div>
            </div>

            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <!-- End carousel -->
    </div>
</div>
<br>
<hr class="my-4">

<!-- Footer -->
<footer>
    <div class="container-fluid padding">
        <div class="row text-center col-12">
            <p>Furama &copy;2020. All rights reserved.</p>
        </div>
    </div>
</footer>
<script src="http://code.jquery.com/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</body>
</html>
