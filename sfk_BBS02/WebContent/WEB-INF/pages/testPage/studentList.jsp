<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String nameSpace = request.getContextPath();
%>
<%
    String projectPath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ nameSpace + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试autoComplete</title>
<script src="<%=projectPath%>js/jquery-1.12.1.js"></script>
<script src="<%=projectPath%>js/autoComplete/jquery.autocomplete.js"></script>

<link rel="stylesheet" type="text/css"
	href="<%=projectPath%>style/styles.css">
<script type="text/javascript">
    $(function()
    {
        var mydata = [
        {
            value : '孙胜利',
            data : 'sunshengli'
        },
        {
            value : '私房库',
            data : 'http:sifangku.com'
        },
        {
            value : '罗琪',
            data : 'luoqi'
        },
        {
            value : '罗志祥',
            data : 'qq'
        },
        {
            value : '罗志吉',
            data : 'ww'
        }

        ];
        $("#autocomplete").autocomplete(
        {
            //lookup : mydata,
            onSelect:function(suggestion)
            {//函数的参数都是形参!!!
                console.log(suggestion);
            },
            //minChars:2,
            serviceUrl:'/sfk_BBS02/getNameList',
            formatResult:function(suggestion,currentValue){
                return '<div>'+suggestion.value+suggestion.count+'</div>'
            }
        });

    });
</script>
</head>
<body>
	<!-- 测试autoComplete -->
	<form>
		姓名:<input id="autocomplete" type="text" name="abc">
	</form>
</body>
</html>