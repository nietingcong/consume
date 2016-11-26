<!DOCTYPE html>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
  <head>
    <jsp:include page="/head.jsp"/>
    <title>My JSP 'index.jsp' starting page</title>
    
  </head>
  
  <body>
    <header class="navbar">
        <div class="container-fluid expanded-panel">
      <div class="row">
        <div id="logo" class="col-xs-12 col-sm-2">
          <a href="#">DevOOPS v2</a>
        </div>
        <div id="top-panel" class="col-xs-12 col-sm-10">
          <div class="row">
            <div class="col-xs-12 col-sm-12 top-panel-right">
              <ul class="nav navbar-nav pull-right panel-menu">
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle account" data-toggle="dropdown">
                    <div class="avatar">
                      <img src="${ctx}/res/img/img001.jpg" class="img-circle" alt="avatar" />
                    </div>
                    <i class="fa fa-angle-down pull-right"></i>
                    <div class="user-mini pull-right">
                      <span class="welcome">Welcome,</span>
                      <span>${user.name}</span>
                    </div>
                  </a>
                  <ul class="dropdown-menu">
                    <li>
                      <a href="${ctx}/logout.htm">
                        <i class="fa fa-user"></i>
                        <span>退出登录</span>
                      </a>
                    </li>
                  </ul>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </header>
  <div id="main" class="container-fluid" style="height:894px;">
  	<div class="row">
  		<div id="sidebar-left" class="col-sm-2 col-md-2">
  			<ul class="nav main-menu">
  				<li class="dropdown">
  					<a href="home/welcome.jsp" class="active ajax-link">
  						<i class="fa fa-home"></i>
  						<span>首页</span>
  					</a>
  				</li>
  				<li class="dropdown">
  					<a href="#" class="dropdown-toggle">
  						<i class="fa fa-line-chart"></i>
  						<span>系统设置</span>
  					</a>
  					<ul class="dropdown-menu">
  						<li class="dropdown">
  							<a href="${ctx}/menu/listAll.htm" class="ajax-link">
  								<span>菜单设置</span>
  							</a>
  						</li>
  						<li class="dropdown">
  							<a href="home/welcome.jsp" class="ajax-link">
  								<span>用户权限设置</span>
  							</a>
  						</li>
  					</ul>
  				</li>
  				<c:forEach items="${menus}" var="menu_1">
  					<li class="dropdown">
  						<c:if test="${empty menu_1.childMenus}">
  							<a href="${menu_1.url}" class="ajax-link">
  								<span>${menu_1.name}</span>
  							</a>
  						</c:if>
  						<c:if test="${!empty menu_1.childMenus}">
	  						<a href="#" class="dropdown-toggle">
	  							<span>${menu_1.name}</span>
	  						</a>
	  						<ul class="dropdown-menu">
	  							<c:forEach items="${menu_1.childMenus}" var="menu_2">
	  								<li>
	  									<a href="${menu_2.url}" class="ajax-link">
	  										<span>${menu_2.name}</span>
	  									</a>
	  								</li>
	  							</c:forEach>
	  						</ul>
  						</c:if>
  					</li>
  				</c:forEach>
  			</ul>
  		</div>
  		<div id="content" class="col-sm-10 col-md-10">
  			<div id="ajax-content">
  			
  			</div>
  		</div>
  	</div>
  </div>
  </body>
  <jsp:include page="/foot.jsp"/>
</html>
