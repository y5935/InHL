<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <style type="text/css">
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

  </head>
  
  <body>
  	<ul class="pager">    	
    	<c:if test="${page.first}">
	    	<li>首页</li>
    		<li>上一页</li>
    	</c:if>
    	<c:if test="${!page.first }">
    		<li onclick="jump(1)">首页</li>
    		<li onclick="jump(${page.index-1})">上一页</li>    	
    	</c:if>
    	
    	<c:forEach begin="1" end="${page.pages }" var="p">
    		<li onclick="jump(${p})">${p}</li>
    	</c:forEach>
    	<c:if test="${page.last}">
    	   	  <li>下一页</li>  
    	   	  <li>末页</li>	
    	</c:if>
    	<c:if test="${!page.last }">
    		<li onclick="jump(${page.index+1 })">下一页</li> 
    		<li onclick="jump(${page.pages})">末页</li>
    	</c:if>
    </ul>
  </body>
</html>
