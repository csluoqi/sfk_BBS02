<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="../common/adminHeader.jsp"%>
<c:set value="<%=projectPath %>" var="basePath"/>
<body>
	<jsp:include page="../common/adminTop.jsp" />
	<jsp:include page="../common/adminNavBar.jsp"/>

	<div id="main" style="height: 1000px;">
		<div class="title" style="margin-bottom:20px">编辑父板块</div>
		
	<form:form id="newSonModule" commandName="sonModule"
			action="${basePath}updateSonModule" method="POST">
			<table class="au">
				<tr hidden="hidden">
					<td><form:input path="id" /></td>
				</tr>
				<tr>
					<td>父版块名称</td>
					<td><form:select id="fatherModule" path="fatherModule.id"
							items="${fatherModule}" itemLabel="moduleName" itemValue="id" /></td>
				</tr>
				<tr>
					<td>子版块名称</td>
					<td><form:input path="moduleName" /></td>
				</tr>
				<tr>
					<td>描述信息</td>
					<td><form:input path="info" /></td>
				</tr>
				<tr>
					<td>版主</td>
					<!--这里必须输入数字，在后台要改  -->
					<td><form:input path="memberId" /></td>
				</tr>
				<tr>
					<td>排序</td>
					<td><form:input path="sort" /></td>
				</tr>
			</table>
			<input class="btn" style="cursor: pointer; margin-top: 10px"
				type="submit" name="submit" value="更新">
		</form:form>
	</div>
	
</body>
</html>