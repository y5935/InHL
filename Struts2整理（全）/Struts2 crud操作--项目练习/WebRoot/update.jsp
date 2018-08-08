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
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
  
  <body>
    <form action="user/update.action" method="post">
    	<table>
    		<tr>
    			<th>姓名：</th>
    			<td><input type="text" name="user.userName" value="${user.userName }" /></td>
    		</tr>
    		<tr>
    			<th>账号：</th>
    			<td><input type="text" name="user.account"  value="${user.account }"/></td>
    		</tr>
    		<tr>
    			<th>密码：</th>
    			<td><input type="text" name="user.pwd"  value="${user.pwd }"/></td>
    		</tr>
    		<tr>
    			<th>年龄：</th>
    			<td><input type="text" name="user.age"  value="${user.age }"/></td>
    		</tr>
    		<tr>
    			<th>性别：</th>
    			<td>
    				<c:if test="${user.gender}">
						<input type="radio" name="user.gender" checked="checked" value="true">男
						<input type="radio" name="user.gender" value="false">女
					</c:if>
					<c:if test="${!user.gender }">
						<input type="radio" name="user.gender" value="true">男
						<input type="radio" name="user.gender" checked="checked" value="false">女
					</c:if>
				</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<input type="submit" value="提交" />
    			</td>
    		</tr>
    	</table>
    	<input type="hidden" name="user.userId" value="${user.userId }" />
    </form>
  </body>
</html>
