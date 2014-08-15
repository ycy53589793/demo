<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<base href="<%=basePath%>">

    <title>登陆</title>

    <!-- Le styles -->
    <link href="BootStrap/2.3.2/docs/assets/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }
      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
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
  </head>

  <body>

    <div class="container">

      <form class="form-signin" action="loginAction_checkUser.action" method="post">
        <h2 class="form-signin-heading">请登陆</h2>
        <input type="text" name="username" class="input-block-level" placeholder="Email address">
        <input type="password" name="password" class="input-block-level" placeholder="Password">
        <label class="checkbox">
          <input type="checkbox" value="remember-me">记住密码
        </label>
        <button class="btn btn-large btn-primary" type="submit">登陆</button>
      </form>

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