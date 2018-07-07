<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
		}
		
		.grid th{
			color:#fff;
			background:orange;
			border:solid 1px gray;
		}
		
		.grid td{
			border:solid 1px gray;
		}
	</style>
	
	<script type="text/javascript">
		function jump(index){
			location.href="user?index=" + index;
		}
	</script>

  </head>
  
  <body>
    <table class="grid">
    	<tr>
    		<th>编号</th>
    		<th>姓名</th>
    		<th>账号</th>
    		<th>密码</th>
    		<th>
    			操作
    		</th>
    	</tr>
    	<c:forEach items="${page.list }" var="l">
	    	<tr>
	    		<td>${l.userId }</td>
	    		<td>${l.userName }</td>
	    		<td>${l.account }</td>
	    		<td>${l.pwd }</td>
	    		<td>
	    			<a>修改</a>
	    			<a>删除</a>
	    		</td>
	    	</tr>
		</c:forEach>
    </table>
	<%@ include file="pager.jsp" %>
  </body>
</html>
