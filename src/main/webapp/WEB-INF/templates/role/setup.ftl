<#assign base=request.contextPath />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单设置</title>
</head>

<body>

	<#-- 放置树的容器 -->
    <ul id="setup_menu_tree"  class="ztree"></ul>

	<script>

		//初始化树
		var settings = {
            check: {
                enable: true//开启节点复选框
            },
            data: {
                simpleData: {
                    enable: true,
                    idKey: "id",
                    pIdKey: "pid",
                    rootPId: 0
                }
            },
			async: {
				enable: true,//如果动态加载就设置为true
				url: "${base}/tree/setupTree",
				otherParam:{roleID:"${role.roleID}"}//查询时的参数，一般不设置
				}
		}

		var setup_menu_tree = $.fn.zTree.init($("#setup_menu_tree"), settings);

    </script>

</body>

</html>