<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style type="text/css">
		.grid{
			width:100%;
			border-collapse: collapse;
		}
		
		.grid th{
			color:#FFF;
			background:gray;
			border:solid 1px orange;
		}
		
		.grid td{
			border:solid 1px orange;
		}
	</style>
  </head>
  
  <body>
  	<a href="add.jsp">添加</a>
    <table class="grid">
    	<tr>
    		<th>
    			<input type="checkbox" />
    		</th>
    		<th>姓名</th>
    		<th>账号</th>
    		<th>密码</th>
    		<th>年龄</th>
    		<th>性别</th>
    		<th>操作</th>
    	</tr>
    	<c:forEach items="${list }" var="l">
	    	<tr>
	    		<td>
	    			<input type="checkbox" />
	    		</td>
	    		<td>${l.userName }</td>
	    		<td>${l.account }</td>
	    		<td>****</td>
	    		<td>${l.age }</td>
	    		<td>${(l.gender)? "男":"女" }</td>
	    		<td>
	    			<a href="user/load.action?user.userId=${l.userId}">修改</a>
	    			<a href="user/del.action?user.userId=${l.userId }">删除</a>
	    		</td>
	    	</tr>
    	</c:forEach>
    </table>
  </body>
</html>
