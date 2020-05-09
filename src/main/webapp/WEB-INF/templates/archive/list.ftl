<#assign base=request.contextPath />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>档案列表</title>
</head>

<body>

    <div id="archive_bg_toolbar" style="display:none">
        <button class="layui-btn" onclick="open_add_archive_page()">新建档案</button>
        <button class="layui-btn" onclick="delete_archives()">批量删除</button>
    </div>

    <table id="archive_dg" lay-filter="archive_dg_f"></table>

    <div style="display:none" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="del">删除</a>
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    </div>

    <script>
        var table = layui.table;
           var archive_list_table = table.render({
                //为谁渲染
                elem: '#archive_dg'
                ,page:true
                ,limits:[5,10]
                ,limit:5
                ,url: '${base}/archive/list' //数据接口
                ,cols: [[ //表头 ,cols修饰所有要展示的列
                    {type:'checkbox'}//开启复选框
                    ,{field: 'archiveID', title: '序号', width:90, sort: true}
                    ,{field: 'archiveTitle', title: '档案标题', width:90}
                    ,{field: 'archiveName', title: '建档人', width:90}
                    ,{field: 'archiveType', title: '档案类型', width:90}
                    ,{field: 'archiveDateStr', title: '建档日期'}
                    ,{fixed: 'right', title:"操作", width: 165, align:'center', toolbar: '#barDemo'}
                ]],
                toolbar:"#archive_bg_toolbar"
            });

        //监听工具条
        table.on('tool(archive_dg_f)', function(obj){
            var data = obj.data;
            if(obj.event === 'edit'){
                edit_archive(data);
            }else{
                del_archive(data);
            }
        });

        //批量删除
        function delete_archives() {
            //获取选中数据
            var archive_row = table.checkStatus("archive_dg");

            //别忘了提示至少选择一条
            if (null != archive_row.data && 0 < archive_row.data.length) {
                //提示是否删除数据
                layer.confirm("是否确认删除数据？",{title:'删除提示'},function(index) {
                    //声明一个空字符串，用来拼写id
                    var archive_ids = "";
                    //获取到所有选中数据的id
                    for (var i = 0; i < archive_row.data.length; i++) {
                        archive_ids = archive_ids + "," + archive_row.data[i].archiveID;
                    }
                    if(archive_row.data){
                        if (0 < archive_ids.length) {
                            //截取掉第一个逗号
                            archive_ids = archive_ids.substring(1);
                        }
                    }

                    //使用ajax删除
                    $.ajax({
                        url:"${base}/archive/deleteAll",
                        data:{archiveIDS:archive_ids},
                        //dataType:"",//返回值类型
                        //type:"",//请求提交方式（get/post）
                        success:function(data) {
                            //关闭提示框
                            layer.close(index);
                            //刷新数据表格
                            archive_list_table.reload();
                        }
                    });
                });
            } else {
                //没有选中数据
                layer.alert("请至少选中一条数据！");
            }
        }



        //修改
        function edit_archive(archive_data){
            if(null != archive_data){
                $.ajax({
                    url:"${base}/archive/edit?archiveID=" + archive_data.archiveID,
                    success:function(data){
                        var layer = layui.layer;
                        var edit_archive = layer.open({
                            title:"编辑信息",
                            type: 1,
                            skin: 'layui-layer-rim', //加上边框
                            area: ['860px', '640px'], //宽高
                            content: data,
                            btn:["提交"],
                            yes:function(){
                                $.ajax({
                                    url:"${base}/archive/update",
                                    //serialize方法可以将表单直接序列化成json
                                    data:$("#archive_edit_form").serialize(),
                                    success:function(data) {
                                        //关闭对话框
                                        layer.close(edit_archive);
                                        //刷新列表
                                        archive_list_table.reload();
                                    }
                                });
                            }
                        })
                    }
                });
            }else{
                layui.alert("请至少选择一条信息进行编辑");
            }
        }

        //单条删除
        function del_archive(del_data){
            if(null != del_data){
                layer.confirm("是否确认删除数据？",{title:'删除提示'},function(index) {
                    $.ajax({
                        url:"${base}/archive/deleteOne",
                        data:{archiveID:del_data.archiveID},
                        success:function(data){
                            //关闭弹框
                            layer.close(index);
                            //刷新列表
                            archive_list_table.reload();
                        }
                    });
                });
            }

        }


        //打开添加对话框
        function open_add_archive_page(){
            $.ajax({
                url:"${base}/archive/toAddPage",
                success:function(data){
                    var layer = layui.layer;
                    var archive_add_layer = layer.open({
                        type:1,
                        title: '新建档案',
                        area:["680px","580px"],
                        content: data,
                        anim:5,//弹框时的动画
                        maxmin:true,
                        yes:function() {
                            //把数据提交到后台
                            $.ajax({
                                url:"${base}/archive/insert",
                                //serialize方法可以将表单直接序列化成json
                                data:$("#archive_add_form").serialize(),
                                success:function(data) {
                                    //关闭对话框
                                    layer.close(archive_add_layer);
                                    //刷新列表
                                    archive_list_table.reload();
                                }
                            });
                        },
                        btn2:function() {
                            layui.alert("重置")
                        },
                        skin:"layui-layer-molv",
                        btn:["提交" , "重置"]
                    });
                }
            });
        }

    </script>

</body>

</html>