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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function back(){
			var result = confirm("您确认要退出修改功能吗？");
			
			if(result)
				//history.back();
				history.go(-1);
		}
	</script>
  </head>
  
  <body>
    <form action="user?op=update" method="post">
    	<table>
    		<tr>
    			<th>姓名：</th>
    			<td>
    				<input type="text" name="userName" value="${user.userName }"/>
    				
    			</td>
    		</tr>
    		<tr>
    			<th>账号：</th>
    			<td>
    				<input type="text" name="account" value="${user.account }"/>
    				
    			</td>
    		</tr>
    		<tr>
    			<th>密码：</th>
    			<td>
    				<input type="text" name="pwd" value="${user.pwd }"/>
    				<input type="text" name="userId" value="${user.userId }" />
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<input type="submit" value="提交" />
    				<input type="reset" value="重置" disabled="disabled"/>
    				<input type="button" value="返回" onclick="back()"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
