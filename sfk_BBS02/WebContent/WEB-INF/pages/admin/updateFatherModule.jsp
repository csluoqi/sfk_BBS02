<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="../common/adminHeader.jsp"%>
<c:set value="<%=projectPath %>" var="basePath"/>
<body>
	<jsp:include page="../common/adminTop.jsp" />
	<jsp:include page="../common/adminNavBar.jsp"/>

	<div id="main" style="height: 1000px;">
		<div class="title" style="margin-bottom:20px">编辑父板块</div>
		
		<form:form id="newFatherModule" commandName="fatherModule" action="${basePath}updateFatherModule" method="POST">
			<table class="au">
				<tr>
					<td>版块名称</td>
					<td><form:input  path="moduleName"/></td>
					<form:input type="hidden" path="id"/>
				</tr>
				<tr>
					<td>排序</td>
					<td><form:input path="sort"/></td>
				</tr>
			</table>
			<input class="btn" style="cursor: pointer; margin-top: 10px"
				type="submit" name="submit" value="修改">
		</form:form>
	</div>
	
</body>
</html>