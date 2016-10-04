<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String nameSpace = request.getContextPath();
%>
<%
    String projectPath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + nameSpace + "/";
%>
<%
	//左侧导航栏点击之后显示灰色的小圆点,
    String servletPath = request.getServletPath();
	
%>
<!--navBar  -->
<div id="sidebar">
	<ul>
		<li>
			<div class="small_title">系统</div>
			<ul class="child">
				<li><a href="#">系统信息</a></li>
				<li><a href="#">管理员</a></li>
				<li><a href="#">添加管理员</a></li>
				<li><a href="#">站点设置</a></li>
			</ul>
		</li>
		<li>
			<!--  class="current" -->
			<div class="small_title">内容管理</div>
			<ul class="child">
				<!--默认显示父板块列表  -->
				<!-- http://localhost:8080/sfk_BBS02/adminIndex-->
				<!--约定,项目中的明明规则中连接的最后部分何jsp文件的名字是相同的,详细可以看ActionURL和PagePath  -->
				<!--从下面可以发现java脚本功能是非常强大的  -->
				<li><a <% if(servletPath.contains("adminIndex")){ %> class="current"<%} %> href="<%=projectPath %>adminIndex">父板块列表</a></li>
				<li><a <% if(servletPath.contains("newFatherModule")){ %> class="current"<%} %> href="<%=projectPath%>newFatherModule">添加父板块</a></li>
				<%--如果是更改父版块，则出现一个不能点击的显示标签 --%>
				<% if(servletPath.contains("updateFatherModule")){ %><li><a class="current">编辑父版块</a></li> <%} %>
				<li><a <% if(servletPath.contains("sonModuleList")){ %> class="current"<%} %> href="<%=projectPath%>sonModuleList">子板块列表</a></li>
				<!--/newSonModuleGo"  -->
				<li><a <% if(servletPath.contains("newSonModule")){ %> class="current"<%} %> href="<%=projectPath%>newSonModuleGo">添加子板块</a></li>
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