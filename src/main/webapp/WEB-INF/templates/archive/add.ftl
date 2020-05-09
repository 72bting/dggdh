<#assign base = request.getContextPath() />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加档案</title>
</head>
<body>

	<!-- from只是个容器 如果不想用form 可以换成任何一个普通元素 -->
	<form id="archive_add_form" class="layui-form" style="padding:10px">
	 
	 	<div class="layui-form-item">
			<div class="layui-form-label">档案标题</div>
			<div class="layui-input-block">
				<input name="archiveTitle" placeholder="请输入" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-form-label">建档人</div>
			<div class="layui-input-block">
				<input name="archiveName" placeholder="请输入" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-form-label">档案类型</div>
			<div class="layui-input-block">
				<input type="radio" name="archiveType" value="1" title="文件" >
				<input type="radio" name="archiveType" value="2" title="建筑" >
				<input type="radio" name="archiveType" value="3" title="职位" >
				<input type="radio" name="archiveType" value="4" title="实物" >
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-form-label">建档日期</div>
			<div class="layui-input-block">
				<input name="archiveDateStr" id="archive_date" autocomplete="off" class="layui-input">
			</div>
		</div>
	</form>
	<script>
		//获取form组件
		var archive_add_form = layui.form;
		//获取时间组件
		var archive_add_date = layui.laydate;
		//渲染form样式
        archive_add_form.render();
		//渲染日期
        archive_add_date.render({
		    elem: '#archive_date',
		    trigger:'click' //解决日期点击闪退
		});
	</script>
</body>
</html>