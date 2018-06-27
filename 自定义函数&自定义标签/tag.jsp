<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="myFn" uri="http://hl/fn/myfn"%>
<%@ taglib prefix="t" uri="http://hl/tag/mytag"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tag.jsp' starting page</title>
    
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
  	
  	${myFn:show("mike")}
  	<t:showText name="Mike" other="true">
  		<a href="http://baidu.com">baidu</a>
  	</t:showText>
  	<br />
  	<t:showText name="baidu" other="true">
  		<a href="http://google.com">google</a>
  	</t:showText>
  	<br />
  	
  	<hr />
  	自定义标签测试结束
  	
  </body>
</html>
