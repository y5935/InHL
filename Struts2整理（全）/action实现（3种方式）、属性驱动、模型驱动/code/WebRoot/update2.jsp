<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	
  </head>
  
  <body>
    <form action="user/update.action" method="post">
    	<table>
    		<caption>
    			更新数据
    		</caption>
    		<tr>
    			<th>姓名：</th>
    			<td>
    				<input type="text" name="userName" value="${user.userName }"/> 
    			</td>
    		</tr>
    		<tr>
    			<th>帐号：</th>
    			<td>
    				<input type="text" name="account" value="${user.account }"/> 
    			</td>
    		</tr> 
			<tr>
    			<th>密码：</th>
    			<td>
    				<input type="text" name="pwd" value="${user.pwd }"/> 
    			</td>
    		</tr>   
    		<tr>
    			<td>
    				<input type="submit" value="保存" />
    			</td>
    		</tr>		
    	</table>
    </form>
  </body>
</html>
