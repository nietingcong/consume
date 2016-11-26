<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div id="breadcrumb" class="col-xs-12">
		<a href="#" class="show-sidebar">
			<i class="fa fa-bars"></i>
		</a>
		<ol class="breadcrumb pull-left">
			<li><a href="#">系统设置</a></li>
			<li><a href="#">菜单设置</a></li>
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-xs-12">
		<form id="mainForm"  class="form-inline" method="post">
				<div class="form-group">
					<label for="name" class="col-sm-4 control-label">菜单名</label>
					<div class="col-sm-8">
						<input type="text" id="name" name="name" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<label for="url" class="col-sm-4 control-label">打开链接</label>
					<div class="col-sm-8">
						<input type="text" id="url" name="url" class="form-control">
					</div>
				</div>
				<button type="button" class="btn btn-primary btn-xs">查询</button>
			</form>
			<div>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>序号</th>
							<th>菜单名</th>
							<th>打开链接</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${menus}" var="menu" varStatus="index">
							<tr>
								<td>${index.count}</td>
								<td>${menu.name}</td>
								<td>${menu.url }</td>
								<td>
									<a href="menu/edit/${menu.id}" class="link-button ajax-link">
										<i class="fa fa-edit"></i>编辑</a>
									<a href="menu/del/${menu.id}" class="link-button ajax-link">
										<i class="fa fa-trash-o"></i>删除</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		
	</div>
</div>
<script type="text/javascript">
	$(function() {
		$('.link-button').on('click',function(e) {
			if($(this).hasClass('ajax-link')) {
				e.preventDefault();
				var url = $(this).attr("href");
				alert(url);
				LoadAjaxContent(url);
			}
		});
	});
</script>