<#assign base=request.contextPath />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍列表</title>
</head>


<body>

<div style="padding: 20px; background-color: #F2F2F2;">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md6">
            <div class="layui-card">
			<#--<div class="layui-card-header">卡片面板</div>-->
                <div class="layui-card-body">
                    <div class="layui-btn-group">
                        <a class="layui-btn layui-btn-xs" onclick="add_tree_node()">添加</a>
                        <a class="layui-btn layui-btn-xs" onclick="del_tree_node()">删除</a>
                        <a class="layui-btn layui-btn-xs" onclick="edit_tree_node()">编辑</a>
                    </div>

				<#-- 放置树的容器 -->
                    <ul id="menu_list_tree"  class="ztree"></ul>
                </div>
            </div>
        </div>
    </div>
</div>

<script>

	var settings = {
		async: {
			enable: true,//如果动态加载就设置为true
			url: "${base}/tree/tree",
			//otherParam:{pid:1}//查询时的参数，一般不设置
		}
	}

	var menu_list_tree = $.fn.zTree.init($("#menu_list_tree"), settings);

	//添加节点
	function add_tree_node() {
		var nodes = menu_list_tree.getSelectedNodes();
		if(1 >= nodes.length){
			//添加子项
			var node_pid = 0;
			if(nodes.length == 1 && null != nodes){
                node_pid = nodes[0].id;
			}
			$.ajax({
				url:"${base}/tree/toAdd",
				data:{pid:node_pid},
				success:function (data) {
					var layer = layui.layer;
					var tree_add_layer = layer.open({
						type:1,
						title:"添加菜单",
						content:data,
						area:["320px","360px"],
						anim:3,
						maxmin:true,
						btn:["提交", "取消"],
						yes:function() {
							//把数据提交到后台
							$.ajax({
								url:"${base}/tree/insert",
								data:$("#add_tree_form").serialize(),
								success:function(data) {
									//页面上，把节点添加到父级节点下
									menu_list_tree.addNodes(nodes[0], data, false);
									//关闭对话框
									layer.close(tree_add_layer);
								}
							});
						}
					});
				}
			});

		}else{
			alert("只能选择一项")
		}
	}

	//删除节点
	function del_tree_node(){
		var nodes = menu_list_tree.getSelectedNodes();
		if(null != nodes && 1 == nodes.length){
			$.ajax({
				url:"${base}/tree/delete",
				data:{id:nodes[0].id},
				success:function(data){
					//从页面将数据移除
					menu_list_tree.removeNode(nodes[0]);
				}
			});
		}else if(nodes.length <= 0){
			alert("请选择一条您要删除的数据")
		}else{
			alert("只能选择一条数据进行删除")
		}
	}

	//编辑节点
	function edit_tree_node(){
		var nodes = menu_list_tree.getSelectedNodes();
		if(null != nodes && 1 == nodes.length){
			$.ajax({
				url:"${base}/tree/toEdit",
				data:{id:nodes[0].id},
				success:function(data){
					//打开编辑对话框
					var layer = layui.layer;
					var tree_edit_layer = layer.open({
						type:1,
						title:"编辑菜单",
						content:data,
						area:["320px","360px"],
						anim:3,
						maxmin:true,
						btn:["提交", "取消"],
						yes:function() {
							$.ajax({
								url:"${base}/tree/update",
								data:$("#edit_tree_form").serialize(),
								success:function(data){
									nodes[0].name = data.name;
									nodes[0].href = data.href;
									//刷新页面
									menu_list_tree.updateNode(nodes[0]);
									//关闭对话框
									layer.close(tree_edit_layer);
								}
							});
						}
					})
				}
			});
		}else if(nodes.length <= 0){
			alert("请选择一条您要编辑的数据")
		}else{
			alert("只能选择一条数据进行编辑")
		}
	}

</script>
</body>

</html>