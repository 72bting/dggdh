<#assign base=request.contextPath />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色列表</title>
</head>

<body>

	<div id="role_bg_toolbar" style="display:none">
		<button class="layui-btn" onclick="open_add_role_page()">添加角色</button>
	</div>

	<table id="role_dg" lay-filter="role_dg_f"></table>

    <div style="display:none" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="set_up">菜单设置</a>
        <a class="layui-btn layui-btn-xs" lay-event="del">删除</a>
    </div>

	<script>
		var table = layui.table;

		//初始化数据表格(第一个实例)
		var role_list_table = table.render({
			//为谁渲染
			elem: '#role_dg'
			,url: '${base}/role/list' //数据接口
			,cols: [[ //表头 ,cols修饰所有要展示的列
				{type:'checkbox'}//开启复选框
				,{field: 'roleID', title: '序号', width:90, sort: true}
				,{field: 'roleName', title: '角色名称'}
				,{fixed: 'right', title:"操作", width: 165, align:'center', toolbar: '#barDemo'}
			]]
			,toolbar:"#role_bg_toolbar"
		});

        //监听工具条
        table.on('tool(role_dg_f)', function(obj){
            var data = obj.data;
            if(obj.event === 'set_up'){
                open_setup_menu_page(data.roleID);
            }else if(obj.event == 'del'){
                delete_role(data.roleID);
            }
        });

        //删除角色
        function delete_role(role_id){
            //接到角色id，执行删除操作
            var layer = layui.layer;
            layer.confirm("是否确认删除？",{title:"确认提示"},function(index) {
                //使用ajax方式进行删除
                $.post("${base}/role/delete", {roleID:role_id}, function(data) {
                    //关闭对话框
                    layer.close(index);
                    //重新加载数据表格
                    role_list_table.reload();
                });
            });
        }

        //打开设置菜单对话框
        function open_setup_menu_page(role_id){
            $.ajax({
				url:"${base}/role/toSetup",
				data:{roleID:role_id},
				success:function(data){
				    var layer = layui.layer;
				    var setup_menu_layer = layer.open({
                        type:1,
                        title: '设置菜单',
                        area:["340px","360px"],
                        content: data,
                        anim:5,//弹框时的动画
                        maxmin:true,
                        skin:"layui-layer-molv",
                        btn:["提交" , "取消"],
                        yes:function(){
                            //获取到所有被勾选的树节点
							var nodes = setup_menu_tree.getCheckedNodes(true);
							var role_menu_json_arr = [];
							if(nodes != null && 0 < nodes.length){
							    for(var i = 0; i < nodes.length ; i++){
							        var menu_json = {roleID:role_id,id:nodes[i].id};
							        role_menu_json_arr.push(menu_json);
								}
							}
                            $.ajax({
                                url:"${base}/role/setupMenuTree",
								type:"post",
								contentType:"application/json",
                                // serialize方法可以将表单直接序列化成json
                                data:JSON.stringify(role_menu_json_arr),
                                success:function(data) {
                                    // 关闭对话框
                                    layer.close(setup_menu_layer);
                                }
                            });
                        }
					});
				}
			})
		}

		//打开添加角色对话框
		function open_add_role_page(){
            $.ajax({
                url:"${base}/role/toAddRolePage",
                success:function(data){
                    var layer = layui.layer;
                    var role_add_layer = layer.open({
                        type:1,
                        title: '添加角色',
                        area:["680px","580px"],
                        content: data,
                        anim:5,//弹框时的动画
                        maxmin:true,
                        skin:"layui-layer-molv",
                        btn:["提交" , "取消"],
                        yes:function() {
                            //把数据提交到后台
                            $.ajax({
                                url:"${base}/role/insert",
                                //serialize方法可以将表单直接序列化成json
                                data:$("#role_add_form").serialize(),
                                success:function(data) {
                                    //关闭对话框
                                    layer.close(role_add_layer);
                                    //刷新列表
                                    role_list_table.reload();
                                }
                            });
                        }
                    });
                }
            });
		}

    </script>

</body>

</html>