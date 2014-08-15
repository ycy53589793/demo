<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>错误信息</title>
    
    <jsp:include page="jscss.jsp"/>
    
	<style type="text/css">
		input {
			font-size: 12px
		}
		td {
			font-size: 12px
		}
		.p2 {
			font-size: 12px
		}
		.p6 {
			font-size: 12px; color: #1b6ad8
		}
		a {
			color: #1b6ad8; text-decoration: none
		}
		a:hover {
			color: red
		}
	</style>

  </head>
  
  <body oncontextmenu="return false" onselectstart="return false">
	<p align=center>　</p>
	<p align=center>　</p>
	<table cellspacing=0 cellpadding=0 width=540 align=center border=0>
	  <tbody>
		  <tr>
		    <td valign=top height=270>
		      <div align=center><br><img height=211 src="common/img/error.gif" width=329><br><br>
			      <table cellspacing=0 cellpadding=0 width="80%" border=0>
			        <tbody>
			        <tr>
			          <td><font class=p2>&nbsp;&nbsp;&nbsp; <font color=#ff0000><img height=13 src="common/img/emessage.gif" width=12>&nbsp;无法访问本页的原因是：</font></font></td></tr>
			        <tr>
			          <td height=8></td>
			        <tr>
			          <td><p><font color=#000000><br>　　您所请求的页面不存在</font>!</p></td>
			        </tr>
			        </tbody>
			      </table>
		      </div>
		    </td>
		  </tr>
		  <tr><td height=5></td></tr>
		  <tr>
		    <td align=middle>
		      <center>
			      <table cellspacing=0 cellpadding=0 width=480 border=0>
			        <tbody>
			        <tr>
			          <td width=6><img height=26 src="common/img/left.gif" width=7></td>
			          <td background="common/img/bg.gif">
			            <div align=center>
			            	<font class=p6>
			            		<a href="#">返回首页</a>　 　|　　 <a href="javascript:history.go(-1)">返回出错页</a>　 　|　　 <a href="#">关闭本页</a>
			            	</font>
			            </div>
			          </td>
			          <td width=7><img src="common/img/right.gif"></td>
			        </tr>
			        </tbody>
			      </table>
		      </center>
		    </td>
		  </tr>
	  </tbody>
	</table>
	<p align=center>　</p>
	<p align=center>　</p>
  </body>
</html>
