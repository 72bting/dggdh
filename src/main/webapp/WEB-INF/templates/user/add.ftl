<#assign base = request.getContextPath() />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加角色</title>
</head>
<body>

	<!-- from只是个容器 如果不想用form 可以换成任何一个普通元素 -->
	<form id="user_add_form" class="layui-form" style="padding:10px">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                	<input type="text" id="userAcc" name="userAccount" autocomplete="off"
					   class="layui-input"  lay-verify="username"  placeholder="请输入用户名">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-form-label">密码</div>
            <div class="layui-input-block">
                <input type="password" name="userPwd" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
        </div>
	</form>


</body>
</html>