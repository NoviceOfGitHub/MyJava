$(function () {
	obj = {
		editRow : undefined,
		search : function(){
			//查询load  
				$('#box').datagrid('load', {
				realname : $.trim($('input[name="realname"]').val()),
				date_from : $('input[name="date_from"]').val(),
				date_to : $('input[name="date_to"]').val(),
			});
		},
		newUser : function(){
			$('#dlg').dialog('open').dialog('setTitle','New User');
			$('#fm').form('clear');
		},
		editUser : function(){
			var row = $('#box').datagrid('getSelections');
			if (row.length == 1){
				$('#dlg').dialog('open').dialog('setTitle','Edit User');
				$('#fm').form('load',row[0]);
				
			}else{
				$.messager.alert('警告','请选择一行','warning');
			}
		},
		add :function(){
			$('#save,#redo').show();
			if (this.editRow == undefined) {
				//添加一行 
				$('#box').datagrid('insertRow', {
					index : 0,
					row : {
						/*
						user : 'bnbbs',
						email : 'bnbbs@163.com',
						date : '2014-11-11',
						*/
					},
				});
				//将第一行设置为可编辑状态
				$('#box').datagrid('beginEdit', 0);	
				this.editRow = 0;
			}
		},
		edit :function(){
			var rows = $('#box').datagrid('getSelections');

			if(rows.length==1)
			{	
	           if(obj.editRow != undefined){
			$("#box").datagrid('endEdit',obj.editRow);
		        }
		        if(obj.editRow == undefined){
			var index =$('#box').datagrid('getRowIndex',rows[0]);
			$('#save,#redo').show();
			$("#box").datagrid('beginEdit',index);
			this.editRow=index;
			$('#box').datagrid('unselectRow', index);
		        }
			}
			else
			{
				$.messager.alert('警告','请选择一行','warning');
			}
		
		},
	    save : function(){
			//保存当前行
            $('#box').datagrid('endEdit', this.editRow);
		},
		redo : function () {
			$('#save,#redo').hide();
			this.editRow = undefined;
			//回滚，从创建或上一次调用acceptChanges函数后更改的数据。
			$('#box').datagrid('rejectChanges');
		},
		remove : function () {
			var rows = $('#box').datagrid('getSelections');
			if (rows.length > 0) {
				$.messager.confirm('确定操作', '您正在要删除所选的记录吗？', function (flag) {
					if (flag) {
						var ids = [];
						for (var i = 0; i < rows.length; i ++) {
							ids.push(rows[i].uid);
						}
					
						$.ajax({
							type :'POST',
							datatype:'JSON',
							url :'deleteuser',
							data :{
								ids : ids.join(','),
							},
							beforeSend : function(){
									$('#box').datagrid('loading');
							},
							success :function(result){
								if(result.data){
									$('#box').datagrid('loaded');
									$('#box').datagrid('load');
									$('#box').datagrid('unselectAll');
									$.messager.show({
										title : '提示',
										msg : '删除成功！',
									});
								}
							},
							
						});
					
					
					
					}
				});
			} else {
				$.messager.alert('提示', '请选择要删除的记录！', 'info');
			}
		},

	};
	
	
   $('#box').datagrid({
       url:'getalluser',	  
	   width:600,
	   title:'用户列表',
	   iconCls:'icon-search',
	   fitcolumn:'true',
	   columns: [[
	              {
	  				field : 'uid',
	  				title : '编号',
	  				
	  				sortable : true,
	  				width : 100,
	  				checkbox : true,
	  	   },
	  	   {
	  		   field:'username',
	  		   title:'用户名',
	  		   //单个排序
	  		   sortable:'true',	
	  		   //hidden:'false',
	  		   editor :{
	  			   type:'validatebox',
	  			   options :{
	                 required:true,
	  			   },
	  			   
	  		   },
	  	   },
	 
	   {
		   field:'realname',
		   title:'真实姓名',
		     //单个排序
		   sortable:'true',
		   //单个单元框加css   单元格样式设置
		   styler:function(value,row,index){
			   if (value =="准备")
			   {
				   return 'background-color:orange';
			   }
		   },
		  editor :{
			   type : 'validatebox',
			   options :{
				required:true,   
				//自己拓展的验证格式 在最下面有许多 都是拓展validatebox的
	           validType:'chinese',
			   },
			   
		   },
	   },
	   {
	
		   field:'password',
		   title:'密码',
		     //单个排序
		   sortable:'true',
		   editor : {
			   type:'validatebox',
			   options :{
               required:true,
			   },
			   
		   },
		 
	   },
	   {
		   field:'usalary',
		   title:'薪水',
		     //单个排序
		   sortable:'true',
		      editor : {
			   type:'numberbox',
			   options :{
               required:true,		   
			   },
	   },
	    },
	    {
		   field:'udate',
		   title:'日期',
		     //单个排序
		   sortable:'true',
		   editor : {
					type : 'datetimebox',
					options : {
						required : true,
					},
				},
	   },
	   
        ]], 
		toolbar : '#tb',
		rownumbers : true,
		striped : true,
		nowrap : true,
		pagination:true,   //1确定分页
		pageSize:5,
		pageList:[1,2,5,10],
		//这2个是为默认的排序，给后端提供数据
		sortName:'udate',   //2默认排序
		sortOrder:'DESC',
		//设置本页排序
		remoteSort:false,
		//添加一个id=1的请求数据  post会增加
		/*queryParams :{
			"id":1,
		},*/
		//只能单选 true
		//singleSelect:'true',
		//加载提示
		loadMsg:'努力加载中',
		//showFooter:'true',
		//右击事件
		onRowContextMenu : function(e,rowIndex,rowData){
			e.preventDefault();
			//显示
	    $('#menu').menu('show',{
		left : e.pageX,
		top : e.pageY,
		
	    });
		},
		//双击
		onDblClickRow : function (rowIndex, rowData) {
			//控制不能双击多个
		if(obj.editRow != undefined){
			$("#box").datagrid('endEdit',obj.editRow);
			
		}
		if(obj.editRow == undefined){
			$('#save,#redo').show();
			$("#box").datagrid('beginEdit',rowIndex);
		
			obj.editRow=rowIndex;
		}
		},
		//等编辑结束后的相应事件
		onAfterEdit : function (rowIndex, rowData, changes) {
	         $('#save,#redo').hide();
			
			var inserted = $('#box').datagrid('getChanges', 'inserted');
			var updated = $('#box').datagrid('getChanges', 'updated');
			
			var url = info =  '';
			
			//新增用户
			if (inserted.length > 0) {
				url = 'adduser';
				info = '新增';
			}
			
			//修改用户
			if (updated.length > 0) {
				url = 'updateuser';
				info = '修改';
			}
			
			$.ajax({
				type : 'POST',
				datatype:"JSON",
				url : url,
				data : rowData,
				beforeSend : function () {
					$('#box').datagrid('loading');
				},	
				  success: function(result){
			            if (result.data){
					    $('#box').datagrid('loaded');
						$('#box').datagrid('load');
						$('#box').datagrid('unselectAll');
						$.messager.show({
							title : '提示',
							width:300,
							height:300,
							msg :  '1个用户被' + info + '成功！',
						});
						obj.editRow = undefined;
					}
					else{
					   $('#box').datagrid('loaded');
						$('#box').datagrid('load');
						$('#box').datagrid('unselectAll');
						$.messager.show({
					
							title : '提示',
							width:300,
							msg : '上个操作未有修改的数据',
						});
								obj.editRow = undefined;
					}
				},
			});

		},	   
   });
   
});

