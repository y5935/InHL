<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="emp/add" method="post">
    	<!-- 
    		如果需要使用Struts2的验证框架。
    		必须使用对应的Struts2标签才能对错误消息进行显示
    	-->
    	<table>
    		<tr>
    			<th>姓名：</th>
    			<td>
    				<input type="text" name="userName" />
    			</td>
			<td><s:fielderror fieldName="userName"></s:fielderror></td>
    		</tr>
    		<tr>
    			<th>账号：</th>
    			<td><input type="text" name="account" /></td>
    		</tr>
    		<tr>
    			<th>密码：</th>
    			<td><input type="text" name="pwd" /></td>
    		</tr>
    		<tr>
    			<th>年龄：</th>
    			<td>
    				<input type="text" name="age" />
    			</td>
			<td><s:fielderror fieldName="userName"></s:fielderror></td>
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
