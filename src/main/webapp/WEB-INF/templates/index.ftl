<#assign base=request.contextPath />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>layui-demo</title>


<!-- 引入layui样式 -->
<link rel="stylesheet" href="${base}/js/layui/css/layui.css">
<!-- 引入zTree样式 -->
<link rel="stylesheet" href="${base}\js\zTree\css\zTreeStyle\zTreeStyle.css">

<style>

.layui-table-cell .layui-form-checkbox[lay-skin="primary"]{
     top: 50%;
     transform: translateY(-50%);
}

</style>

</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<!-- 顶部 -->
		<div class="layui-header">
			<!-- logo -->
			<div class="layui-logo">layui 后台布局</div>
			<!-- 头部区域(导航栏)（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="">控制台</a></li>
				<li class="layui-nav-item"><a href="">商品管理</a></li>
				<li class="layui-nav-item"><a href="">用户</a></li>
				<li class="layui-nav-item"><a href="javascript:;">其它系统</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">邮件管理</a>
						</dd>
						<dd>
							<a href="">消息管理</a>
						</dd>
						<dd>
							<a href="">授权管理</a>
						</dd>
					</dl></li>
			</ul>
			<!-- 右侧用户信息 -->
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="http://t.cn/RCzsdCq" class="layui-nav-img"> 贤心
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="">安全设置</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="">退了</a></li>
			</ul>
		</div>

		<!-- 左侧区域 -->
		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					 <!-- 加载动态菜单 -->
			        <#list list as m>
			        	<li class="layui-nav-item <#if m.menuID == 1>layui-nav-itemed</#if>">
				          <a class="" href="javascript:;">${m.menuText}</a>
				          <dl class="layui-nav-child">
				            <#list m.menuList as m2>
								<#if m2.menuType == 'tree' >
				            	<dd><a href="javascript:skip_page('${base}/${m2.menuHref!}')">${m2.menuText}</a></dd>
								</#if>
				            </#list>
				          </dl>
				        </li>
			        </#list>
				</ul>
			</div>
		</div>

		<!-- 主体区域 -->
		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div id="index_body_content" style="padding: 15px;">内容主体区域</div>
		</div>

		<!-- 底部 -->
		<div class="layui-footer">
			<!-- 底部固定区域 -->
			© layui.com - 底部固定区域
		</div>

	</div>
<!-- 引入jquery资源库 -->
<script type="text/javascript" src="${base}/js/jquery.min.js"></script>
<!-- 引入layui资源库 -->
<script type="text/javascript" src="${base}/js/layui/layui.all.js"></script>
<#-- 引入zTree资源库 -->
<script type="text/javascript" src="${base}\js\zTree\js\jquery.ztree.all.js"></script>

<!-- 代码区 -->
<script>
	function skip_page(url){
	    $.ajax({
	        url:url,
	        success:function (data) {
	            $("#index_body_content").html(data);  //请求的界面数据在右侧显示
	        }
	    });
    }
</script>

</body>
</html>