<#assign base=request.contextPath />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login-page</title>

<!-- 引入jquery -->
<script type="text/javascript" src="${base}/js/jquery.min.js"></script>
<!-- css -->
<link rel="stylesheet" href="${base}/js/layui/css/layui.css">

<style>

.layui-table-cell .layui-form-checkbox[lay-skin="primary"]{
     top: 50%;
     transform: translateY(-50%);
}

</style>

</head>
<body >

	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
		<legend>登录页</legend>
	</fieldset>
	
	<div style="padding: 20px; background-color: #F2F2F2;">
		<div class="layui-row layui-col-space15">
			<div class="layui-col-md6">
				<div class="layui-card">
					<#--<div class="layui-card-header">卡片面板</div>-->
					<div class="layui-card-body">
					   <form class="layui-form layui-form-pane">
						   <div class="layui-form-item">
							   <label class="layui-form-label">用户名</label>
							   <div class="layui-input-block">
								   <input id="login_user_account" type="text" name="title" autocomplete="off" placeholder="请输入用户名" class="layui-input">
							   </div>
						   </div>
						   <div class="layui-form-item">
							   <label class="layui-form-label">密码</label>
							   <div class="layui-input-block">
								   <input id="login_user_pwd" type="password" name="title" autocomplete="off" placeholder="请输入密码" class="layui-input">
							   </div>
						   </div>

                           <div class="layui-form-item">
							   <label>验证码</label><br/>
							   <input type="text" id="randomCode"/><img title="点击更换" onclick="javascript:refresh(this);" autocomplete="off" src="imageServlet"><br/>
						   </div>

						   <div class="layui-form-item">
							  <a href="javascript:login()" class="layui-btn">登录</a>
						   </div>
					   </form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- layui -->
	<script type="text/javascript" src="${base}/js/layui/layui.all.js"></script>

	<script>

		//刷新验证码
        function refresh(obj) {
            obj.src = "imageServlet?"+Math.random();
        }

        //登陆
        function login() {
            $.ajax({
                url:"${base}/login",
                data:{userAccount:$("#login_user_account").val(), userPwd:$("#login_user_pwd").val(),randomCode:$("#randomCode").val()},
                success:function(data) {
                    //判断登陆结果
                    if (null != data && 1 == data.code) {
                        //登陆成功，跳转到index主页
                        location.href= "${base}/";
                    } else if (0 == data.code){
                        layer.alert("用户名或密码错误")
					}else {
                        layer.alert("验证码错误")
                    }
                }
            });
        }


	</script>

</body>
</html>