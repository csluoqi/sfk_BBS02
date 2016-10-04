<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    String nameSpace = request.getContextPath();
%>
<%
    String projectPath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + nameSpace + "/";
%>
<%--以后可以在页面直接使用$("basepath") --%>
<c:set value="<%=projectPath %>" var="basePath"/>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8" />
<title>会员注册</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" type="text/css" href="${basePath}style/portal/public.css" />
<link rel="stylesheet" type="text/css" href="${basePath}style/portal/register.css" />



<%-- 


<link rel="stylesheet" type="text/css"
	href="<%=projectPath%>style/public.css" />
<script src="<%=projectPath%>js/jquery-1.12.1.js"></script>
<script src="<%=projectPath%>js/validation/jquery.validate.js"></script>
<script src="<%=projectPath%>js/validation/additional-methods.js"></script>
<script src="<%=projectPath%>js/validation/messages_zh.js"></script>
这里用两个XXX.js用jquery实现,xxx2.js用原生的js实现
<script src="<%=projectPath%>js/common.js"></script>
<script src="<%=projectPath%>js/adminIndex.js"></script>
<link rel="stylesheet" type="text/css" href="<%=projectPath%>style/myJqueryValidate.css">
 --%>

</head>
<body>
	<div class="header_wrap">
		<div id="header" class="auto">
			<div class="logo">sifangku</div>
			<div class="nav">
				<a class="hover">首页</a>
				<a>新帖</a>
				<a>话题</a>
			</div>
			<div class="serarch">
				<form>
					<input class="keyword" type="text" name="keyword" placeholder="搜索其实很简单" />
					<input class="submit" type="submit" name="submit" value="" />
				</form>
			</div>
			<div class="login">
				<a>登录</a>&nbsp;
				<a>注册</a>
			</div>
		</div>
	</div>
	<div style="margin-top:55px;"></div>
	<div id="register" class="auto">
		<h2>欢迎注册成为 私房库会员</h2>
		<form action="" method="post">
			<label>用户名：<input type="text"  name='name' /><span>*用户名含有禁用字符，请选择其他用户名</span></label>
			<label>密码：<input type="password" name='pw' /><span>*用户名含有禁用字符，请选择其他用户名</span></label>
			<label>确认密码：<input type="password" name="confirm_pw" /><span>*用户名含有禁用字符，请选择其他用户名</span></label>
			<label>验证码：<input name="vcode" type="text"  /><span>*请输入下方验证码</span></label>
			<img class="vcode" src="${basePath }style/portal/show_code.php.jpg" />
			<div style="clear:both;"></div>
			<input class="btn" type="submit" value="确定注册" />
		</form>
	</div>
	<div id="footer" class="auto">
		<div class="bottom">
			<a>私房库</a>
		</div>
		<div class="copyright">Powered by sifangku ©2015 sifangku.com</div>
	</div>
</body>
</html>
