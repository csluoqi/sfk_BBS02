<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String nameSpace = request.getContextPath();
%>
<%
    String projectPath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + nameSpace + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8" />
<title>后台界面</title>
<meta name="keywords" content="后台界面" />
<meta name="description" content="后台界面" />
<link rel="stylesheet" type="text/css"
	href="<%=projectPath%>style/public.css" />
<script src="<%=projectPath%>js/jquery-1.7.2.js"></script>
<%--这里用两个XXX.js用jquery实现,xxx2.js用原生的js实现 --%>
<script src="<%=projectPath%>js/adminIndex.js"></script>
</head>
<body>
	<div id="top">
		<div class="logo">管理中心</div>
		<ul class="nav">
			<li><a href="http://www.sifangku.com" target="_blank">私房库</a></li>
			<li><a href="http://www.sifangku.com" target="_blank">私房库</a></li>
		</ul>
		<div class="login_info">
			<a href="#" style="color: #fff;">网站首页</a>&nbsp;|&nbsp; 管理员： admin <a
				href="#">[注销]</a>
		</div>
	</div>
	<div id="sidebar">
		<ul>
			<li>
				<div class="small_title">系统</div>
				<ul class="child">
					<li><a class="current" href="#">系统信息</a></li>
					<li><a href="#">管理员</a></li>
					<li><a href="#">添加管理员</a></li>
					<li><a href="#">站点设置</a></li>
				</ul>
			</li>
			<li>
				<!--  class="current" -->
				<div class="small_title">内容管理</div>
				<ul class="child">
					<li><a class="current" href="#">父板块列表</a></li>
					<li><a href="#">添加父板块</a></li>
					<li><a href="#">子板块列表</a></li>
					<li><a href="#">添加子板块</a></li>
					<li><a href="#">帖子管理</a></li>
				</ul>
			</li>
			<li>
				<div class="small_title">用户管理</div>
				<ul class="child">
					<li><a href="#">用户列表</a></li>
				</ul>
			</li>
		</ul>
	</div>
	<div id="main" style="height: 1000px;">
		<div class="title">父板块列表</div>

		<table class="list">
			<tr>
				<th>排序</th>
				<th>版块名称</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${fatherModules }" var="fatherModule">
				<tr id="fatherModule_${fatherModule.id}">
					<td><input class="sort" type="text" name="sort"
						value='${fatherModule.sort}' /></td>
					<td>${fatherModule.moduelName }</td>
					<td><a href="#">[访问]</a>&nbsp;&nbsp;<a href="#">[编辑]</a>&nbsp;&nbsp;<a
						href="javascript:void(0)"
						onclick="DeleteFatherModule('${fatherModule.id}','${fatherModule.moduelName }')">[删除]</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>