$.extend($.fn.validatebox.defaults.rules, {
	chinese : {// 验证中文
        validator : function(value) {
            return /^[\Α-\￥]+$/i.test(value);
        },
        message : '请输入中文'
    },
	name : {// 验证姓名，可以是中文或英文
            validator : function(value) {
                return /^[\Α-\￥]+$/i.test(value)|/^\w+[\w\s]+\w+$/i.test(value);
            },
            message : '请输入姓名'
    }
	
});

//扩展 dateTimeBox
$.extend($.fn.datagrid.defaults.editors, {
	datetimebox : {
		init: function(container, options){
			var input = $('<input type="text">').appendTo(container);
			options.editable = false;
			input.datetimebox(options);
			return input;
		},
		getValue: function(target){
			return $(target).datetimebox('getValue');
		},
		setValue: function(target, value){
			$(target).datetimebox('setValue', value);
		},
		resize: function(target, width){
			$(target).datetimebox('resize', width);
		},
		destroy : function (target) {
			$(target).datetimebox('destroy');
		},
	}
});
/*
//自己拓展的验证格式
$.extend($.fn.validatebox.defaults.rules, {
    eqPwd : {
        validator : function(value, param) {
            return value == $(param[0]).val();
        },
        message : '密码不一致！'
    },
    idcard : {// 验证身份证
        validator : function(value) {
            return /^\d{15}(\d{2}[A-Za-z0-9])?$/i.test(value);
        },
        message : '身份证号码格式不正确'
    },
    minLength: {
        validator: function(value, param){
            return value.length >= param[0];
        },
        message: '请输入至少（2）个字符.'
    },
    length:{validator:function(value,param){
        var len=$.trim(value).length;
            return len>=param[0]&&len<=param[1];
        },
        message:"输入内容长度必须介于{0}和{1}之间."
    },
    phone : {// 验证电话号码
        validator : function(value) {
            return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value);
        },
        message : '格式不正确,请使用下面格式:010-88888888'
    },
    mobile : {// 验证手机号码
        validator : function(value) {
            return /^(13|15|18)\d{9}$/i.test(value);
        },
        message : '手机号码格式不正确'
    },
    intOrFloat : {// 验证整数或小数
        validator : function(value) {
            return /^\d+(\.\d+)?$/i.test(value);
        },
        message : '请输入数字，并确保格式正确'
    },
    currency : {// 验证货币
        validator : function(value) {
            return /^\d+(\.\d+)?$/i.test(value);
        },
        message : '货币格式不正确'
    },
    qq : {// 验证QQ,从10000开始
        validator : function(value) {
            return /^[1-9]\d{4,9}$/i.test(value);
        },
        message : 'QQ号码格式不正确'
    },
    integer : {// 验证整数
        validator : function(value) {
            return /^[+]?[1-9]+\d*$/i.test(value);
        },
        message : '请输入整数'
    },
    age : {// 验证年龄
        validator : function(value) {
            return /^(?:[1-9][0-9]?|1[01][0-9]|120)$/i.test(value);
        },
        message : '年龄必须是0到120之间的整数'
    },
    chinese : {// 验证中文
        validator : function(value) {
            return /^[\Α-\￥]+$/i.test(value);
        },
        message : '请输入中文'
    },
    english : {// 验证英语
        validator : function(value) {
            return /^[A-Za-z]+$/i.test(value);
        },
        message : '请输入英文'
    },
    unnormal : {// 验证是否包含空格和非法字符
        validator : function(value) {
            return /.+/i.test(value);
        },
        message : '输入值不能为空和包含其他非法字符'
    },
    username : {// 验证用户名
        validator : function(value) {
            return /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/i.test(value);
        },
        message : '用户名不合法（字母开头，允许6-16字节，允许字母数字下划线）'
    },
    faxno : {// 验证传真
        validator : function(value) {
            return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value);
        },
        message : '传真号码不正确'
    },
    zip : {// 验证邮政编码
        validator : function(value) {
            return /^[0-9]\d{5}$/i.test(value);
        },
        message : '邮政编码格式不正确'
    },
    ip : {// 验证IP地址
        validator : function(value) {
            return /d+.d+.d+.d+/i.test(value);
        },
        message : 'IP地址格式不正确'
    },
    name : {// 验证姓名，可以是中文或英文
            validator : function(value) {
                return /^[\Α-\￥]+$/i.test(value)|/^\w+[\w\s]+\w+$/i.test(value);
            },
            message : '请输入姓名'
    },
    msn:{
            validator : function(value){
                return /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(value);
            },
            message : '请输入有效的msn账号(例：abc@hotnail(msn/live).com)'
    }
});
*/