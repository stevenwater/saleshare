<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="ctl.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${path}/ui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${path}/ui/themes/icon.css">
<script type="text/javascript" src="${path}/ui/jquery.min.js"></script>
<script type="text/javascript" src="${path}/ui/jquery.easyui.min.js"></script>
<style type="text/css">
body {
	font-family: verdana, helvetica, arial, sans-serif;
	padding: 20px;
	font-size: 12px;
	margin: 0;
}

div {
	padding: 0;
	margin: 0;
}
</style>
<script type="text/javascript">
		var menu = [
		       {text:'baidu', url:'http://www.baidu.com'},
		       {text:'demo', url:'/saleshare/demo/show'},
		       {text:'csdn', url:'http://www.csdn.net'},
		       {text:'iteye', url:'http://www.iteye.com'},
		       {text:'SWD2', subMenu:[{text:'jenkins', url:'http://10.92.35.99:8080/jenkins/'},
		               		       {text:'warehouse', url:'http://apex.tcl-ta.com:7777/pls/apps/f?p=209:1'},
		            		       {text:'gerrit', url:'http://10.92.32.10:8081/#/dashboard/self'}]},
		       {text:'Exit'}
		 ];
		
		//初始化左侧菜单栏
		function init_menu(menus, isSubMenu){
			menu_html = "";
			if(!isSubMenu){
				menu_html += "<div class=\"easyui-panel\" style=\"overflow: hidden;height:100%\;border:0\">"
				menu_html += "<div id=\"main-menu\" class=\"easyui-menu\" data-options=\"inline:true\" style=\"width:100%\">";
			}
			$.each(menus,function(i,menu){
				if(menu.subMenu && menu.subMenu.length >0){
					menu_html += "<div>";
							menu_html +="<span>"+menu.text+"</span>";
							menu_html += "<div>";
				  				menu_html += init_menu(menu.subMenu,true);  
				  			menu_html +="</div>";
				  	menu_html +="</div>";
				}else{
					menu_html += "<div onclick=\"javascript:openTab('"+menu.text+"','"+menu.url+"')\">" + menu.text + "</div>";
				}
			});
			
			if (!isSubMenu) {
				menu_html += "</div>";
				menu_html += "</div>";
			}
			return menu_html;
		}
		
		function openTab(title, url){
			if(!$("#tabs").tabs("exists",title)){
				$("#tabs").tabs("add",{
					title:title,
					content:createFrame(url),
					closable:true
				});
			}else{
				$("#tabs").tabs("select",title);
			} 
		}
		
		function createFrame(url){
			var s = '<iframe name="mainFrame" scrolling="auto" frameborder="0" src="'+url+'" style="width:100%;height:100%;"></iframe>';
			return s;
		}

		$(function() {
			//初始化菜单
			$("#main_menu").append(init_menu(menu,false));
			$.parser.parse($("#main_menu").parent());
		});
	</script>
<title>test</title>
</head>
<body class="easyui-layout" style="overflow: hidden;">
	<div data-options="region:'north',border:false" style="height: 30px; padding: 0px">north region</div>
	<div id="main_menu" data-options="region:'west',split:true,title:'菜单'" style="width:150px"></div>
	<div data-options="region:'center'" style="padding: 0px; margin: 0px">
		<div id="tabs" class="easyui-tabs" fit="true" border="false">
			<div title="欢迎使用" style="padding: 20px; overflow: hidden;" id="home">
			</div>
		</div>
	</div>
	<div data-options="region:'south',split:true,border:false"
		style="height: 30px; padding: 0px">south</div>
</body>

</html>
