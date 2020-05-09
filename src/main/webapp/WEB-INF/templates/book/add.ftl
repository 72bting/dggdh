<#assign base = request.getContextPath() />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加书籍</title>
</head>
<body>

	<!-- from只是个容器 如果不想用form 可以换成任何一个普通元素 -->
	<form id="book_add_form" class="layui-form" style="padding:10px">
	 
	 	<div class="layui-form-item">
			<div class="layui-form-label">书籍名称</div>
			<div class="layui-input-block">
				<input name="bookName" placeholder="请输入" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-form-label">书籍作者</div>
			<div class="layui-input-block">
				<input name="bookAuthor" placeholder="请输入" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-form-label">书籍类型</div>
			<div class="layui-input-block">
				<input type="radio" name="bookType" value="1" title="悬疑" >
				<input type="radio" name="bookType" value="2" title="恐怖" >
				<input type="radio" name="bookType" value="3" title="推理" >
				<input type="radio" name="bookType" value="4" title="寓言" >
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-form-label">书籍价格</div>
			<div class="layui-input-block">
				<input name="bookPrice" placeholder="￥" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-form-label">书籍描述</div>
			<div class="layui-input-block">
				<textarea name="bookDesc" placeholder="请输入" autocomplete="off" class="layui-textarea"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-form-label">书籍日期</div>
			<div class="layui-input-block">
				<input name="bookDateStr" id="book_date" autocomplete="off" class="layui-input">
			</div>
		</div>
	</form>
	<script>
		//获取form组件
		var book_add_form = layui.form;
		//获取时间组件
		var book_add_date = layui.laydate;
		//渲染form样式
		book_add_form.render();
		//渲染日期
		book_add_date.render({
		    elem: '#book_date',
		    trigger:'click' //解决日期点击闪退
		});
	</script>
</body>
</html>