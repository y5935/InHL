<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'table.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style type="text/css">
		.grid{
			width:100%;
		}
		
		.grid thead th{
			color:#FFF;
			background:orange;
			border:solid 1px gray;
		}
		
		.grid tbody td{
			border:solid 1px gray;
		}
	</style>
	
	<script type="text/javascript">
		/**
		*	页面加载完成后执行该方法
		*	通过Ajax读取后台数据并绑定到前台Table中
		*/
		window.onload = function(){
			//获取请求对象
			var req = null;
			if(window.XMLHttpRequest)
				req = new XMLHttpRequest();
			else
				req = new ActiveXObject("Msxml2.XMLHTTP");
			
			//打开连接
			req.open("get","user2");
			
			//处理响应
			req.onreadystatechange = function(){
				if(req.readyState== 4 && req.status==200){
					//接收并处理响应数据
					//数据转换
					eval("data=" + req.responseText);
					
					//拼接HTML代码
					var str="";
					for(var i = 0;i<data.length;i++){
						str += "<tr><td>" + data[i].userId + "</td>";
						str+="<td>"+ data[i].userName + "</td>";
						str+="<td>" + data[i].account+"</td>";
						str+="<td>" + data[i].pwd+"</td></tr>";
					}
					//将HTML代码作为tbody的内容进行使用
					document.getElementById("data").innerHTML = str;
				}
			};
			
			//发送请求
			req.send(null);
		};
	</script>
  </head>
  
  <body>
    <table class="grid">
    	<thead>
    		<tr>
	    		<th>编号</th>
	    		<th>姓名</th>
	    		<th>账号</th>
	    		<th>密码</th>
    		</tr>
    	</thead>
    	<tbody id="data">
    	</tbody>
    </table>
  </body>
</html>
