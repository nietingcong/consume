<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'regist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	/* input{
		width:150px;
	} */
</style>
  </head>
  
  <body>
  <form action="user/regist.htm" method="post">
    <table style="width:300px;height:300px;margin: 100px auto;padding:10px 15px;background: #96C5EF;">
    	<tr>
    		<td width="30%">
    			<label for="username">用户名:</label></td><td>
    			<input id="username" name="name" type="text" style="width:150px;height:29px;">
    		</td>
    	</tr>
    	<tr>
    		<td>
    			<label for="loginName">登录账号:</label></td><td>
    			<input id="loginName" name="loginName" type="text" style="width:150px;height:29px;">
    		</td>
    	</tr>
    	<tr>
    		<td>
    			<label for="password">登录密码:</label></td><td>
    			<input id="password" name="passWord" type="password" style="width:150px;height:29px;">
    		</td>
    	</tr>
    	<tr>
    		<td colspan="2" align="center">
    			<input type="submit" value="提交">
    			<input type="reset" value="重置">
    		</td>
    	</tr>
    </table>
  </form>
  </body>
</html>
