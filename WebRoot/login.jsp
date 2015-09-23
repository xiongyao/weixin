<?xml version="1.0" encoding="utf-8" ?>
<%@ page contentType="text/html; charset=utf-8" language="java"	import="java.sql.*" errorPage=""%>
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>答题</title>
    <script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.1.0.js" ></script>
    <style>
    	*{font-size: 16px; margin: 0xp;padding: 0px;}
    	#loginTb{font-family: 黑体;width: 92%;margin-top: 15%;}
    	#loginTb td{border-bottom: 1px solid #dddddd;height: 50px;vertical-align: middle;}
    	#loginTb td input{width: 95%;border: 0px;font-family: 黑体;height: 40px;line-height: 40px;padding-left: 10px;}
    	#bot_link{margin-top: 20%;}
    	#bot_link span{font-family: 微软雅黑;color: #aaaaaa;font-size: 16px;padding: 5px 15px;}
    </style>
    <script src="js/demo.js"> </script> 
  </head>
  
  <body STYLE="overflow: hidden;margin: 0px;padding: 0px;">
  	<div align="center" style="height: 100%; min-height: 100%;">
	  	<div>
			  	<div style="margin-top: 4%;font-weight: bold;">
					<span style="font-size: 28px;font-family: 黑体;">使用手机号登录</span>
				</div>
		  		<table id="loginTb"  cellspacing="0" cellpadding="0" >
		  			<tr>
		  				<td style="width: 80px;">国家/地区</td>
		  				<td style="padding-left: 10px;">
		  					<select style="width: 100%;border: 0px solid #ffffff;font-family: 黑体;height: 40px;">
		  						<option>中国</option>
		  						<option>美国</option>
		  						<option>英国</option>
		  						<option>法国</option>
		  						<option>俄罗斯 </option>
		  					</select>
		  				</td>
		  			</tr>
		  			<tr>
		  				<td>+86</td>
		  				<td style="border-left: 1px solid #dddddd;padding-left: 10px;">
		  					<input type="text" value="请填写手机号码" />
		  				</td>
		  			</tr>
		  			<tr>
		  				<td>密码</td>
		  				<td style="padding-left: 10px;">
		  					<input type="text" value="<%=request.getContextPath() %>请填写密码" />
		  				</td>
		  			</tr>
		  		</table>
		  		<div style="background: url(images/button_login.png) center  no-repeat; height: 43px;margin: 10% auto 25% auto;width:94%;color:#eeeeee;font-family: 黑体;font-size: 20px;line-height: 43px;cursor: pointer;">登 录</div>
		  		<div id="bot_link">
		  			<span style="cursor: pointer;">忘记密码？</span>
		  			<span style="color: #888888;">|  </span>
		  			<span style="cursor: pointer;">注册</span>
		  		</div>
			 </div>
	 </div>
	 <%@ include file="menu.jsp"  %>
  </body>
</html>
