<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'menu.jsp' starting page</title>
    

	<link rel="stylesheet" type="text/css" href="css/public.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/public.js"></script>
	
	<script type="text/javascript">
		$(function(){
			$.post("res/nav.action",function(data){
				//判断返回结果是否有效,如果无效则直接返回
				if(data.length<1) return;
				
				//循环遍历返回结果
				var content = "";
				for(var i = 0;i<data.length;i++){
					var obj = data[i];
					content = "<dl class='system_log'>";
					content += "<dt><img class='icon2' src='"+obj.icon+"' />" + obj.title + "</dt>"; 
					
					//获取当前对象的childList属性
					var child = obj.childList;
					//判断childList属性是否有效，如果无效则continue
					if(child== undefined || child == null || child.length <1)
						continue;
					
					//遍历child集合对象
					for(var j = 0;j<child.length;j++){
						//获取集合中的元素
						var c = child[j];
						
						content += "<dd>";
						if(c.icon.length>0)
							content += " <img class='coin22' src='"+c.icon+ "' /> ";
						content += "<a href='"+c.url+"' target='main' class='cks'>"+c.title+"</a></dd>";
					}
					
					content += "</dl>";
					
					//alert(content);
					$("#content").append(content);	
				}
				//alert(content);
			},"json");
			
			//alert($("#content").html());
		});
		
	</script>
	
	
  </head>

<body id="bg">
	<!-- 左边节点 -->
	<div class="container">
		<div class="leftsidebar_box" id="content">
			<a href="main.html" target="main">
				<div class="line">
					<img class="icon1" src="images/coin01.png" /> 
					<img class="icon2" src="images/coin02.png" />&nbsp;&nbsp;首页
				</div>
			</a>
		</div>
	</div>
</body>
</html>
