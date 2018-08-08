<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upload1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	
	<script type="text/javascript">
		$(function(){
			$("#btn").click(function(){
				//拼接添加的内容（File元素、button元素、文本对象（文件））
				var str = "<p>文件：<input type='file' name='files' />";
				str += "<input type='button' onclick='del(this)' value='删除'/></p>";
				//将拼接的结果添加到外层容器（名为content的div）
				$("#content").append(str);
			});
			

		});
		
		/**
		*移除当前上传项
		*/
		function del(obj){
			//获取当前元素(button)的父元素然后删除
			$(obj).parent().remove();
		}
	</script>
 
  </head>
  
  <body>
    <form action="file/upload2.action" method="post" enctype="multipart/form-data">
    	<div id="content">
    		文件：<input type="file" name="files" />
    		
    	</div>
    	<input type="button" value="添加" id="btn"/>
    	<input type="submit" value="上传" />
    </form>
  </body>
</html>
