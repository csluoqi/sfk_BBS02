<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="../common/adminHeader.jsp"%>

<body>
	<jsp:include page="../common/adminTop.jsp" />
	<jsp:include page="../common/adminNavBar.jsp"/>

	<div id="main" style="height: 1000px;">
		<div class="title" style="margin-bottom:20px">添加父板块</div>
		
		<form:form commandName="fatherModule" action="saveFatherModule" method="post">
			<table class="au">
				<tr>
					<td>版块名称</td>
					<td><form:input  path="moduelName"/></td>
					<td>支持HTML代码</td>
				</tr>
				<tr>
					<td>排序</td>
					<td><form:input path="sort"/></td>
					<td>支持HTML代码</td>
				</tr>
				<tr>
					<td>版块名称</td>
					<td><input type="text" /></td>
					<td>支持HTML代码</td>
				</tr>
			</table>
			<input class="btn" style="cursor: pointer; margin-top: 10px"
				type="submit" name="submit" value="添加">
		</form:form>
	</div>
</body>
</html>