<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String nameSpace = request.getContextPath();
%>
<%
    String projectPath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + nameSpace + "/";
%>
<c:set value="<%=projectPath %>" var="basePath"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生表单</title>
</head>
<body>
	<!--
private Long id;
    private String name;
    private String gender;
    // 测试 整型 (在验证表单对象的合法性时)
    private Integer stuNumber;
    // 测试 时间类型 (在验证表单对象的合法性时)
    private Date birthday;
  -->
  <span>projectPath : ${basePath }</span>
	<form:form action="saveStudent" commandName="studentOfTestSpringMVC" method="post">
		<table>
			<tr>
				<td>name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>gender</td>
				<td><form:input path="gender" /></td>
			</tr>
			<tr>
				<td>stuNumber</td>
				<td><form:input path="stuNumber" /></td>
			</tr>
			<form:errors path="birthday" cssClass="error" />
			<tr>
				<td>birthday</td>
				<td><form:input path="birthday" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>