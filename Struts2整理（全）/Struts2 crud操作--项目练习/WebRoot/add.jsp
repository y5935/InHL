<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    <form action="user/add.action" method="post">
    	<table>
    		<tr>
    			<th>姓名：</th>
    			<td><input type="text" name="user.userName" /></td>
    		</tr>
    		<tr>
    			<th>账号：</th>
    			<td><input type="text" name="user.account" /></td>
    		</tr>
    		<tr>
    			<th>密码：</th>
    			<td><input type="text" name="user.pwd" /></td>
    		</tr>
    		<tr>
    			<th>年龄：</th>
    			<td><input type="text" name="user.age" /></td>
    		</tr>
    		<tr>
    			<th>性别：</th>
    			<td>
					<input type="radio" name="user.gender" value="true">男
					<input type="radio" name="user.gender" value="false">女
				</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<input type="submit" value="提交" />
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
