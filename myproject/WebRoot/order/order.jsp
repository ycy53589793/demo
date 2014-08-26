<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<c:url var="getOrders" value="/order/action/orderAction_getOrders.action"/>
<c:url var="getOrderByCondition" value="/order/action/orderAction_getOrderByCondition.action"/>

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
      .search td {
      	width: 230px;
      }
    </style>
    
    <script type="text/javascript">
    	$(document).ready(
    		function () {
	    		/** 百度地图API功能 **/
			    var map = new BMap.Map("map");            // 创建Map实例
			    var point = new BMap.Point(116.404, 39.915); // 创建点坐标
			    map.centerAndZoom(point,15);                 // 初始化地图,设置中心点坐标和地图级别。
			    map.enableScrollWheelZoom();                 //启用滚轮放大缩小
			    
    			/** 初始化列表**/
    			$("#orderListTable").datagrid({
			        url						: '${getOrders}' ,
	    			width					: '100%', 
	    			height					: '480px',
	    			pagination		 	: true,/*是否显示下面的分页菜单*/
	    			pageNumber 		: 1,
	    	        pageList				: [ 10,20,30 ],
	    			rownumbers		: true,
			        columns:[[
					{field:'ck',checkbox:true },          
			        {field:'id'							,title:'订单号'					,width:50},
			        {field:'startPlace'							,title:'乘车地点'					,width:100},
			        {field:'endPlace'							,title:'目的地'					,width:100},
			        {field:'personNumber'							,title:'人数'					,width:30},
			        {field:'isWholeCar'							,title:'是否包车'					,width:60},
			        {field:'haveChild'							,title:'是否带小孩'					,width:70},
			        {field:'passengerPhone'						,title:'乘客手机号'					,width:120},
			        {field:'expiryDate'						,title:'失效时间'					,width:120},
			        {field:'timeExpand'						,title:'延长时间'					,width:120},
			        {field:'isPreOrder'						,title:'是否预约'					,width:60},
			        {field:'preTime'						,title:'预约时间'					,width:120},
			        {field:'remark'						,title:'备注'					,width:120}
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
	                    	newOrder();
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
			    $("#orderListTable").datagrid('getPager').pagination({
				    displayMsg:'共有 {total}条记录',
				    showPageList:true,
				    beforePageText:'当前第',
				    afterPageText:'页，本页共 {pages}条记录',
				    onSelectPage:function(pageNumber, pageSize){
				        $(this).pagination('loading');
				        alert('pageNumber:'+pageNumber+',pageSize:'+pageSize);
				        $(this).pagination('loaded');
				    }
				});
    		}
    	);
    	//查询
    	function orderQuery() {
    		$('#orderListTable').datagrid({
    			url				: '${getOrderByCondition}' ,
    			queryParams		: $("#orderQueryForm").serializeJson()
    		});
    	}
    	//重置
    	function orderReset() {
    		$("#orderQueryForm")[0].reset();
    	}
    </script>

  </head>
  
  <body>
    <div class="container-narrow">

	  <div class="masthead">
		  <ul class="nav nav-pills pull-right">
		    <li class="active"><a href="javascript:void(0)" onclick="orderQuery()">查询</a></li>
		    <li><a href="javascript:void(0)" onclick="orderReset()">重置</a></li>
		  </ul>
		  <h3 class="muted">查询条件</h3>
	  </div>

      <hr>
      
      <div class="jumbotron">
      	<form id="orderQueryForm" method="post">
	      	<table class="search">
	      		<tr>
	      			<td>订单号</td><td>乘客手机号</td><td>起始地</td><td>目的地</td><td>状态</td><td>是否包车</td><td>是否预约</td>
	      		</tr>
	      		<tr>
	      			<td><input class="easyui-textbox" type="text" name="orderQuery.id"/></td>
	      			<td><input class="easyui-textbox" type="text" name="orderQuery.passengerPhone"/></td>
	      			<td><input class="easyui-textbox" type="text" name="orderQuery.startPlace"/></td>
	      			<td><input class="easyui-textbox" type="text" name="orderQuery.endPlace"/></td>
	      			<td><input class="easyui-textbox" type="text" name="orderQuery.status"/></td>
	      			<td>
	      				<select class="easyui-combobox" name="orderQuery.isWholeCar" style="width:120px;">
	      					<option value="Y">是</option>
							<option value="N">否</option>
	      				</select>
	      			</td>
	      			<td>
	      				<select class="easyui-combobox" name="orderQuery.isPreOrder" style="width:120px;">
	      					<option value="Y">是</option>
							<option value="N">否</option>
	      				</select>
	      			</td>
	      		</tr>
	      		<tr style="height: 10px"></tr>
	      		<tr>
	      			<td>是否带小孩</td><td>预约时间从</td><td>预约时间到</td><td>失效时间从</td><td>失效时间到</td><td>下单时间从</td><td>下单时间到</td>
	      		</tr>
	      		<tr>
	      			<td>
	      				<select class="easyui-combobox" name="orderQuery.haveChild" style="width:120px;">
	      					<option value="Y">是</option>
							<option value="N">否</option>
	      				</select>
	      			</td>
	      			<td><input class="easyui-datetimebox" name="orderQuery.preTimeFm" style="width:120px"/></td>
	      			<td><input class="easyui-datetimebox" name="orderQuery.preTimeTo" style="width:120px"/></td>
	      			<td><input class="easyui-datetimebox" name="orderQuery.expiryDateFm" style="width:120px"/></td>
	      			<td><input class="easyui-datetimebox" name="orderQuery.expiryDateTo" style="width:120px"/></td>
	      			<td><input class="easyui-datetimebox" name="orderQuery.createTimeFm" style="width:120px"/></td>
	      			<td><input class="easyui-datetimebox" name="orderQuery.createTimeTo" style="width:120px"/></td>
	      		</tr>
	      		<tr style="height: 10px"></tr>
	      		<tr>
	      			<td>备注</td>
	      		</tr>
	      		<tr>
	      			<td><input class="easyui-textbox" name="orderQuery.remark" data-options="multiline:true" style="height:60px;width:120px"/></td>
	      		</tr>
	      	</table>
      	</form>
      </div>

      <hr>

      <div class="row-fluid marketing">
        <div class="span6">
          <table id="orderListTable"></table>
        </div>

        <div id="map" class="span6" style="width: 480px;height: 480px;"></div>
      </div>

    </div> <!-- /container -->
    
    <%@ include file="order-dialog.jspf"%>
  </body>
</html>
