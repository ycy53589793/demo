<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单管理</title>
    
	<!-- Le styles -->
    <style type="text/css">
      body {
        padding-top: 20px;
        padding-bottom: 40px;
      }

      /* Custom container */
      .container-narrow {
        margin: 0 auto;
        max-width: 1000px;
      }
      .container-narrow > hr {
        margin: 30px 0;
      }

      /* Main marketing message and sign up button */
      .jumbotron {
        margin: 60px 0;
        text-align: center;
      }
      .jumbotron h1 {
        font-size: 72px;
        line-height: 1;
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
      .search input {
      	width: 122px;
      	margin-right: 20px;
      }
    </style>
    
    <script type="text/javascript">
    	$(document).ready(
    		function () {
    			$('#orderListTable').datagrid({
			        //url						: '${ctx}/receiptGroup/getReceiptGroupInfoData' ,
			        //queryParams		: $("#queryForm").serializeJson(),
	    			width					: '100%', 
	    			height					: 'auto',
	    			pagination		 	: true,/*是否显示下面的分页菜单*/
	    			pageNumber 		: 1,
	    	        pageList				: [ 10,20,30 ],
	    			rownumbers		: true,
			        columns:[[
					{ field:'ck',checkbox:true },          
			        {field:'listId'							,title:'ID'					,width:100},
			        {field:'listName'						,title:'收件组'					,width:120}
			        /*
			        {field:'operate'		,title:'操作'						,width:150, align:'right',
	                    formatter:function(value,rec,index) {
	                        var operateLink = String.format('<a href="${ctx}/addressManage">查看详情</a> | <a href="javascript:void(0)" onclick="sendHistory({0})">发送历史</a>',rec.listId);
	                    	return operateLink;
	                    }  
	                }
	                */
			        ]],
			        toolbar:[{  
	                    text:'新增',iconCls:'icon-add',handler:function(){  
	                    	//showMergeReceiptGroupPanel();
	                    }  
	                },  
	                {text:'删除',iconCls:'icon-remove',handler:function(){  
	                    	//deleteImportAddressInfo();
	                    }  
	                },
	                {text:'保存',iconCls:'icon-edit',handler:function() {
	                		//location.href = "${ctx}/addressManage";
	                    }
	                }
	                ],  
			    });
    		}
    	);
    </script>

  </head>
  
  <body>
    <div class="container-narrow">

	  <div class="masthead">
		  <ul class="nav nav-pills pull-right">
		    <li class="active"><a href="#">查询</a></li>
		    <li><a href="#">重置</a></li>
		  </ul>
		  <h3 class="muted">查询条件</h3>
	  </div>

      <hr>
      
      <div class="jumbotron">
      	<table class="search">
      		<tr>
      			<td>订单号</td><td>乘客手机号</td><td>起始地</td><td>目的地</td><td>状态</td><td>是否包车</td><td>是否预约</td>
      		</tr>
      		<tr>
      			<td><input type="text"/></td><td><input type="text"/></td><td><input type="text"/></td>
      			<td><input type="text"/></td><td><input type="text"/></td>
      			<td style="width: 120px;">
      				<input type="radio" name="a" style="width: 20px;margin-right: 0px;"/>是
      				<input type="radio" name="a" style="width: 20px;margin-right: 0px;" checked="checked"/>否
      			</td>
      			<td style="width: 120px;">
      				<input type="radio" name="b" style="width: 20px;height: 10px;margin-right: 0px;"/>是
      				<input type="radio" name="b" style="width: 20px;height: 10px;margin-right: 0px;" checked="checked"/>否
      			</td>
      		</tr>
      	</table>
      </div>

      <hr>

      <div class="row-fluid marketing">
        <div class="span6">
          <table id="orderListTable"></table>
        </div>

        <div class="span6">
			<div class="easyui-tabs" style="width:100%;height:100%">
				<div title="About" style="padding:10px">
					<p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
					<ul>
						<li>easyui is a collection of user-interface plugin based on jQuery.</li>
						<li>easyui provides essential functionality for building modem, interactive, javascript applications.</li>
						<li>using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.</li>
						<li>complete framework for HTML5 web page.</li>
						<li>easyui save your time and scales while developing your products.</li>
						<li>easyui is very easy but powerful.</li>
					</ul>
				</div>
				<div title="My Documents" style="padding:10px">
					<ul class="easyui-tree" data-options="url:'tree_data1.json',method:'get',animate:true"></ul>
				</div>
				<div title="Help" data-options="iconCls:'icon-help',closable:true" style="padding:10px">
					This is the help content.
				</div>
			</div>
        </div>
      </div>

    </div> <!-- /container -->
    
  </body>
</html>
