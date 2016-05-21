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
<head>
<meta charset="utf-8" />
<title>论坛后台管理-sfkbbs</title>
<meta name="keywords" content="后台界面" />
<meta name="description" content="后台界面" />
<link rel="stylesheet" type="text/css"
	href="<%=projectPath%>style/public.css" />
<script src="<%=projectPath%>js/jquery-1.12.1.js"></script>
<script src="<%=projectPath%>js/validation/jquery.validate.js"></script>
<script src="<%=projectPath%>js/validation/additional-methods.js"></script>
<script src="<%=projectPath%>js/validation/messages_zh.js"></script>
<%--这里用两个XXX.js用jquery实现,xxx2.js用原生的js实现 --%>
<script src="<%=projectPath%>js/common.js"></script>
<script src="<%=projectPath%>js/adminIndex.js"></script>
<link rel="stylesheet" type="text/css" href="<%=projectPath%>style/myJqueryValidate.css">
</head>