<#assign base=request.contextPath />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍列表</title>
</head>

<body>

	<div id="book_bg_toolbar" style="display:none">
		<button class="layui-btn" onclick="open_add_book_page()">添加</button>
		<button class="layui-btn" onclick="delete_books()">批量删除</button>
	</div>
	<table id="book_dg" lay-filter="book_dg_f"></table>


	<div style="display:none" id="barDemo">
	  <a class="layui-btn layui-btn-xs" lay-event="del">删除</a>
	  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
	</div>

	<script>
	
		var table = layui.table;
		  
	  	//第一个实例
		  var book_list_table = table.render({
		  	//为谁渲染
		    elem: '#book_dg'
		    ,page:true
		    ,limits:[5,10]
		    ,limit:5
		    ,url: '${base}/book/list' //数据接口
		    ,cols: [[ //表头 ,cols修饰所有要展示的列
		      {type:'checkbox'}//开启复选框
		      ,{field: 'bookID', title: '序号', width:90, sort: true}
		      ,{field: 'bookName', title: '书籍名称', width:90}
		      ,{field: 'bookAuthor', title: '书籍作者', width:90}
		      ,{field: 'bookType', title: '书籍类型', width:90, templet:function(d){
		          var book_type_str = "";
		          if (1 == d.bookType){
		              book_type_str = "悬疑";
				  }else if (2 == d.bookType){
		              book_type_str = "恐怖";
				  }else if (3 == d.bookType){
                      book_type_str = "推理";
                  }else if (4 == d.bookType){
                      book_type_str = "寓言";
                  }
                  return book_type_str;
		      }}
		      ,{field: 'bookPrice', title: '书籍价格', width:90}
		      ,{field: 'bookDesc', title: '书籍描述', width:90}
		      ,{field: 'bookDateStr', title: '书籍日期'}
		      ,{fixed: 'right', title:"操作", width: 165, align:'center', toolbar: '#barDemo'}

		    ]],
		    toolbar:"#book_bg_toolbar"
		  });
		  
		  //监听工具条
		  table.on('tool(book_dg_f)', function(obj){
		    var data = obj.data;
		    if(obj.event === 'edit'){
		      edit_book(data);
		    }else{
		    	del_book(data);
		    }
		  });
		  
		  
		  
		  //打开添加对话框
		  function open_add_book_page(){
		  	$.ajax({
		  		url:"${base}/book/toAddPage",
		  		success:function(data){
		  			var layer = layui.layer;
				  	var book_add_layer = layer.open({
				  		 type:1,
				  		 title: '新增书籍',
				  		 area:["680px","580px"],
				  		 content: data,
				  		 anim:5,//弹框时的动画
				  		 maxmin:true,
						 skin:"layui-layer-molv",
                         btn:["提交" , "重置"],
				  		 yes:function() {
							//把数据提交到后台
							$.ajax({
								url:"${base}/book/insert",
								//serialize方法可以将表单直接序列化成json
								data:$("#book_add_form").serialize(),
								success:function(data) {
									//关闭对话框
									layer.close(book_add_layer);
									//刷新列表
									book_list_table.reload();
								}
							});
						},
						btn2:function() {
							alert("重置")
						}
		  			});
		  		}
		  	});
		  }
		  
		  
		  //批量删除书籍
		  function delete_books(){
		  	//获取选中数据（后面的参数是table元素的id属性值）
			var book_rows = table.checkStatus("book_dg");
			if(null != book_rows.data && book_rows.data.length > 0){
				var layer = layui.layer;
				var delete_book = layer.open({
					  title:"删除提示",
					  type: 0,
					  skin: 'layui-layer-rim', //加上边框
					  area: ['420px', '240px'], //宽高
					  content: '确认删除选中信息',
					  btn:["确认"],
					  yes:function() {
					  	var arr = "";
					  	for(var i = 0; i < book_rows.data.length; i++){
					  		arr = arr + "," + book_rows.data[i].bookID;
						}
						if(0 < arr.length){
							arr = arr.substring(1);
						}
						//把数据提交到后台
							$.ajax({
								url:"${base}/book/delete",
								//serialize方法可以将表单直接序列化成json
								data:{bookStr:arr},
								success:function(data) {
									//关闭对话框
									layer.close(delete_book);
									//刷新列表
									book_list_table.reload();
								}
							});
					  }
				  });
			}else{
				layui.alert("请至少选择一条数据");
			}
					
		  }
		  
		  //单条删除
		  function del_book(del_data){
		  	if(null != del_data){
		  		layer.confirm("是否确认删除数据？",{title:'删除提示'},function(index) {
		  			$.ajax({
		  				url:"${base}/book/deleteOne",
		  				data:{bookID:del_data.bookID},
		  				success:function(data){
		  					//关闭弹框
		  					layer.close(index);
		  					//刷新列表
		  					book_list_table.reload();
		  				}
		  			});
		  		});
		  	}
		  
		  }
		  
		  //编辑书籍信息
		  function edit_book(book_data){
		  	//获取选中数据（后面的参数是table元素的id属性值）
		  	//var book_row = table.checkStatus("book_dg");
		  	if(null != book_data){
			  	$.ajax({
			  		url:"${base}/book/edit?bookID=" + book_data.bookID,
			  		success:function(data){
				  		var layer = layui.layer;
				  		var edit_book = layer.open({
				  			title:"编辑信息",
							  type: 1,
							  skin: 'layui-layer-rim', //加上边框
							  area: ['860px', '640px'], //宽高
							  content: data,
							  btn:["提交"],
							  yes:function(){
							  	$.ajax({
									url:"${base}/book/update",
									//serialize方法可以将表单直接序列化成json
									data:$("#book_edit_form").serialize(),
									success:function(data) {
										//关闭对话框
										layer.close(edit_book);
										//刷新列表
										book_list_table.reload();
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
		
	</script>
</body>

</html>