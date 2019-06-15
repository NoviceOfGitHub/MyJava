<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=TF-8">
<title>页面</title>
<link rel="stylesheet" type="text/css" href="../static/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../static/easyui/themes/icon.css" />
<style>
.textbox{
height:20px;
margin:0;
padding:0 2px;
box-sizing:content-box;
}
	#fm{
			margin:0;
			padding:10px 30px;
		}
		.ftitle{
			font-size:14px;
			font-weight:bold;
			color:#666;
			padding:5px 0;
			margin-bottom:10px;
			border-bottom:1px solid #ccc;
		}
		.fitem{
			margin-bottom:5px;
		}
		.fitem label{
			display:inline-block;
			width:80px;
		}
</style>
</head>
<body >
<p>您好，<?php echo $_SESSION['admin']?> </p>
<table id="box">
</table>
<div id="tb" style="padding:5px;">
   <div style="margin-bottom:5px;">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="obj.add();">添加</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="obj.edit();">修改</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="obj.remove();">删除</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" style="display:none;" id="save" onclick="obj.save();">保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" style="display:none;" id="redo" onclick="obj.redo();">取消编辑</a>	
   </div>
   <!--查询--->
   <div style="padding:0 0 0 5px;color:#333;">
    姓名：<input type="text" class="textbox" name="realname" style="width:65px">
	创建时间从: <input type="text" name="date_from" class="easyui-datetimebox"  style="width:145px">
	到:<input type="text" name="date_to" class="easyui-datetimebox"  style="width:145px">
	<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="obj.search();">查询</a>
   </div>

</div>

<div id="menu" class="easyui-menu" style="width:120px;display:none;">
<div onclick="obj.newUser();" iconCls="icon-add">增加</div>
<div onclick="obj.editUser();" iconCls="icon-edit">修改</div>
<div onclick="obj.remove();" iconCls="icon-remove">删除</div>
</div>
<!--弹框增加修改-->
<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
			closed="true" buttons="#dlg-buttons">
		<div class="ftitle">User Information</div>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label>用户名:</label>
				<input name="username" class="easyui-validatebox" required="true">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">Save</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
	</div>
<script type="text/javascript" src="../static/easyui/jquery.min.js"></script>
<script type="text/javascript" src="../static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../static/easyui/locale/easyui-lang-zh_CN.js" ></script>
<script type="text/javascript" src="../static/js/admin.js" ></script>
</body>
</html>