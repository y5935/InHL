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
	<style type="text/css">
		.red_border{
			border:solid 1px red;
		}
	</style>
	<script type="text/javascript">
		function check(obj){
			//判断当前元素的内容是否为空
			if(obj.value.length <1)
				return;
			
			//通过Ajax进行验证
			//1、创建请求对象
			var req = null;
			if(window.XMLHttpRequest)
				req = new XMLHttpRequest();
			else
				req = new ActiveXObject("Msxml2.XMLHTTP");
			
			//2、建立连接
			req.open("get","user?op=check&account=" + obj.value);
			
			//3、监听响应
			req.onreadystatechange = function(){
				if(req.readyState==4){
					if(req.responseText =='true')
						obj.setAttribute("class","red_border");
					else
						obj.removeAttribute("class");
				}	
			}
			
			//4、发送请求
			req.send(null);
		}
	</script>
  </head>
  
  <body>
    <form action="user" method="post">
    	<table>
    		<tr>
    			<td>姓名：</td>
    			<td>
    				<input type="text" name="userName" />
    			</td>
    		</tr>
    		<tr>
    			<td>账号：</td>
    			<td>
    				<input type="text" name="account" onblur="check(this)"/>
    			</td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td>
    				<input type="text" name="pwd" />
    			</td>
    		</tr> 
    		<tr>
    			<td>
    				<input type="submit" value="保存">
    			</td>
    		</tr>   		
    	</table>
    </form>
  </body>
</html>
