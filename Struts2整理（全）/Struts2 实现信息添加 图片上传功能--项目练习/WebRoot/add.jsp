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

	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	<script type="text/javascript">
		//执行输入验证
		function check(){
			//验证姓名（必填且最小长度为6）
			//全部由英文字母组成，最小6个长度，最大20个长度
			var reg = /[a-zA-Z]{6,20}/;
			if(!reg.test($("#name").val())){
				alert($("#name").attr("msg"));	
			}
			
			//验证电话号码
			//手机号码
			reg = /^(1[3456789])[0-9]{9}$/;
			if(!reg.test($("#tel").val())){
				alert($("#tel").attr("msg"));
			}
			//座机号码
			
			

			return false;
		}
	</script>
  </head>
  
  <body>
    <form action="user/add.action" method="post" enctype="multipart/form-data" onsubmit="return check();">
    	<table>
    		<tr>
    			<th>姓名：</th>
    			<!-- 扩展了标签：msg，用于存储提示消息内容 -->
    			<td><input type="text" name="name" id="name" msg="姓名的最小长度为6个字符"/></td>
    		</tr>
    		<tr>
    			<th>性别：</th>
    			<td>
    				<input type="radio" name="gender" value="true" checked="checked"/>男
    				<input type="radio" name="gender" value="false"/>女
    			</td>
    		</tr>
    		<tr>
    			<th>年龄：</th>
    			<td><input type="text" name="age" /></td>
    		</tr>
    		<tr>
    			<th>联系电话：</th>
    			<td><input type="text" name="tel" id="tel" msg="电话号码格式不正确" /></td>
    		</tr>
    		<tr>
    			<th>身份证号码：</th>
    			<td><input type="text" name="idCard" /></td>
    		</tr>    		
    		<tr>
    			<th>照片：</th>
    			<td><input type="file" name="file" /></td>
    		</tr>
    		<tr>
    			<th>家庭住址：</th>
    			<td><input type="text" name="address" /></td>
    		</tr>
    		<tr>
    			<td>
    				<input type="submit" value="提交" />
    			</td>
    		</tr>    		    		
    	</table>
    </form>
  </body>
</html>
