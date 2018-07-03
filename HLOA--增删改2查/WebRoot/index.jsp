<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	body{
		margin:0px;
		padding:0px;
	}
	#main{
		border:solid 1px red;
		width:100%;
		height:100%;
	}
	
	#head{
		border-bottom:solid 1px gray;
		background:orange;
		color:#FFF;
		height:120px;
	}
	
	#menu{
		width:280px;
		height:600px;
		border-right:solid 1px gray;
	}
</style>
</head>
<body>
	<table id = "main">
		<tr>
			<td colspan="2" id="head">
				<h1>翰林学生管理系统</h1>
			</td>
		</tr>
		<tr>
			<td id="menu">
				<a href="user?op=list" target="frame">学生信息维护</a>
			</td>
			<td>
				<iframe name="frame" width="100%" height="590"></iframe>
			</td>
		</tr>
	</table>
</body>
</html>