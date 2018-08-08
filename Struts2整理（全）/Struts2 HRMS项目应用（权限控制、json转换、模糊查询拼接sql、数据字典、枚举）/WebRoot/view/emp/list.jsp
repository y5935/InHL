<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="./css/x-admin.css" media="all">
	<link rel="stylesheet" href="css/pag.css" media="all">
	<script src="js/jquery2.js" charset="utf-8"></script> 
	
	<script type="text/javascript">
		$(function(){
			$.post("emp/list.action",{"pager.index":"0"},function(data){
				loadData(data);
			},"json");
			
			$("#btnFind").bind("click",function(){
				//获取查询条件
				var name=$("#name").val();
				var dept=$("#dept").val();
				
				
				
				$.post("emp/find.action",{"emp.empName":name,"emp.DeptId":dept},function(data){
					alert(data + " | " + data.length);
				},"json");
			});
		});
		
		/**
		* 按Id删除数据
		*/
		function del(id){
			$.post("emp/del.action",{"emp.empId":id},function(data){
				loadData(data);
			});
		}
		
		/**
		*加载数据
		*/
		function loadData(data){
			//判断data是否有效
			if(data== undefined || data == null) return;
			
			if(data.length >0){
				//获取pager对象
				var pager = data[0];
				
				//判断data参数中的data属性是否有效
				if(pager.data.length<1) return;
				
				$("tbody").html("");
				//获取data参数中的data属性值
				var list = pager.data;
				//对pager.data中的数据进行遍历
				for(var i = 0;i<list.length;i++){
					var obj = list[i];
					var tr = "<tr><td><input type='checkbox' value='"+obj.empId+"' name='selected'></td>";
					tr += "<td>"+obj.empName+"</td><td>"+obj.gender+"</td><td >"+obj.deptId+"</td>";
					tr += "<td >"+obj.positionId+"</td><td > "+obj.education+"</td>";
					tr += "<td> "+obj.degree+"</td><td>"+obj.state+"</td>";
			        tr += "<td><a href='#'>浏览</a><a href='#'>修改</a><a href='javascript:void(0)' onclick='del("+obj.empId+")'>删除</a></td></tr>";
			      
			        $("tbody").append(tr);
				}
			}
			
			//显示总记录数
			//判断是否需要修改总记录数的显示
			//如果总记录数没有发生改变泽不需要修改
			if(pager.rows != $("#rows").text){
				//设置总记录数的显是数据
				$("#rows").text(pager.rows);
				
				//设置分页
				$("#page").append("<span class='jump'>上一页</span> ");
				for(var i =0;i<pager.pageCount;i++){
					$("#page").append("<span class='jump'>"+(i+1)+"</span> ");
				}
				$("#page").append("<span class='jump'>下一页</span> ");
			}
		}
	</script>

</head>
<body>
	<div class="x-nav"> 
		<span class="layui-breadcrumb"> 
			<a><cite>首页</cite></a> <a><cite>档案管理</cite></a> 
		</span> 
		<a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新">
			<i class="layui-icon" style="line-height:30px">ဂ</i>
		</a> 
	</div>
	
<div class="x-body">
  <form class="layui-form x-center" action="" style="width:85%">
    <div class="layui-form-pane">
      <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-inline" style="width:100px">
          <input type="text" id="name"  placeholder="姓名" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">部门</label>
        <div class="layui-input-inline" style="width:150px">
          <input type="text" id="dept"  placeholder="所属部门" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-input-inline" style="width:80px">
          <button class="layui-btn"  lay-submit="" lay-filter="*"  id="btnFind">搜索</button>
        </div>
      </div>
    </div>
  </form>

		<div class="tools">
			<ul class="toolbar">
				<li><span><img src="images/t03.png" /></span>批量删除</li>
				<li
					onclick="user_management_add('添加用户','view/emp/add.jsp','1000','500')"><span><img
						src="images/t01.png" /></span>添加</li>
				<li
					onclick="user_management_edit('用户编辑','Dangan-edit.html','600','500')"><span><img
						src="images/t02.png" /></span>编辑</li>
				<li
					onclick="user_management_show('用户查看','Dangan-look.html','600','500')"><span><img
						src="images/t06.png" /></span>查看</li>
			</ul>
			<span class="x-right" style="line-height:25px">共有数据：<span id="rows"></span>条</span>
			</xblock>
		</div>
<table class="tablelist">
    <thead>
      <tr>
        <th> <input onclick="selectAll()" type="checkbox"   name="controlAll" style="controlAll" id="controlAll">
        </th>
        <th>姓名</th>
        <th>性别</th>
        <th>所属部门</th>
        <th>职位</th>
        <th>学历</th>
        <th>学位 </th>
        <th>状态</th>
        <th> 操作 </th>
      </tr>
    </thead>
    <tbody>
    </tbody>
  </table>
  
     <div class="page"  v-show="show">
  <div class="pagelist" id="page"></div>
</div>
</div>

<br />
<br />
<br />
<script src="./lib/layui/layui.js" charset="utf-8"></script> 
<script src="./js/x-layui.js" charset="utf-8"></script> 

<script src="js/js.js" charset="utf-8"></script>
<script>
            layui.use(['laydate','element','laypage','layer'], function(){
                $ = layui.jquery;
              lement = layui.element();//面包导航
              laypage = layui.laypage;//分页
              layer = layui.layer;//弹出层

            });
             /*用户-添加*/
            function user_management_add(title,url,w,h){
                x_admin_show(title,url,w,h);
            }
            /*用户-查看*/
            function user_management_show(title,url,w,h){
                x_admin_show(title,url,w,h);
            }
            // 用户-编辑
            function user_management_edit (title,url,w,h) {
                x_admin_show(title,url,w,h); 
            }
            </script> 
<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

	
</body>
</html>