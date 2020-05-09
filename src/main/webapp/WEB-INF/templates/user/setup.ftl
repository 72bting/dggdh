<#assign base=request.contextPath />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单设置</title>
</head>

<body>

    <form class="layui-form">
        <div class="layui-form-item">
            <label class="layui-form-label">选择角色</label>
            <div class="layui-input-block">
                    <#list list as role>
                        <input type="checkbox" name="user_setup_role_name" value="${role.roleID}" title="${role.roleName}"
                        <#if role.checked>checked</#if>>
                    </#list>
            </div>
        </div>
    </form>

    <script>
        var form = layui.form;
        form.render();

    </script>

</body>

</html>