<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<c:url var="addRole" value="/role/action/roleAction_addRole.action"/>
<c:url var="getRoles" value="/role/action/roleAction_getRoles.action"/>
<c:url var="updateRole" value="/role/action/roleAction_updateRole.action"/>
<c:url var="deleteRole" value="/role/action/roleAction_deleteRole.action"/>
<c:url var="getRoleByCondition" value="/role/action/roleAction_getRoleByCondition.action"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>角色管理</title>
    
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
      
	  form{
		margin:0;
		padding:0;
	  }
	  .dv-table td{
	  	border:0;
	  }
	  .dv-table input{
	  	border:1px solid #ccc;
	  }
    </style>

	<script type="text/javascript">
		$(function(){
			$('#roleListTable').datagrid({
				url	: '${getRoles}'
			});
			$('#roleListTable').datagrid({
				view: detailview,
				detailFormatter: function(index,row) {
					return '<div class="ddv"></div>';
				},
				onExpandRow: function(index,row) {
					var ddv = $(this).datagrid('getRowDetail',index).find('div.ddv');
					ddv.panel({
						border:false,
						cache:true,
						content:"<form method='post'>"+
									"<table class='dv-table' style='width:100%;background:#fafafa;padding:5px;margin-top:5px;'>"+
										"<tr>"+
											"<td><input name='role.id' type='hidden' value='"+row.id+"'/></td>"+
											"<td>角色名</td>"+
											"<td><input name='role.roleName' class='easyui-textbox' required='true' value='"+row.roleName+"'/></td>"+
											"<td>状态</td>"+
											"<td><input name='role.status' class='easyui-textbox' required='true' value='"+row.status+"'/></td>"+
										"</tr>"+
									"</table>"+
									"<div style='padding:5px 0;text-align:right;padding-right:30px'>"+
										"<a href='javascript:void(0)' class='easyui-linkbutton' iconCls='icon-save' plain='true' onclick='saveItem("+index+")'>Save</a>"+
										"<a href='javascript:void(0)' class='easyui-linkbutton' iconCls='icon-cancel' plain='true' onclick='cancelItem("+index+")'>Cancel</a>"+
									"</div>"+
								"</form>",
						onLoad:function() {
							$('#roleListTable').datagrid('fixDetailRowHeight',index);
							$('#roleListTable').datagrid('selectRow',index);
							$('#roleListTable').datagrid('getRowDetail',index).find('form').form('load',row);
						}
					});
					$('#roleListTable').datagrid('fixDetailRowHeight',index);
				}
			});
			$('#roleListTable').datagrid('getPager').pagination({
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
		});
		function saveItem(index) {
			var row = $('#roleListTable').datagrid('getRows')[index];
			var path = '${addRole}';
			if(typeof(row.id) != "undefined" && row.id != null) {
				path = '${updateRole}';
			}
			$('#roleListTable').datagrid('getRowDetail',index).find('form').form('submit',{
				url: '${addRole}',
				onSubmit: function() {
					return $(this).form('validate');
				},
				success: function(data) {
					data = eval('('+data+')');
					data.isNewRecord = false;
					$('#roleListTable').datagrid('collapseRow',index);
					$('#roleListTable').datagrid('updateRow',{
						index: index,
						row: data
					});
				}
			});
		}
		function cancelItem(index) {
			var row = $('#roleListTable').datagrid('getRows')[index];
			if (row.isNewRecord){
				$('#roleListTable').datagrid('deleteRow',index);
			} else {
				$('#roleListTable').datagrid('collapseRow',index);
			}
		}
		function destroyItem() {
			var row = $('#roleListTable').datagrid('getSelected');
			if (row){
				$.messager.confirm('Confirm','确定要删除这条数据?',function(r){
					if (r){
						var index = $('#roleListTable').datagrid('getRowIndex',row);
						$.post('${deleteRole}',{'role.id':row.id},function(){
							$('#roleListTable').datagrid('deleteRow',index);
						});
					}
				});
			}
		}
		function newItem() {
			$('#roleListTable').datagrid('appendRow',{isNewRecord:true});
			var index = $('#roleListTable').datagrid('getRows').length - 1;
			$('#roleListTable').datagrid('expandRow', index);
			$('#roleListTable').datagrid('selectRow', index);
		}
		function roleQuery() {
			$('#roleListTable').datagrid({
				url	: '${getRoleByCondition}',
				queryParams		: $("#roleQueryForm").serializeJson()
			});
		}
		function roleReset() {
			$("#roleQueryForm")[0].reset();
		}
	</script>
  </head>
  
  <body>
    <div class="container-narrow">

      <div class="masthead">
        <ul class="nav nav-pills pull-right">
          <li class="active"><a href="javascript:void(0)" onclick="roleQuery()">查询</a></li>
          <li><a href="javascript:void(0)" onclick="roleReset()">重置</a></li>
        </ul>
        <h3 class="muted">查询条件</h3>
      </div>

      <hr>

      <div class="jumbotron">
        <form id="roleQueryForm" method="post">
        	<table class="search">
	      		<tr>
	      			<td>编号</td><td>角色名</td><td>状态</td>
	      		</tr>
	      		<tr>
	      			<td><input class="easyui-textbox" type="text" name="roleQuery.id"/></td>
	      			<td><input class="easyui-textbox" type="text" name="roleQuery.roleName"/></td>
	      			<td><input class="easyui-textbox" type="text" name="roleQuery.status"/></td>
	      		</tr>
	      	</table>
        </form>
      </div>

      <hr>

      <div class="row-fluid marketing">
        <table id="roleListTable" title="角色列表" style="width:100%;height:500px" toolbar="#toolbar" pagination="true" fitColumns="true" singleSelect="true">
			<thead>
				<tr>
					<th field="id" width="50">编号</th>
					<th field="roleName" width="50">角色名</th>
					<th field="status" width="50">状态</th>
				</tr>
			</thead>
		</table>
		<div id="toolbar">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newItem()">新增</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyItem()">删除</a>
		</div>
      </div>

      <hr>

    </div> <!-- /container -->

  </body>
</html>
