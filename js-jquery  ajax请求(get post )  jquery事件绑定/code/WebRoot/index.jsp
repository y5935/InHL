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
	
	<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript">
		/**
		*原生态Ajax
		*/
		function fun1(){
			//1、创建请求对象
			var req = null;
			if(window.XMLHttpRequest)
				req = new XMLHttpRequest();
			else
				req = new ActiveXObject("Msxml2.XMLHTTP");
			
			//2、打开连接
			req.open("get","serv01");
			
			//3、监听响应
			req.onreadystatechange=function(){
				if(req.readyState==4)
					alert(req.responseText);
			}
			//4、发送请求
			req.send(null);
		}
		
		/**
		* Jquery下的Ajax
		*		type	:请求的提交方式
		*		url		:请求的资源地址
		*		data	:post模式下的请求参数(post模式下提交的请求数据)
		*		dataType:响应数据的类型
		*		success	:请求成功
		*		async	:是否为异步Ajax（默认是）
		*/
		function fun2(){
			$.ajax({
				type	:	"get",
				url		:	"serv01",
				/*data	:	"name=Mike&age=20"*/
				dataType:	"json",
				success	:	function(result){
					//alert(result);
					alert(result.no + " | " + result.name);
				}
			});
		}
		
		/**
		*get方式发送Ajax请求
		*	$.get(url,[data,]fun[,type]);
		*/
		function fun3(){
			$.get(
					"serv01?id=20",
					function(result){
						alert(result);
					},
					"text"
				);
		}
		/**
		*post方式发送Ajax请求
		*$.post(url,[data,]fun[,type]);
		*/
		function fun4(){
			$.post(
					"serv01",
					{id:20},
					function(result){
						alert(result);
					},
					"text"
				);
		}
		
		//Js<===>Jquery		
		window.onload = function(){
			//1、Js对象转Jquery
			var txt1 = document.getElementById("txt1");
			alert(txt1);
			//txt1是Js对象。而Js对象无法直接使用jquery的val()方法
			//alert(txt1.val());
			//如果要实用化val()必须先将txt1转为jquery对象
			alert($(txt1).val());
			
			//2、jquery对象转为js对象
			var txt2 = $("#txt1");
			//alert(txt2.val());
			//jquery返回的是一个对象集合，所以转换过程中需要以数组的方式进行获取
			var txt3 = txt2[0];
			alert(txt3 + " | " + txt3.value);
		}
	</script>
  </head>
  
  <body>
  	<input type="button" value="原生态Ajax" onclick="fun1()"/>
  	<input type="button" value="Jquery中的Ajax" onclick="fun2()"/>
  	<input type="button" value="get方式的Ajax" onclick="fun3()"/>
  	<input type="button" value="post方式的Ajax" onclick="fun4()"/>
  	<hr />
  	<input type="text" value="这是文本框" id="txt1" />
  </body>
</html>
