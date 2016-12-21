<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../ctl.jsp"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${path}/ui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${path}/ui/themes/icon.css">
<script type="text/javascript" src="${path}/ui/jquery.min.js"></script>
<script type="text/javascript" src="${path}/ui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${path}/ui/easyloader.js"></script>
<title><fmt:message key="sys.user.management.title" /></title>
</head>
<body>
	<table id="dg"/>
	<script type="text/javascript">
		function addRow(){

		}
		
		function deleteRows(){
			var rows = $('#dg').datagrid('getSelections');
			if(rows.length == 0){
				$.messager.alert('提示','未选中任何记录');
				return;
			}
			$.messager.confirm("确认","是否删除所选记录？",function(yes){
				if (yes){
					var ids= new Array();
					for(j = rows.length-1; j >= 0; j--){
						ids.push(rows[j].id);
					}
					$.ajax({
						url:'${path}/user/delete',
						data:{'ids':ids},
						method:'post',
						traditional:true,
						success:function(data,textStatus){
							if(data.code == 1){
								$('#dg').datagrid('reload');
							}else {
								$.messager.alert("提示","error");
							}
						}
					});
				}
			});
		}
		
		function editRow(index){
			
		}
		
		function query(){
			var params = {};
			var pager = $('#dg').datagrid('get')
			$.ajax({
				url:'${path}/user/list',
				data:params,
				method:'post',
				traditional:true,
				success:function(data,textStatus){
					if(data.code == 1){
						$('#dg').datagrid('reload',data);
					}else {
						$.messager.alert("提示","error");
					}
				}
			});
		}

		$(function() {
			$('#dg').datagrid({
								title : '<fmt:message key="sys.user.management.title"/>',
								collapsible : true,
								singleSelect : false,
								width : 700,
								height : 'auto',
								fitColumns : true,
								pagination : true,
								url : 'list',
								remoteSort:false,
								multiSort:true,
								toolbar : [ {
									id : 'add',
									iconCls : 'icon-add',
									text : 'add',
									handler : addRow
								}, {
									id : 'remove',
									iconCls : 'icon-remove',
									text : 'remove',
									handler : deleteRows
								}, {
									id : 'edit',
									iconCls : 'icon-edit',
									text : 'edit',
									handler : editRow
								} ],
								columns : [ [
										{
											field : 'isCheck',
											checkbox:true,
											width : 100
										},
										{
											field : 'id',
											title : 'Item ID',
											width : 100
										},
										{
											field : 'userName',
											title : '<fmt:message key="sys.user.management.username"/>',
											editor : 'textbox',
											sortable:true,
											width : 200
										},
										{
											field : 'password',
											title : '<fmt:message key="sys.user.management.password"/>',
											editor : 'textbox',
											width : 200
										},
										{
											field : 'userStatus',
											title : '<fmt:message key="sys.user.management.userstatus"/>',
											editor : 'textbox',
											sortable:true,
											width : 200
										} ] ]
							});
			var pager = $('#dg').datagrid().datagrid('getPager'); // get the pager of datagrid
			pager.pagination({
				pageSize : 10,
				pageList : [ 10, 20, 30 ],
			});
		})
	</script>
</body>

</html>