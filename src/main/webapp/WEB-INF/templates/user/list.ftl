<#assign base=request.contextPath />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>


<body>

    <div id="user_bg_toolbar" style="display:none">
        <button class="layui-btn" onclick="open_add_user_page()">添加用户</button>
    </div>


	<table id="user_dg" lay-filter="user_dg_f"></table>

    <div style="display:none" id="barDemo">
        <button class="layui-btn layui-btn-xs" lay-event="set_up">设置角色</button>
        <button class="layui-btn layui-btn-xs" lay-event="del">删除</button>
    </div>

	<script>
        var table = layui.table;
        var user_list_table = table.render({
            //为谁渲染
            elem: '#user_dg'
            ,page:true
            ,limits:[5,10]
            ,limit:5
            ,url: '${base}/user/list' //数据接口
            ,cols: [[ //表头 ,cols修饰所有要展示的列
                {type:'checkbox'}//开启复选框
                ,{field: 'userID', title: '序号', width:90, sort: true}
                ,{field: 'userAccount', title: '用户名', width:90}
                ,{field: 'userPwd', title: '密码', width:90}
                ,{fixed: 'right', title:"操作", width: 165, align:'center', toolbar: '#barDemo'}

            ]],
            toolbar:"#user_bg_toolbar"
        });

        //监听工具条
        table.on('tool(user_dg_f)', function(obj){
            var data = obj.data;
            if(obj.event === 'set_up'){
                open_set_up_role_page(data.userID)
            }else if (obj.event == 'del'){
                del_user(data.userID);
            }
        });


        //打开设置角色窗口
        function open_set_up_role_page(user_id){
            $.get("${base}/user/toSetup", {userID:user_id}, function(data) {
                var layer = layui.layer;
                var setup_role_layer = layer.open({
                    type:1,
                    title: '设置角色',
                    area:["340px","360px"],
                    content: data,
                    anim:5,//弹框时的动画
                    maxmin:true,
                    skin:"layui-layer-molv",
                    btn:["提交" , "取消"],
                    yes:function(){
                        //封装数据
                        var user_role_json_arr = [];
                        //获取到所有被勾选的复选框
                        $("input[name='user_setup_role_name']:checked").each(function(i, e) {
                            //each遍历方法中的e参数，代表被遍历的这个当前元素本身，是一个js对象
                            var role_json = {userID:user_id, roleID:e.value};
                            user_role_json_arr.push(role_json);
                        });
                        $.ajax({
                            url:"${base}/user/setupRole",
                            type:"post",
                            contentType:"application/json",
                            // serialize方法可以将表单直接序列化成json
                            data:JSON.stringify(user_role_json_arr),
                            success:function(data) {
                                // 关闭对话框
                                layer.close(setup_role_layer);
                            }
                        });
                    }
                });
            });
        }

        //删除用户
        function  del_user(user_id){
            var layer = layui.layer;
            layer.confirm("是否确认删除？",{title:"确认提示"},function(index) {
                //使用ajax方式进行删除
                $.ajax({
                    url:"${base}/user/delete",
                    data:{userID:user_id},
                    success:function(data){
                        //关闭对话框
                        layer.close(index);
                        //重新加载数据表格
                        user_list_table.reload();
                    }
                });
            });
        }

        //打开添加用户对话框
        function open_add_user_page(){
            $.ajax({
                url: "${base}/user/toAddUserPage",
                success:function(data){
                    var layer = layui.layer;
                    var user_add_layer = layer.open({
                        type:1,
                        title: '添加用户',
                        area:["680px","580px"],
                        content: data,
                        anim:5,//弹框时的动画
                        maxmin:true,
                        skin:"layui-layer-molv",
                        btn:["提交" , "取消"],
                        yes:function() {
                            //把数据提交到后台
                            $.ajax({
                                url:"${base}/user/insert",
                                //serialize方法可以将表单直接序列化成json
                                data:$("#user_add_form").serialize(),
                                success:function(data) {
                                    if(data.status == 1){
                                        alert("用户名已存在,请重新输入");
                                    }else{
                                        //关闭对话框
                                        layer.close(user_add_layer);
                                        //刷新列表
                                        user_list_table.reload();
                                    }
                                }
                            });
                        }
                    })
                }
            });
        }


    </script>


    <script>
        //获取form组件
        var user_add_form = layui.form;
        //渲染form样式
        user_add_form.render();
    </script>

</body>

</html>