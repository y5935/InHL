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
    
    <title>My JSP 'index.jsp' starting page</title>
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
  	<!-- 1、读取str的数据 -->
  	<!-- 直接读取:读取成功 -->
  	str：  <s:property value="str"/><br />
  	
  	<!-- 使用#进行读取：读取失败 -->
  	str：<s:property value="#str" /><br />
  	
  	<!-- 使用EL表达式进行读取：读取成功 -->
  	str： ${str }<br />
  	
  	<!-- 2、读取g的数据 -->
  	<!-- 直接读取：读取成功 -->
  	g.gradeName：<s:property value="g.gradeName" /><br />
  	<!-- 使用#读取：读取失败 -->
  	g.gradeName：<s:property value="#g.gradeName" /><br />
  	<!-- 使用EL表达式进行读取：读取成功 -->
  	g.gradeName：${g.gradeName }<br />
  	
  	<!-- 3、读取作用域中的数据 -->
  	g1：<s:property value="#g1.gradeName" /><br />
  	g2：<s:property value="#session.g2.gradeName" /><br />
  	g3：<s:property value="#application.g3.gradeName" /><br />
  </body>
</html>
