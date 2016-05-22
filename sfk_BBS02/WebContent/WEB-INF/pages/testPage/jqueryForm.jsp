<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<meta charset="UTF-8">
<title>rules</title>
<script src="<%=projectPath%>js/jquery-1.12.1.js"></script>
<script src="<%=projectPath%>js/jquery.form.js"></script>

<style type="text/css">
#register {
	border: 1px solid #cacaca;
	font-size: 13px;
	margin: 100px auto;
	padding: 35px 10px 20px 30px;
	width: 75%;
}

.row {
	margin: 10px 0;
}

#register div.row input.text {
	width: 280px;
	height: 18px;
	border: 1px solid #ccc;
}
/* 有了这个error class 这个就会就会默认加到input和错误提示的标签上 */
.error {
	background: url('../img/small.png') no-repeat -20px -40px;
	padding-left: 20px;
	margin-left: 20px;
}

.ok {
	background: url('../img/small.png') no-repeat -40px -20px;
	padding-left: 20px;
	margin-left: 20px;
}
</style>
<script type="text/javascript">
    $(document).ready(function()
    {
        $("#register").ajaxForm(
        {
           // alert(123);
            dataType:'text',
            success : function(data)
            {
                alert(data);
            },
        error:function(){
            alert('fail');
        }
        });
        
        $("#btn1").click(function(){
            $.ajax({
            url:'http://localhost:8080/sfk_BBS02/postJqueryForm',
            type:'post',
            dataType:'text',
            success:function(response){
                alert(response);
            }
            }
            );
        });
    });
</script>
</head>
<body>
	<form id="register" action="${basePath}postJqueryForm" method="get">

		<div class="row">
			用户名: <input type="text" name="username" class="text" />
		</div>
		<div class="row">
			性别: <input type="radio" name="sex" />男 <input type="radio"
				name="sex" />女
		</div>
		<div class="row">
			邮箱: <input type="text" name="email" class="text" />
		</div>
		<div class="row">
			体育爱好: <input type="checkbox" name="hobby[]" value="1" />篮球 <input
				type="checkbox" name="hobby[]" value="2" />足球 <input type="checkbox"
				name="hobby[]" value="3" />游泳 <input type="checkbox" name="hobby[]"
				value="4" />跑步 <input type="checkbox" name="hobby[]" value="5" />跳舞
			<input type="checkbox" name="hobby[]" value="6" />武术
		</div>
		<div class="row">
			水果爱好: <select size="3" multiple="multiple" name="fruit">
				<option>苹果</option>
				<option>李子</option>
				<option>香蕉</option>
				<option>橘子</option>
				<option>草莓</option>
			</select>
		</div>
		<div class="row">
			注册协议: <input type="checkbox" name="agreement" />同意
		</div>

		<div class="row">
			<input type="submit" name="submit" value="submit" />
		</div>
	</form>
<button id = "btn1">testResponseGetwriter</button>
</body>
</html>