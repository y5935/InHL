<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'city.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
		/**
		*onload事件	:当页面加载结束后触发
		*options	:select下拉列表项的集合
		*Option		:select下拉列表项的类型
		*/
		window.onload=function(){
			bindData(0,"province");
		}
	
		/**
		*选择省份后触发市级列表的绑定
		*/
		function getCity(obj){
			bindData(obj.value,"city");
		}
		
		function getCounty(obj,name){
			bindData(obj.value,name);
		}
		
		/**
		*绑定数据到指定名称的下拉列表
		*/
		function bindData(id,name){
			//1、创建请求对象
			var req = null;
			if(window.XMLHttpRequest)
				req = new XMLHttpRequest();
			else
				req = new ActiveXObject("Msxml2.XMLHTTP");
			
			//2、打开连接
			req.open("get","city?pId="+id);
			//3、监听响应
			req.onreadystatechange = function(){
				if(req.readyState == 4){
					var obj = document.getElementById(name);
					
					//移除目标下拉列表的所有元素
					clearAll(obj);
					
					//添加一个默认选项
					obj.options.add(new Option("---请选择---",0));
					
					//对服务器端响应的数据进行处理
					eval("var list=" + req.responseText);
					
					//遍历响应数据集合中的所有元素
					for(var i =0;i<list.length;i++){
						obj.options.add(new Option(list[i].name,list[i].id));
					}
				}
					
			}
			//4、发送请求
			req.send(null);
		}
		
		/**
		*移除下拉列表中的所有元素
		*/
		function clearAll(obj){
			for(var i=obj.length-1;i>=0;i--){
				obj.remove(i);
			}
		}
	</script>

  </head>
  
  <body>
    <select id="province" onchange="getCity(this)"></select>
    <select id="city" onchange="getCounty(this,'county')"></select>
    <select id="county"></select>
  </body>
</html>
