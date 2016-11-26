<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="login_page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  ${error}
    <form action="login.htm" method="post">
    	<div style="width:600px;height:100px;text-align:center;font-size:24px;margin:100px auto;padding:80px;line-height:25px;background:#D7E2F4">
    		<span>${error}</span><br>
    		<label for="username">用户名：</label>
    		<input type="text" name="username" id="username"><br>
    		<label for="password">密码：</label>
    		<input type="password" name="password" id="password"><br>
    		<div style="margin: 5px auto;position: relative;">
    		<label for="validateCode">验证码：</label>
    		<input type="text" id="validateCode" name="code" style="height:25px;">&nbsp;&nbsp;
    		<a href="" onclick="${ctx}/validateConde">
    		<img src="${pageContext.request.contextPath}/validateCode" style="position: absolute;top:5 px;"></a>
    		</div><br>
    		<input type="submit" value="登录">
    		<input type="reset" value="重置">
    	</div>
    </form>
  </body>
</html>
