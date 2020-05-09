<#assign base = request.getContextPath() />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>tree_add</title>
</head>
<body>

	<form id="edit_tree_form" class="layui-form layui-form-pane">
		<#-- 把pid放进隐藏域 -->
        <input type="hidden" name="id" value="${tree.id}">
		<input type="hidden" name="pid" value="${tree.pid}">


        <div class="layui-form-item">
            <div class="layui-form-label">菜单名称</div>
            <div class="layui-input-inline">
                <input value="${tree.name}" name="name" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-form-label">访问路径</div>
            <div class="layui-input-inline">
                <input value="${tree.href!}" name="href" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-form-label">菜单类型</div>
            <div class="layui-input-inline">
                <input type="radio" name="type" value='tree'
                       <#if tree.type == 'tree'>checked</#if>>树
                <input type="radio" name="type" value='menu'
                       <#if tree.type == 'menu'>checked</#if>>菜单
            </div>
        </div>

	</form>

</body>
</html>