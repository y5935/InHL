<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/default.css">
</head>
<body>
	<form action="user?op=find" method="post">
		<div class="find_area">
			姓名：<input type="text" name="name" />&nbsp;&nbsp;
			<input type="submit" value="查询" />			
			<input type="reset" value="清空" />
		</div>
	</form>

	<a href="add.jsp">新增</a>
	<table class="grid">
		<tr>
			<th>Id</th>
			<th>姓名</th>
			<th>帐号</th>
			<th>密码</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list }" var="u">
			<tr>
				<td>${u.userId }</td>
				<td>${u.userName }</td>
				<td>${u.account }</td>
				<td>${u.pwd }</td>
				<td>
					<a href="user?op=load&id=${u.userId }">编辑</a>
					<a href="user?op=del&id=${u.userId }">删除</a>
					<a href="#">查看</a>
				</td>			
			</tr>
		</c:forEach>
	</table>
</body>
</html>