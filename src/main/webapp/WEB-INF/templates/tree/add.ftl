<#assign base = request.getContextPath() />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>tree_add</title>
</head>
<body>

	<form id="add_tree_form" class="layui-form layui-form-pane">
		<#-- 把pid放进隐藏域 -->
		<input type="hidden" name="pid" value="${tree.pid}">

        <div class="layui-form-item">
            <div class="layui-form-label">菜单名称</div>
            <div class="layui-input-inline">
                <input name="name" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-form-label">访问路径</div>
            <div class="layui-input-inline">
                <input name="href" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-form-label">菜单类型</div>
            <div class="layui-input-inline">
                <input type="radio" name="type" value="tree" title="树" checked>
                <input type="radio" name="type" value="menu" title="菜单">
            </div>
        </div>
	</form>

    <script>
        //渲染表单样式
        layui.form.render();
    </script>
</body>
</html>