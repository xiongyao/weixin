<?xml version="1.0" encoding="utf-8" ?>
<%@ page contentType="text/html; charset=utf-8" language="java"	import="java.sql.*" errorPage=""%>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<style>
	body{background-color: #e8e8e8;}
	.menu{position: absolute;height: 50px;bottom: 0px;width: 100%;}
	.menu div{bottom: 0px;border-top: 1px solid #E3E3E3;background-color: #F9F9F9;height: 50px;vertical-align: middle;font-family: 幼圆;font-size: 16px;line-height: 50px;cursor: pointer;}
	.menuDiv{width: 28%;float: left;position: absolute; border: 1px solid #efefef;background: #ffffff;text-align: center;filter:Shadow(Color="#cccccc", Direction="45");display: none;}
	.menuDiv .menuItem{height: 40px;line-height: 40px;border-top: 1px solid #efefef;margin: 3px;}
	#dtzx{bottom: 52px;left: 15%;}
	#tzgg{bottom: 52px;left: 43%;}
	#grzx{bottom: 52px;left: 71%;}
</style>
<script type="text/javascript">
<!--
function show(obj){
	if($("#"+obj).is(":visible")==false){
		$(".menuDiv[id!="+obj+"]").hide();
		$("#"+obj).show("fast");
	}else{
		$("#"+obj).hide("fast");
	}
}
//-->
</script>
<div align="center" class="menu">
 	<div style="width: 15%; float: left;"><img src="images/menu_home.png" style="width: 25px;height: 25px;vertical-align: middle;"/></div>
 	<div style="width: 28%;border-left: 1px solid #E3E3E3; float: left;" onclick="show('dtzx')"><img src="images/menu_item.png" style="width: 16px;height: 16px;vertical-align: middle;"/>答题中心</div>
 	<div style="width: 28%;border-left: 1px solid #E3E3E3; float: left;" onclick="show('tzgg')"><img src="images/menu_item.png" style="width: 16px;height: 16px;vertical-align: middle;"/>通知公告</div>
 	<div style="width: 28%;border-left: 1px solid #E3E3E3; float: left;" onclick="show('grzx')"><img src="images/menu_item.png" style="width: 16px;height: 16px;vertical-align: middle;"/>个人中心</div>
</div>
<div id="dtzx" class="menuDiv" >
	<div class="menuItem" style="border-top: 0px;">立即答题</div>
	<div class="menuItem">立即体现</div>
	<div class="menuItem">常见问题</div>
	<div class="menuItem">联系我们</div>
	<div class="menuItem">学校中心</div>
</div>
<div id="tzgg" class="menuDiv" >
	<div class="menuItem" style="border-top: 0px;">实时公告</div>
</div>
<div id="grzx" class="menuDiv" >
	<div class="menuItem" style="border-top: 0px;">我的钱包</div>
	<div class="menuItem">个人资料</div>
	<div class="menuItem">我的关注</div>
	<div class="menuItem">我的收藏</div>
	<div class="menuItem">答题历史</div>
</div>
