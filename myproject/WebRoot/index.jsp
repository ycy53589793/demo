<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="sitemesh"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>拼车系统</title>
    
    <!-- Le styles -->
    <link href="BootStrap/2.3.2/docs/assets/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 20px;
        padding-bottom: 60px;
      }

      /* Custom container */
      .container {
        margin: 0 auto;
        max-width: 1000px;
      }
      .container > hr {
        margin: 60px 0;
      }

      /* Main marketing message and sign up button */
      .jumbotron {
        margin: 80px 0;
        text-align: center;
      }
      .jumbotron h1 {
        font-size: 100px;
        line-height: 1;
      }
      .jumbotron .lead {
        font-size: 24px;
        line-height: 1.25;
      }
      .jumbotron .btn {
        font-size: 21px;
        padding: 14px 24px;
      }

      /* Supporting marketing content */
      .marketing {
        margin: 60px 0;
      }
      .marketing p + h4 {
        margin-top: 28px;
      }

      /* Customize the navbar links to be fill the entire space of the .navbar */
      .navbar .navbar-inner {
        padding: 0;
      }
      .navbar .nav {
        margin: 0;
        display: table;
        width: 100%;
      }
      .navbar .nav li {
        display: table-cell;
        width: 1%;
        float: none;
      }
      .navbar .nav li a {
        font-weight: bold;
        text-align: center;
        border-left: 1px solid rgba(255,255,255,.75);
        border-right: 1px solid rgba(0,0,0,.1);
      }
      .navbar .nav li:first-child a {
        border-left: 0;
        border-radius: 3px 0 0 3px;
      }
      .navbar .nav li:last-child a {
        border-right: 0;
        border-radius: 0 3px 3px 0;
      }
    </style>
    <link href="BootStrap/2.3.2/docs/assets/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="BootStrap/2.3.2/docs/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="BootStrap/2.3.2/docs/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="BootStrap/2.3.2/docs/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="BootStrap/2.3.2/docs/assets/ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="BootStrap/2.3.2/docs/assets/ico/favicon.png">

	<sitemesh:head/>
	
  </head>
  
  <body>
    <div class="container">

      <div class="masthead">
        <h3 class="muted">拼车demo</h3>
        <div class="navbar">
          <div class="navbar-inner">
            <div class="container">
              <ul class="nav">
                <li class="active"><a href="#">订单管理</a></li>
                <li><a href="#">角色管理</a></li>
                <li><a href="#">用户管理</a></li>
                <li><a href="#">统计管理</a></li>
                <li><a href="#">报表管理</a></li>
              </ul>
            </div>
          </div>
        </div><!-- /.navbar -->
      </div>

	  <sitemesh:body/>

      <hr>

      <div class="footer">
        <p>&copy; Company 2013</p>
      </div>

    </div> <!-- /container -->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="BootStrap/2.3.2/docs/assets/js/jquery.js"></script>
    <script src="BootStrap/2.3.2/docs/assets/js/bootstrap-transition.js"></script>
    <script src="BootStrap/2.3.2/docs/assets/js/bootstrap-alert.js"></script>
    <script src="BootStrap/2.3.2/docs/assets/js/bootstrap-modal.js"></script>
    <script src="BootStrap/2.3.2/docs/assets/js/bootstrap-dropdown.js"></script>
    <script src="BootStrap/2.3.2/docs/assets/js/bootstrap-scrollspy.js"></script>
    <script src="BootStrap/2.3.2/docs/assets/js/bootstrap-tab.js"></script>
    <script src="BootStrap/2.3.2/docs/assets/js/bootstrap-tooltip.js"></script>
    <script src="BootStrap/2.3.2/docs/assets/js/bootstrap-popover.js"></script>
    <script src="BootStrap/2.3.2/docs/assets/js/bootstrap-button.js"></script>
    <script src="BootStrap/2.3.2/docs/assets/js/bootstrap-collapse.js"></script>
    <script src="BootStrap/2.3.2/docs/assets/js/bootstrap-carousel.js"></script>
    <script src="BootStrap/2.3.2/docs/assets/js/bootstrap-typeahead.js"></script>
  </body>
</html>
