window.onload = function(){
/*
	//1、Jquery的使用
	//方式1：通过$使用Jquery，推荐使用
	alert($("div"));
	
	//方式2：通过jQuery关键字使用jquery
	alert(jQuery("div"));
	
	//方式3：通过window.$使用jquery
	alert(window.$("div"));
*/

/*
	//2、使用Jquery获取表单元素
	//1)、常用方式
	//a、按照标签名称获取表单元素
	//$("元素名称")
	alert($("div"));
	
	//b、按照Id获取表单元素
	//$("#元素Id")
	alert($("#divContent"));
	
	//c、按照class的属性值获取表单元素
	//$(".class属性名")
	alert($(".red") + " | " +$(".red").length);

	//2)、层级方式
	//a、匹配所有子元素(直接子元素 + 间接子元素)
	//$("父元素  子元素")
	alert($("#divContent *"));
	
	//b、匹配所有的直接子元素
	//$("父元素>子元素")
	alert($("#divContent>*").length);
	
	//c、匹配其后相邻的第一个兄弟元素
	alert($("#child1+p").text());
	//d、匹配其后所有的兄弟元素
	alert($("#child1~p").text());

 	//3)、获取指定集合元素
	//a)、first()	：获取元素集合中的第一个元素	
	alert($("#d2 input").first().val());
	
	//b)、last()	：获取元素集合中的最后一个元素
	//alert($("#d2 input").last().val());
	alert($("#d2 input:last()").val());
	
	//c)、匹配不包含指定属性值的所有元素
	alert($("#d2 input:not(:checked)").length);
	
	//4)、其他常用方法
	//gt()		：获取索引值大于指定数值的元素
	//lt()		：获取索引值小于执行数值的元素
	//eq()		：获取指定索引值的元素
	//odd()		：获取索引值为奇数的元素
	//even()	：获取索引值为偶数的元素(索引值从0开始)

 	//5)、按内容进行元素查找
	//a)、contains()：标签内容中是否包含指定的值
	alert($("#divContent *:contains('div2')").length);
	//b)、empty		：查找所有不包含子元素的元素
	alert($("#divContent>*:empty").length);

 	//6)、按照可见性进行元素查找
	//a)、hidden	：获取所有隐藏的元素集合
 	alert($("#d2 input:hidden").length);
 	//b)、visible	：获取所有显示的元素集合
 	alert($("#d2 input:visible").length);

 	//7)、按照属性值进行查找
	//a)、[属性名]	：获取所有应用指定属性的所有元素集合
 	alert($("div[id]").length);
 	//b)、[属性名=值]：获取所有属性值为指定值得所有元素集合
	alert($("div[class='blue']").length);
	//c)、[属性名!=值]：获取所有属性值不等于指定值得所有元素集合
	alert($("div[class!='blue']").length);
	//d)、[属性名^=值]：获取给定的属性是以某些值开始的元素
	alert($("div[class^='b']").length);

	//8)、查找指定类型的表单元素
	////a)、获取form表单中所有指定类型的元素
	alert($(":text").length);
*/

/*
 	练习1：
	表单元素中包含4个元素,其中2一个输入文本框,
	1密码文本框1一个复选框
	通过jquery查找出所有密码框的个数

	alert($("form>input[type=password]").length);
*/	

/*
	//3、获取元素的内容(或标签的内容)
	//1)、html内容
	//a)、html()	：取得第一个匹配元素的html内容
	alert($("#divContent").html());
	//b)、html(val)	：设置每一个匹配元素的html内容。
	$("#divContent").html("abc");
	//c)、通过函数设置每一个匹配元素的html内容
	//参数1	：元素的索引值
	//参数2	：元素的现有html值
	$("div").html(function(idx,val){
		alert(idx + " | " + val);
	});

	//2)、text内容
	//a)、text()		:取得所有匹配元素的内容。
	alert($("#divContent").text());
	//b)、text(val)	:设置所有匹配元素的文本内容
	$("#divContent").text("abc");
	//c)、设置所有匹配元素的文本内容
	//参数1	：元素的索引值
	//参数2	：元素的现有html值
	$("div").text(function(idx,val){
		alert(idx + " | " + val);
	});
	
	//3)、val内容
	//a)、val()		:获取元素的value值
	alert($("#pwd").val());
	//b)、val(val)	:设置元素的value值
	$("#pwd").val('123');
	//c)、设置每一个匹配元素的值。
	$("form>input").text(function(idx,val){
		alert(idx + " | " + val);
	});
*/

/*
	//4、获取元素属性
	//1)、attr()		：取得第一个匹配元素的属性值。
	alert($("#divContent").attr('name'));
	//2)、attr(key,value)	：为所有匹配的元素设置一个属性值
	//jquery支持级联写法进行属性值的定义
	$("#photo").attr("src","img/1.jpg").attr("style","border:solid 1px red;");
	//3)、attr(properties)	：为所有匹配的元素设置一个属性。
	//同时可以设置多个属性	
	$("#photo").attr({"src":"img/1.jpg","style":"border:solid 1px blue"});
	//4)、attr(key,function()):为所有匹配的元素设置一个计算的属性值。
	$("#photo").attr("src",function(){
		var i = 96;
		
		if(i%35 ==0)
			return 'img/1.jpg';
		else
			return 'img/2.jpg';
	});
	//removeAttr(属性名)	:从每一个匹配的元素中删除一个属性
	$("#photo").removeAttr("src").removeAttr("style");
*/

/*
 	//5、操作class属性
	//1)、.addClass()	：为每个匹配的元素添加指定的类名
	$("#p1").addClass("green_color blue_bg red_border");
	$("#p1").addClass("green_color").addClass("blue_bg").addClass("red_border");
	//2)、removeClass()	：从所有匹配的元素中删除全部或者指定的类
	$("#p1").removeClass("blue_bg");
	//3)、toggleClass()	：以开关的方式添加或移除指定class的值
	$("#p1").toggleClass("blue_bg");
*/

/*
	练习2:
	实现table表格的各行变色.要求
		奇数行:桔色背景,蓝色字体;
		偶数:灰色背景,白色字体
	$("#grid tr:even").addClass("even");
	$("#grid tr:odd").addClass("odd");
*/

/*
	//6、文档处理
	//1)、内部插入(插入子元素)
	//a、append()	：向每个匹配的元素内部追加内容。
	//添加文本标签
	$("#child1").append("abc");
	//添加Html标签
	$("#child1").append("<a href='http://www.baidu.com'>百度</a>");

	//b、appendTo()	：把所有匹配的元素追加到另一个指定的元素元素集合中
	//元素在原位置上会消失(剪切操作)
	$("form>input").appendTo("#child1");

	//c、prepend()	：向每个匹配的元素子元素集合的前面插入新的内容
	$("#child1").prepend("abc");
	//d、prepend()	：把所有匹配的元素插入到另一个指定的元素元素集合中
	$("form>input").prependTo("#child1");
	
	//2)、外部插入(插入兄弟元素)
	//a、after()		：在每个匹配的元素之后插入内容
	$("#child1").after("hello2");
	//before()		：在每个匹配的元素之前插入内容
	$("#child1").before("hello1");

	//3)、包裹(添加父元素)
	//a、wrap()		：把所有匹配的元素用其他元素的结构化标记包裹起来
	//通过html代码生成一个元素并且对目标元素进行包裹
	$("#child1").wrap("<div id='wp'></div>");
	//测试wp元素的所有内部内容
	//alert($("#wp").html());
	//为wp元素设置style风格
	$("#wp").attr("style","border:solid 2px red;height:200px;width:200px");

	//使用现有元素对指定元素进行包裹
	$("#child1").wrap($("#d2"));
	
	//b、unwrap()	：移除外层包裹的元素
	$("#txt").unwrap();
	
	//4)、替换
	//a、replaceWith()：将所有匹配的元素用特定的标签进行替换
	$("form>input").replaceWith("<a>替换后</a>");

	//5)、删除子元素
	//a、empty()		：删除指定元素的所有子元素
	$("form").empty();
	//b、remove()	：移除所有匹配的元素对象
	$("form").remove();
	//c、detach()	：移除所有匹配的元素对象
	$("form").detach();

	//6、元素复制
	//a、clone()		：复制匹配的元素
	$("#divContent").clone().appendTo("#d3");
*/	

/*
	//7、位置与大小
	//1)、位置
	//a、offset()		：获取匹配元素与当前可视窗口的偏移距离(得到一个对象)
	alert($("#divContent").offset().left + " y:" + $("#divContent").offset().top);

	//b、offset(属性值)	：设置匹配元素与当前可视窗口的偏移距离
	$("#divContent").offset({left:200,top:100})

	//c、scrollTop()		：获取匹配元素相对于滚动条顶部的距离
	//scrollLeft():获取匹配元素相对于水平滚动条左侧的距离
	alert($("#divContent").scrollTop());

	//2)、尺寸
	//a、height()		：获取匹配元素的高度
	alert($("#divContent").height());
	//$(window)表示获取window窗口的高度
	alert($(window).height());

	//b、height(val)		：设置匹配元素的高度
	$("#divContent").height(500);

	//c、innerHeight()	:获取匹配元素的内部高度(不包含边框等高度)
	alert($("#divContent").innerHeight());
	


	//8、效果
	//1)、基本效果
	alert("ok");
	//a、show()			：将匹配的隐藏元素进行显示
	$("#d4").show();
	//b、show(speed)		：将匹配元素以指定的速度进行显示
	$("#d4").show(2000);
	//c、hide()			：将匹配的显示元素进行隐藏
	$("#d4").hide();
	//d、hide(speed)		：将匹配元素以指定的速度进行隐藏
	$("#d4").hide(2000);

	//e、toggle()		:切换元素的可见状态。
	$("#d4").toggle();
	$("#d4").toggle();

	//2)、滑动
	//a
	//a、slideUp()			：将匹配的元素向上折叠滑动
	$("#d5").slideUp(2000);
	//b、slideDown()			：将匹配的元素向下展开滑动
	$("#d5").slideDown(2000);


	//3)、淡入淡出
	//a、fadeOut()			:通过不透明度的变化来实现所有匹配元素的淡出效果
	$("#d5").fadeOut(2000);
	//a、fadeIn()			:通过不透明度的变化来实现所有匹配元素的淡入效果
	$("#d5").fadeIn(2000);
*/	
}


