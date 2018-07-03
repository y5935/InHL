<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajax.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		/**
		*	1、创建request对象
		*		浏览器支持XmlHttpRequest、ActiveXObject	
		*		通过XmlHttpRequest、ActiveXObject对象可以实现前端与后台的交互
		*		
		*/
		function method1(){
			var req = null;
			//判断当前浏览器是否支持XMLHttpRequest
			if(window.XMLHttpRequest)
				//IE7+、Firefox、Chrome、Safari 以及 Opera
				req = new XMLHttpRequest(); 
			else
				//IE7-
				//Active插件安全性较低，且兼容性较差
				req = new ActiveXObject("Msxml2.XMLHTTP");
			
			alert(req);
		}
		
		/**
		*	2、完整的Ajax
		*/
		function method2(){
			var req = null;
			
			//1、创建请求对象
			if(window.XMLHttpRequest)
				req = new XMLHttpRequest();
			else
				req = new ActiveXObject("Msxml2.XMLHTTP");
			
			//2、打开连接
			//open(请求方式，URL地址，是否为异步请求)
			//请求方式：get/post
			//是否为异步请求：true（默认值）/false
			req.open("get","serv01");
			
			//4、监听响应
			//readyState：请求状态。不同浏览器将返回不同的状态码
			//0	:请求未初始化
			//1 :连接已建立
			//2	：请求已接收
			//3	:请求处理中
			//4	:请求已完成，响应已就绪
			req.onreadystatechange = function(){
				alert(req.readyState);
				if(req.readyState ==4)
					alert("请求已完成");
			};
			
			//3、发送请求
			//null值可以省略
			//为了兼容较老浏览器，建议使用
			req.send(null);
		}
		
		/**
		*	3、发送异步请求
		*		抢资源，谁先抢到谁先执行
		*		多任务，多通道，抢资源
		*/
		function method3(){
			var req = null;
			
			//判断当前浏览器是否支持XmlHttpRequest对象
			if(window.XMLHttpRequest)
				req = new XMLHttpRequest();
			else
				req = new ActiveXObject("Msxml2.XMLHTTP");
			
			//异步方式打开连接
			req.open("get","serv01",true);
			
			//监听响应
			req.onreadystatechange = function(){
				if(req.readyState ==4)
					alert("响应已处理");
			};
			
			//发送请求
			req.send(null);
			
			alert("OK");	
		}
		
		/**
		*	4、同步请求
		*		排队，前面的执行完成后，后面的才能执行
		*		单任务、单通道、阻塞模式
		*/
		function method4(){
			//创建请求
			var req = null;
			if(window.XMLHttpRequest)
				req = new XMLHttpRequest();
			else 
				req = new ActiveXObject("Msxml2.XMLHTTP");
			
			//同步方式打开连接
			req.open("get","serv01",false);
			
			//监听响应
			req.onreadystatechange = function(){
				if(req.readyState == 4)
					alert("响应已处理");
			}
			
			//发送请求
			req.send(null);
			
			alert("OK");
		}
		
		/**
		*	5、get方式提交请求
		*		1)、参数：通过URL进行传递
		*		2)、中文乱码
		*			a、配置tomcat（server.xml）服务器:Connector中加入 URIEncoding="UTF8"（Firefox下有效）
		*			b、Ajax中需要使用encodeURIComponent()函数对中文参数进行编码(IE浏览器需要进行编码)
		*			c、服务器端需要使用setCharacterEncoding()设置编码格式
		*		3)、会产生缓存
		*			a、IE浏览器产生缓存后，不会对同一地址进行重复提交请求
		*			b、火狐不存在该问题
		*			c、解决IE浏览器缓存问题:通过随机数去改变URL地址（参数的值，但是不建议使用）
		*/
		function method5(){
			//1、创建请求对象
			var req = null;
			if(window.XMLHttpRequest)
				req = new XMLHttpRequest();
			else
				req = new ActiveXObject("Msxml2.XMLHTTP");
			
			//2、打开连接
			//req.open("get","serv01?name=Mike&age=20");
			var s2 = encodeURIComponent("麦克");
			req.open("get","serv01?name="+s2+"&age=20&m=" + Math.random());
			
			//3、监听响应
			req.onreadystatechange = function(){
				if(req.readyState==4)
					alert("ok");
			};
			
			//4、发送请求
			req.send(null);
		}
		
		/**
		*	6、post方式提交请求
		*		1)参数：通过URL进行传递、通过send()方法进行参数传递（如果使用send()方法传递参数，需要设置请求头----Content-Type）
		*		2)中文乱码
		*			a、URL传递参数的处理方式与get方式相同
		*			b、send()方法进行参数传递，只需要在java中设置编码格式即可
		*		3)不会产生缓存
		*			
		*/
		function method6(){
			//1、获取请求处理对象
			var req = null;
			if(window.XMLHttpRequest)
				req = new XMLHttpRequest();
			else
				req = new ActiveXObject("Msxml2.XMLHTTP");
			
			//2、打开连接
			//req.open("post","serv01?name=Mike&age=20");
			//req.open("post","serv01?name=麦克&age=20");
			req.open("post", "serv01");
			
			//3、监听请求
			req.onreadystatechange = function(){
				if(req.readyState==4)
					alert("OK");
			}
			
			//4、发送请求
			//通过设置Content-type老模拟表单
			req.setRequestHeader("Content-Type", " application/x-www-form-urlencoded");
			//req.send("name=Mike&age=20");
			req.send("name=麦克&age=20");
			//req.send(null);
		}
		
		/**
		*	7、处理服务器端响应----文本
		*		服务器响应数据格式：纯文本、Json格式文本、xml格式文本
		*
		*/
		function method7(){
			//1、创建请求对象
			var req = null;
			
			if(window.XMLHttpRequest)
				req = new XMLHttpRequest();
			else
				req = new ActiveXObject("Msxml2.XMLHTTP");
			
			//2、打开连接
			req.open("get", "serv01?id=20");
			
			//3、监听响应
			req.onreadystatechange = function(){
				if(req.readyState == 4)
					alert(req.responseText);
			};
			
			//4、发送请求
			req.send(null);
		}
		
		/**
		* 8、处理Json格式的文本
		*	eval()函数：执行字符串转换，可以将当前字符串转换适当类型的数据
		*/
		function method8(){
			//1、创建请求对象
			var req = null;
			if(window.XMLHttpRequest)
				req = new XMLHttpRequest();
			else
				req = new ActiveXObject("Msxml2.XMLHTTP");
			
			//2、打开连接
			req.open("get","json");
			
			//3、处理响应
			req.onreadystatechange = function(){
				if(req.readyState == 4){
					eval("u=" + req.responseText);
					alert(u + " | " + u.userId + " | " + u.userName);
				}	
			};
			
			//4、发送请求
			req.send(null);
		}
		
		
		//js中的对象
		var person={
				name	:	"Mkke",
				age		:	20,
				gender	:	true,
				grade	:	"一年一班"
		}
		
		function method9(){
			alert(person);
			alert(person.name + " | " + person.gender);
		}
	</script>
  </head>
  
  <body>
    <input type="button" value="创建对象" onclick="method1()"/>
    <input type="button" value="完整的Ajax" onclick="method2()"/>
    <input type="button" value="异步请求" onclick="method3()" /> 
    <input type="button" value="同步请求" onclick="method4()" />
    <input type="button" value="get方式提交请求" onclick="method5()"/>
    <input type="button" value="post方式提交请求" onclick="method6()"/>
    <input type="button" value="处理文本内容" onclick="method7()" />   
    <input type="button" value="处理Json内容" onclick="method8()" /> 
    <input type="button" value="使用js对象" onclick="method9()" />
    
    <form action="serv01" method="post">
    	<input type="text" name="age" />
    	<input type="submit" value="提交" />
    </form>
  </body>
</html>
