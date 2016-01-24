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
<head>
<meta charset="utf-8" />
<title>论坛后台管理-sfkbbs</title>
<meta name="keywords" content="后台界面" />
<meta name="description" content="后台界面" />
<link rel="stylesheet" type="text/css"
	href="<%=projectPath%>style/public.css" />
<script src="<%=projectPath%>js/jquery-1.7.2.js"></script>
<%--这里用两个XXX.js用jquery实现,xxx2.js用原生的js实现 --%>
<script src="<%=projectPath%>js/common.js"></script>
<script src="<%=projectPath%>js/adminIndex.js"></script>
</head>