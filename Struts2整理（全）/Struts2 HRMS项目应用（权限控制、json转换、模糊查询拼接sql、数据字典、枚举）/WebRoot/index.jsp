<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	
	
  </head>

	<frameset rows="100,*" cols="*" scrolling="No" framespacing="0"
		frameborder="no" border="0">
		<frame src="head.jsp" name="headmenu" id="mainFrame" title="mainFrame">
		<!-- 引用头部 -->
		<!-- 引用左边和主体部分 -->
		<frameset rows="100*" cols="220,*" scrolling="No" framespacing="0"
			frameborder="no" border="0">
			<frame src="menu.jsp" name="leftmenu" id="mainFrame" title="mainFrame">
			<frame src="main.html" name="main" scrolling="yes" noresize="noresize" id="rightFrame" title="rightFrame">
		</frameset>
	</frameset>
	<noframes></noframes>
</html>
