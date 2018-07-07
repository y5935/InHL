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
		
		.pager{
			padding:0px;
			list-style: none;
		}
		
		.pager li{
			float:left;
			padding:10px;
			background:orange;
			margin-right:3px;
			cursor:pointer;
			border:solid 1px blue;
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
    	<c:forEach items="${list }" var="l">
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
    <ul class="pager">    	
    	<c:if test="${index==1}" var="flag">
	    	<li>首页</li>
    		<li>上一页</li>
    	</c:if>
    	<c:if test="${!flag }">
    		<li onclick="jump(1)">首页</li>
    		<li onclick="jump(${index-1})">上一页</li>    	
    	</c:if>
    	
    	<c:forEach begin="1" end="${pages }" var="num">
    		<li onclick="jump(${num})">${num }</li>
    	</c:forEach>
    	<c:if test="${index==pages}" var="flag">
    	   	  <li>下一页</li>  
    	   	  <li>末页</li>	
    	</c:if>
    	<c:if test="${!flag }">
    		<li onclick="jump(${index+1 })">下一页</li> 
    		<li onclick="jump(${pages})">末页</li>
    	</c:if>

    	
    </ul>
  </body>
</html>
