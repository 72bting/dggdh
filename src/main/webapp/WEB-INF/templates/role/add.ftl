<#assign base = request.getContextPath() />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加角色</title>
</head>
<body>

	<!-- from只是个容器 如果不想用form 可以换成任何一个普通元素 -->
	<form id="role_add_form" class="layui-form" style="padding:10px">
	 	<div class="layui-form-item">
			<div class="layui-form-label">角色名称</div>
			<div class="layui-input-block">
				<input name="roleName" placeholder="请输入" autocomplete="off" class="layui-input">
			</div>
		</div>
	</form>

</body>
</html>