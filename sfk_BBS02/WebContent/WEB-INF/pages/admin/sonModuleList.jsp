<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="../common/adminHeader.jsp" %>
<body>
	<jsp:include page="../common/adminTop.jsp" />
	<jsp:include page="../common/adminNavBar.jsp"/>
	
	<div id="main" style="height: 1000px;">
		<div class="title">子版块列表</div>

		<table class="list">
			<tr>
				<th>排序</th>
				<th>版块名称</th>
				<th>所属父版块</th>
				<th>版主</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${fatherModules }" var="fatherModule">
				<tr id="fatherModule_${fatherModule.id}">
					<td><input class="sort" type="text" name="sort"
						value='${fatherModule.sort}' /></td>
					<td>${fatherModule.moduleName }</td>
					<%-- 所属版块--%>
					<%-- 

   private Long id;
    private FatherModule fatherModule;
    private String moduleName;
    private String info;
    private Long memberId;
    private int sort;

--%>
					<td>所属父版块</td>
					<%-- 版主--%>	
					<td>版主</td>
					
					<td><a href="#">[访问]</a>&nbsp;&nbsp;<a href="${bathPath}updateFatherModuleGo/${fatherModule.id}">[编辑]</a>&nbsp;&nbsp;<a
						href="javascript:void(0)"
						onclick="DeleteFatherModule('${fatherModule.id}','${fatherModule.moduleName }')">[删除]</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>