/*
	//9、事件 
	//1)、页面加载事件
	//页面加载顺序：从上向下进行加载
	//Js:window.onload()
	//jquery：$(document).ready()
	//ready()	:dom文档加载结束后被执行
	$(document).ready(function(){
		alert("ready()事件被调用了");
	});
	


	$(document).ready(function(){
		//2)、常用事件
		//a、click()		:鼠标单击时触发
		$("#btn").click(function(){
			alert("btn的click事件被执行了......");
		});
		
		//b、focus()		：得到焦点时触发
		$("#pwd").focus(function(){
			//alert("pwd的focus事件被执行了......");
			$("#pwd").addClass("red_border");
		});
		
		//c、blur()		：丢失焦点时触发
		$("#pwd").blur(function(){
			$("#pwd").removeClass("red_border");
		});
	});
	
	//3)、事件绑定方式
	//a、在html代码中进行绑定
	function btn_click(){
		alert("btn按钮的click事件被执行了......");
	}
	
	
	$(document).ready(function(){
		//b、通过代码进行绑定
		$("#btn").click(function(){
			alert("btn按钮的click事件被执行了......2");
		});
		
		//c、通过bind方法进行绑定
		$("#btn").bind("click",function(){
			alert("btn按钮的click事件被执行了......3");
		});
		
		//d、绑定一个只能执行1次的事件
		$("#btn").one("click",function(){
			alert("btn按钮的click事件被执行了......4");
		});
		//e、解除指定事件的绑定关系
		$("#btn").unbind("click");
		//f、为指定对象绑定一个事件
		//bind()只能为已经加载的对象进行事件绑定
		//live()可以为晚加载的对象进行事件绑定
		$("#btn").live("click",function(){
			alert("btn按钮的click事件被执行了......5");
		});
		//g、解除live事件绑定的事件
		$("#btn").die("click");
	});

*/

/*
页面中定义一个文本输入框,需求如下:
	1 输入框的默认内容为:三八女王节
	2 输入框得到焦点时清空文本框内容
	3 当文本框失去焦点,如果用户已经输入数据则保留用户的输入
		否则恢复为"三八女王节"
*/
	$(document).ready(function(){
		//存储文本框默认字符串内容
		var key = "三八女王节";
		//初始化keyWord文本框内容
		$("#keyWord").val(key);
		
		//绑定得到焦点事件
		$("#keyWord").focus(function(){
			if($("#keyWord").val() == key)
				$("#keyWord").val("");
		});
		
		//绑定失去焦点事件
		$("#keyWord").blur(function(){
			var val = $("#keyWord").val().trim();
			if(val.length == 0)
				$("#keyWord").val(key);
		});
	});

