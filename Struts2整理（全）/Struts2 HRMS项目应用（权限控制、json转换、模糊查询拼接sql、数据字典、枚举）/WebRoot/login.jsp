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

	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="js/jquery2.js"></script>
	<script src="js/cloud.js" type="text/javascript"></script>
	<script language="javascript" src="js/js.js"></script>
	
	<script type="text/javascript">
		$(function(){
			$("#btn").click(function(){
				var account = $("#account").val();
				var pwd = $("#pwd").val();
				
				//1、验证用户名和密码是否为空
				if(account.length ==0){
					alert("账号不能为空!");
					return;
				}
				
				if(pwd.length==0){
					alert("密码不能为空!");
					return;
				}
				
				//2、通过Ajax执行登录验证（将请求发送给后台）
				$.post("user/login.action",{"user.account":account,"user.pwd":pwd},function(data){
					if(data==0)
						alert("用户名不存在或已冻结！！！");
					else if(data==1)
						alert("密码错误，请重新输入！！！");
					else
						location.href="index.jsp";
				});
			});
		});
	</script>
</head>

<body
	style="background-color:#1c77ac; background-image: url(images/light.png) background-repeat:no-repeat; background-position:center top; overflow:hidden;">
	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>
	<div class="logintop">
		<span>欢迎登录心理诊断后台</span>
		<ul>
			<li><a href="#">返回首页</a></li>
		</ul>
	</div>
	<div class="loginbody">
		<span class="systemlogo"></span>
		<div class="loginbox">
			<ul>
				<li>
					<input name="account" id="account" type="text" class="loginuser" value="XuZhi" onclick="JavaScript:this.value=''" />
				</li>
				<li>
					<input name="pwd" id="pwd" type="text" class="loginpwd" value="123" onclick="JavaScript:this.value=''" />
				</li>
				<li>
					<input name="code" type="text" class="loginy" placeholder="输入验证码" /><label><img src="images/images.jpg" /></label>
				</li>
				<li>
					<input id="btn" type="button" class="loginbtn" value="登录" />
				</li>
			</ul>
		</div>
	</div>
	<div class="loginbm">版权所有： 阳光心健 © Copyright 2014 - 2015.</div>
</body>
</html>
