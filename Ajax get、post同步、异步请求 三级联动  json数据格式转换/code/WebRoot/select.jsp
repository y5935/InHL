<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'select.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">
		window.onload=function(){
			var sel = document.getElementById("province");
			bind(sel,0);
		};
		
		/**
		*	获取城市列表
		*/
		function getCity(obj){
			var sel = document.getElementById("city");
			bind(sel,obj.value);
		}
		
		function getStreet(obj){
			var sel = document.getElementById("street");
			bind(sel,obj.value);
		}
		
		/**
		* 为元素绑定数据
		*	sel:需要进行数据绑定的元素对象
		*	pid：数据的Pid
		*/
		function bind(sel,pid){
			if(sel==null || sel==undefined) return;
			
			//通过Ajax加载数据
			//创建Ajax请求对象
			var req= null;
			
			if(window.XMLHttpRequest)
				req = new XMLHttpRequest();
			else
				req = new ActiveXObject("Msxml2.XMLHTTP");
			
			//打开连接
			req.open("get","city?pid=" + pid);
			
			//处理服务器端响应
			req.onreadystatechange = function(){
				if(req.readyState == 4 && req.status==200){
					//清空当前下拉列表的所有元素向
					sel.options.length=0;
					
					sel.options.add(new Option("---请选择---",-1));
				
					//将字符串转为json对象
					eval("data=" + req.responseText);
					
					for(var i =0;i<data.length;i++){
						sel.options.add(new Option(data[i].cityName,data[i].cityId));
					}
				}
			};	
			
			//发送请求
			req.send(null);
			
		}
		
		
	</script>

  </head>
  
  <body>
  	省份：   <select id="province" onchange="getCity(this)"></select>
  	城市：   <select id="city" onchange="getStreet(this)"></select>
  	县(区)：   <select id="street"></select>
  </body>
</html>
