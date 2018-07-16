<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		.red_border{
			border:solid 1px red;
		}
	</style>
	<script type="text/javascript">
		/**
		* 清空表单输入框
		*/
		function cls(){
			document.getElementById("txtAccount").value="";
			document.getElementById("txtPwd").value="";
		}
		
		function login(){
			//1、获取用户名、密码
			var account = document.getElementById("txtAccount").value;
			var pwd = document.getElementById("txtPwd").value;
			
			//2、通过Ajax执行登录验证
			//1)、创建请求对象
			var req = null;
			
			if(window.XMLHttpRequest)
				req = new XMLHttpRequest();
			else
				req = new ActiveXObject("Msxml2.XMLHTTP");
			
			//2)、打开连接
			req.open("get","login?account=" + account + "&pwd=" + pwd);
			
			//3)、监听服务端响应
			req.onreadystatechange=function(){
				if(req.readyState == 4 && req.status == 200){
					if(1==req.responseText)
						document.getElementById("txtAccount").setAttribute("class", "red_border");
					else
						document.getElementById("txtAccount").removeAttribute("class");
					
					if(-1==req.responseText)
						document.getElementById("txtPwd").setAttribute("class", "red_border");
					else
						document.getElementById("txtPwd").removeAttribute("class");
					
					if(2== req.responseText)
						location.href="index.jsp";
				}
			};
			
			//4)、发送请求
			req.send(null);
		}
	</script>
  </head>
  
  <body>
    <table>
    	<tr>
    		<th>账号：</th>
    		<td>
    			<input type="text" name="account" id="txtAccount" />
    		</td>
    	</tr>
     	<tr>
    		<th>密码：</th>
    		<td>
    			<input type="text" name="pwd" id="txtPwd"/>
    		</td>
    	</tr>   	
    	<tr>
    		<td colspan="2">
    			<input type="button" value="登录" onclick="login()" />
    			<input type="button" value="重置" onclick="cls()"/>
    		</td>
    	</tr>
    </table>
  </body>
</html>
