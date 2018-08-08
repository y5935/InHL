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
	<link rel="stylesheet" href="./css/x-admin.css" media="all">
	<script type="text/javascript" src="js/jquery2.js"></script>
	<script type="text/javascript" src="lib/laydate/laydate.js"></script>
	<script type="text/javascript">
		$(function(){
			//加载部门数据
			$.post("dic/list.action",{"sort":"DEPARTMENT"},function(data){
				bindList(data,$("#dept"));
			},"json");
			
			$.post("dic/list.action",{"sort":"EDUCATION"},function(data){
				bindList(data,$("#education"));
			},"json");
			
			$.post("dic/list.action",{"sort":"DEGREE"},function(data){
				bindList(data,$("#degree"));
			},"json");
			
			$.post("dic/list.action",{"sort":"POSITION"},function(data){
				bindList(data,$("#position"));
			},"json");
			
			//日历
			laydate.render({
				elem: '#birthDay' //指定元素
			});
			
			$("#btnSave").bind("click",function(){			
				//获取待提交数据
				var name = $("#empName").val();
				var gender = $("#gender").val();
				var dept = $("#dept").val();
				var position = $("#positon").val();
				var degree=$("#degree").val();
				var education = $("#education").val();
				var state = $("#state").val();
				
				var obj = {
						"emp.empName":name,
						"emp.gender":gender,
						"emp.deptId":dept,
						"emp.positionId":position,
						"emp.education":education,
						"emp.degree":degree,
						"emp.state" : state
					}
				//通过Ajax将数据传递给后台
				$.post("emp/add.action",obj,function(data){
					
				});
			});
		});
		
		function bindList(data,obj){
			if(obj != undefined)
				obj[0].options.add(new Option("---请选择---",-1));
			
			if(data.length >0){
				for(var i = 0;i<data.length;i++){
					var d = data[i];
					obj[0].options.add(new Option(d.title,d.dicId));
				}	
			}
		}
	</script>
</head>

<div class="x-body">
	<table class="layui-table">
		<tbody>
			<tr>
				<td><span class="x-red">*</span>姓名：</td>
				<td>
					<input type="text" id="empName" class="layui-input">
				</td>
				<td>性别：</td>
				<td>
					<select lay-verify="required" id="gender" class="layui-input">
						<option value="1">男</option>
						<option value="0">女</option>
					</select>
				</td>
				<td>出生日期：</td>
				<td>
					<input type="text" id="birthDay" class="layui-input">
				</td>
			</tr>
			<tr>
				<td>所属部门：</td>
				<td>
					<select lay-verify="required" id="dept" class="layui-input"></select>
				</td>
				<td>职位：</td>
				<td>
					<select lay-verify="required" id="position" class="layui-input"></select>
				</td>
				<td>学历：</td>
				<td>
					<select lay-verify="required" id="education" class="layui-input"></select>
				</td>
			</tr>
			<tr>
				<td>学位：</td>
				<td>
					<select lay-verify="required" id="degree" class="layui-input"></select>
				</td>
				<td>状态：</td>
				<td colspan="3">
					<select lay-verify="required" id="state" class="layui-input">
						<option value="12">在职</option>
						<option value="13">离职</option>
						<option value="14">退休</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="6" align="right">
					<button class="layui-btn" id="btnSave">保存</button>
					<button class="layui-btn" >取消</button>
				</td>
			</tr>
		</tbody>
	</table>
</div>
<script src="./lib/layui/layui.js" charset="utf-8">
        </script>
<script src="./js/x-layui.js" charset="utf-8">
        </script>
<script>
            layui.use(['form','layer'], function(){
                $ = layui.jquery;
              var form = layui.form()
              ,layer = layui.layer;
            });
        </script>
</body>
</html>
