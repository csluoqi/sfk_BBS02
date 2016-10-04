<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="../common/adminHeader.jsp"%>
<body>
	<jsp:include page="../common/adminTop.jsp" />
	<jsp:include page="../common/adminNavBar.jsp" />

	<div id="main" style="height: 1000px;">
		<div class="title">子版块列表</div>
		<form action="${basePath }sortSonModule" method="post">
		<table class="list">
			<tr>
				<th>排序</th>
				<th>版块名称</th>
				<th>所属父版块</th>
				<th>版主</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${sonModuleList}" var="sonModule">
				<tr id="sonModule_${sonModule.id}">
					<td><input class="sort" type="text" name="sort_${sonModule.id}"
						value='${sonModule.sort}' /></td>
					<td>${sonModule.moduleName }</td>

					<%-- 所属版块--%>

					<td>${sonModule.fatherModule.moduleName}</td>
					<%-- 版主--%>
					<td>待定（版主Id是${sonModule.memberId}）</td>

					<td><a href="#">[访问]</a>&nbsp;&nbsp;<a
						href="${bathPath}updateSonModuleGo/${sonModule.id}">[编辑]</a>&nbsp;&nbsp;<a
						href="javascript:void(0)"
						onclick="deleteSonModule('${sonModule.id}','${sonModule.moduleName}')">[删除]</a></td>
				</tr>
			</c:forEach>
		</table>
		<input class="btn" style="cursor: pointer; margin-top: 10px"
				type="submit" name="submit" value="排序">
		</form>
	</div>
</body>
</html>