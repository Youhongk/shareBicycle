/**
 * JdGrid
 */
var dataNull = {};
var rows;

function doBatchOpera(type,data,success){
	$.ajax({
		url : "/manager/bicycle/doBatchOpera?type="+type,
		data : JSON.stringify(data),
		type : "post",
		dataType:"json",
		contentType : "application/json",
		success : success
	})
}

$.jgrid.defaults.styleUI = "Bootstrap"; // 设置皮肤为Bootstrap默认皮肤

function tableReload1(data) {
	var url = "/manager/bicycle/getBicycleData";
	function success(backdata){
		backdata=translate(backdata,regionalParam,"regional");
		backdata=translate(backdata,bsParam,"bicycleStatus");
		$("#grid-table").jqGrid('clearGridData');
		$("#grid-table").jqGrid('setGridParam', {
			data : backdata,
		}).trigger("reloadGrid");	
	}
	doAjax(url,data,success)	
}

function tableReload2(data) {
	var url = "/manager/bicycle/getRidingData";
	function success(backdata){	
		backdata=translate(backdata,rsParam,"ridingStatus");
		$("#user-riding").jqGrid('clearGridData'); // 清空表格
		$("#user-riding").jqGrid('setGridParam', { // 重新加载数据
			data : backdata, // newdata 是符合格式要求的需要重新加载的数据
		}).trigger("reloadGrid");
	}
	doAjax(url,data,success)	
}

function tableReload3(data) {

	var url = "/manager/bicycle/getFeedbackData";
	function success(backdata){	
		backdata=translate(backdata,fsParam,"feedbackStatus");
		backdata=translate(backdata,fbtParam,"feedbackType");
		backdata=translate(backdata,dtParam,"damageType");
		$("#grid-table").jqGrid('clearGridData');
		$("#grid-table").jqGrid('setGridParam', {
			data : backdata,
		}).trigger("reloadGrid");	
	}
	doAjax(url,data,success)
}

function tableLoad() {
	/* 表格1:车辆管理 */
	$("#grid-table").jqGrid({
		// url:"/manager/bicycle/getAllBicycleData",
		data : grid_data,
		datatype : "local", // 数据来源，本地数据（local，json,jsonp,xml等）
		height : 'auto', // 高度，表格高度。可为数值、百分比或'auto'
		colNames : [ '车辆编号', '车辆状态', '车辆实时坐标', '投放区域', '操作' ],
		colModel : [ {
			name : 'bicycleId',
			index : 'bicycleId', // 索引。其和后台交互的参数为sidx
			key : true, // 当从服务器端返回的数据中没有id时，将此作为唯一rowid使用只有一个列可以做这项设置。如果设置多于一个，那么只选取第一个，其他被忽略
			width : 150,
			editable : false,
		}, {
			name : 'bicycleStatus',
			index : 'bicycleStatus',
			width : 150, // 宽度
			editable : false, // 是否可编辑
		}, {
			name : 'coordinates',
			index : 'coordinates',
			width : 250,
			sorttype : "double",
			editable : false,
		}, {
			name : 'regional',
			index : 'regional',
			width : 200,
			editable : false,
		}, {
			name : 'options',
			index : 'options',
			width : 200,
			sortable : false,
			formatter : optionType_table1
		} ],

		/* 导航栏相关属性设计 */
		viewrecords : true, // 是否在浏览导航栏显示记录总数
		rowNum : 5, // 每页显示记录数
		rowList : [ 5, 10, 15 ], // 用于改变显示行数的下拉列表框的元素数组。
		pager : '#grid-pager', // 分页、按钮所在的浏览导航栏

		/* 表格相关属性设置 */
		viewrecords : true,
		multiselect : true, // 是否多选
		multiboxonly : true, // 是否只能点击复选框多选
		sortname : 'id', // 默认的排序列名
		sortorder : 'asc', // 默认的排序方式（asc升序，desc降序）
		caption : "车辆操作列表", // 表名
		autowidth : true
	// 自动宽
	})

	$("#user-riding").jqGrid({
		// url:"/manager/bicycle/getRidingData",
		datatype : "local", // 数据来源，本地数据（local，json,jsonp,xml等）
		data : grid_data2,
		height : 'auto', // 高度，表格高度。可为数值、百分比或'auto'
		colNames : [ '骑行编号', '用户编号', '开始骑行时间', '骑行结束时间 ', '骑行状态' ],
		colModel : [ {
			name : 'id',
			index : 'id', // 索引。其和后台交互的参数为sidx
			key : true, // 当从服务器端返回的数据中没有id时，将此作为唯一rowid使用只有一个列可以做这项设置。如果设置多于一个，那么只选取第一个，其他被忽略
			width : 100,
			editable : false,
		// align: "center",
		}, {
			name : 'userId',
			index : 'userId',
			width : 100, // 宽度
			editable : false, // 是否可编辑
		}, {
			name : 'starttime',
			index : 'starttime',
			width : 220,
			sorttype : "double",
			editable : true
		}, {
			name : 'endtime',
			index : 'endtime',
			width : 220,
			sorttype : "double",
			editable : true
		}, {
			name : 'ridingStatus',
			index : 'ridingStatus',
			width : 150,
			sorttype : "double",
		} ],

		/* 导航栏相关属性设计 */
		viewrecords : false, // 是否在浏览导航栏显示记录总数
		rowNum : 10, // 每页显示记录数
		rowList : [ 10, 20, 30 ], // 用于改变显示行数的下拉列表框的元素数组。
		pager : '#user-riding-nav', // 分页、按钮所在的浏览导航栏
		sortname : 'id', // 默认的排序列名
		sortorder : 'asc', // 默认的排序方式（asc升序，desc降序）
		caption : "用户骑行记录", // 表名
		autowidth : true
	// 自动宽
	});

	$("#user-feedback").jqGrid({
		// url:"/manager/bicycle/getFeedbackData",
		datatype : "local", // 数据来源，本地数据（local，json,jsonp,xml等）
		data : grid_data3,
		height : 'auto', // 高度，表格高度。可为数值、百分比或'auto'
		colNames : [ '反馈编号', '用户编号', '反馈类型', '具体内容', '车辆编号', '损坏类型', '处理情况 ' ],
		colModel : [ {
			name : 'id',
			index : 'id', // 索引。其和后台交互的参数为sidx
			key : true, // 当从服务器端返回的数据中没有id时，将此作为唯一rowid使用只有一个列可以做这项设置。如果设置多于一个，那么只选取第一个，其他被忽略
			width : 100,
			editable : false,
		}, {
			name : 'userId',
			index : 'userId',
			width : 100, // 宽度
			editable : false, // 是否可编辑

		}, {
			name : 'feedbackType',
			index : 'feedbackType',
			width : 100,
			sorttype : "double",
			editable : true
		}, {
			name : 'content',
			index : 'content',
			width : 200,
			sorttype : "double",
			editable : true
		}, {
			name : 'bicycleId',
			index : 'bicycleId',
			width : 100,
			editable : false,
		// formatter: optionType_table3
		}, {
			name : 'damageType',
			index : 'damageType',
			width : 150,
			sorttype : "double",
			editable : false,
		// formatter: optionType_table3
		}, {
			name : 'feedbackStatus',
			index : 'feedbackStatus',
			width : 100,
			sorttype : "double",
			editable : false,
		// formatter: optionType_table3
		} ],

		/* 导航栏相关属性设计 */
		viewrecords : false, // 是否在浏览导航栏显示记录总数
		rowNum : 10, // 每页显示记录数
		rowList : [ 10, 20, 30 ], // 用于改变显示行数的下拉列表框的元素数组。
		pager : '#user-feedback-nav', // 分页、按钮所在的浏览导航栏
		/* 表格相关属性设置 */
		viewrecords : false,
		sortname : 'id', // 默认的排序列名
		sortorder : 'asc', // 默认的排序方式（asc升序，desc降序）
		caption : "反馈记录", // 表名
		autowidth : true
	// 自动宽
	})

	/* 配置导航栏的工具栏一 */
	$("#grid-table").jqGrid('navGrid', "#grid-pager", {
		add : false,
		del : false,
		edit : false,
		position : 'left',
		search : false,
		refresh : false,

	}).navButtonAdd("#grid-pager", {
		caption : "一键入库",
		buttonicon : "fa fa-chevron-circle-right",
		onClickButton : entryAll,
		position : "last"
	}).navButtonAdd("#grid-pager", {
		caption : "一键投放",
		buttonicon : "fa fa-chevron-circle-right",
		onClickButton : outputAll,
		position : "last"
	}).navButtonAdd("#grid-pager", {
		caption : "一键回收",
		buttonicon : "fa fa-chevron-circle-right",
		onClickButton : recycleAll,
		position : "last"
	}).navButtonAdd("#grid-pager", {
		caption : "一键维修",
		buttonicon : "fa fa-chevron-circle-right",
		onClickButton : fixAll,
		position : "last"
	});
}

/*
 * 初始化表格数据
 */
function tableInit(){
	var url = "/manager/bicycle/getBicycleData";	
	var url2 = "/manager/bicycle/getRidingData";
	var url3 = "/manager/bicycle/getFeedbackData";
	var data = {};	
	function success(backdata){
		backdata=translate(backdata,regionalParam,"regional");
		backdata=translate(backdata,bsParam,"bicycleStatus");
		grid_data=backdata;
		doAjax(url2,data,success2)							
	}	
	function success2(backdata){
		backdata=translate(backdata,rsParam,"ridingStatus")
		grid_data2=backdata;
		doAjax(url3,data,success3)			
	}	
	function success3(backdata){
		backdata=translate(backdata,fsParam,"feedbackStatus");
		backdata=translate(backdata,fbtParam,"feedbackType");
		backdata=translate(backdata,dtParam,"damageType");
		grid_data3=backdata;
		tableLoad();		
	}
	doAjax(url,data,success);	
}
tableInit();    //初始化表格

/* 操作类型 */
var optionType_table1 = function(cellvalue, options, rowObject) {
	var id = rowObject.bicycleId;
	var status = rowObject.bicycleStatus;
	if (status == "待入库") {
		return '<button class="btn-xs btn-info" onclick="viewInfo(' + id
				+ ',\'' + status + '\')">入库</button>'; 
	}else if (status == "待投放") {
		return '<button class="btn-xs btn-danger" onclick="viewInfo(' + id
		+ ',\'' + status + '\')">投放</button>'; 
	}else if (status == "待回收") {
		return '<button class="btn-xs btn-primary" onclick="viewInfo(' + id
				+ ',\'' + status + '\')">回收</button>'; 
	} else if (status == "待维修") {
		return '<span>请进行批量维修</span>'; 
	} else{
		return '<span>无操作</span>';
	}
}

var optionType_table2 = function(cellvalue, options, rowObject) {
	var id = rowObject.bicycleId;
	var status = rowObject.bicycleStatus;
	return '<button class="btn-xs btn-danger" onclick="deal(' + id + ',\''
			+ status + '\',\'riging_deal\')">确认修改</button>'; // 可以放连接也可以接事件
}
var optionType_table3 = function(cellvalue, options, rowObject) {
	var id = rowObject.bicycleId;
	var status = rowObject.bicycleStatus;
	return '<button class="btn-sx btn-danger" onclick="deal(' + id + ',\''
			+ status + '\',\'feedback_deal\')">确认修改</button>';
}

/* 操作触发后 */
function viewInfo(id, status) {

	if (status == "待入库") {
		var data1 = {		
				"bicycleId":parseInt(id),
				"bicycleStatus":parseInt(3)
		};
		function success(backdata1){
			alert(id + "入库成功");
			tableReload1({});
		}
		doAjaxUpdate(data1,success)	
		return;
	} else if (status == "待回收") {
		
		var data1 = {		
				"bicycleId":parseInt(id),
				"bicycleStatus":parseInt(7)
		};
		function success(backdata1){
			alert(id + "回收成功");
			tableReload1({})
		}
		doAjaxUpdate(data1,success);		
		return;
	}else if (status == "待投放") {		
		$('#outputModal').modal('toggle');
		return;
	}
}

//判断所选数据是否符合条件
function screen(rows,status){
	for(var i=0;i<rows.length;i++){
		var rowData = $("#grid-table").jqGrid('getRowData', rows[i]);
		if(rowData.bicycleStatus!=status){
			 return false;
		}		
	}
	return true;
}

/* 一键入库 */
var entryAll = function() {	
	var rows = $("#grid-table").jqGrid('getGridParam', 'selarrrow');	
	if (rows.length == 0) {
		alert("请选择需要操作的数据行!");
	}else if(!screen(rows,"待入库")){
		alert("所选数据不全为可入库状态,请重新选择！");
	}else {
		// 把rows的数据传到后台进行入库处理，rows为id组
		var url = "/manager/bicycle/doBatchOpera?type=stroage&regional=''&fixType=''";
		var data = rows;
		function success(backData){
			alert("一键入库成功");
			tableReload1({})
		}
		doAjax(url,data,success);
	}
}

/* 一键投放 */
var outputAll = function() {
	rows = $("#grid-table").jqGrid('getGridParam', 'selarrrow');	
	if (rows.length == 0) {
		alert("请选择需要操作的数据行!");
	}else if(!screen(rows,"待投放")){
		alert("所选数据不全为可投放状态,请重新选择！");
	} else {	
		$('#outputModal').modal('toggle');
	}
}
function doOutputAll(){
	rows  =  $("#grid-table").jqGrid('getGridParam','selarrrow');
	var regional = $('#output_regional').val();
	var op_cd;
	for(var i = 0;i<regionalParam.length;i++){
		 if(regional==regionalParam[i].pkey){
			 op_cd = regionalParam[i].meno;
			 break;
		 }		
	}
	var url = "/manager/bicycle/doBatchOpera?type=ouput&regional="+regional+"&fixType=''"+"&cd="+op_cd;
	var data = rows;
	function success(backData){
		$('#outputModal').modal('toggle');
		alert("投放成功");
		tableReload1({})		
	}
	doAjax(url,data,success);
	
}

/* 一键回收 */
var recycleAll = function() {
	var rows = $("#grid-table").jqGrid('getGridParam', 'selarrrow');	
	if (rows.length == 0) {
		alert("请选择需要操作的数据行!");
	}else if(!screen(rows,"待回收")){
		alert("所选数据不全为可回收状态,请重新选择！");
	} else {
		// 把rows的数据传到后台进行入库处理
		var url = "/manager/bicycle/doBatchOpera?type=recycle&regional=''&fixType=''"+"&cd=''";
		var data = rows;
		function success(backData){
			alert("一键回收成功");
			tableReload1({})
		}
		doAjax(url,data,success);
	}
}

/* 一键维修*/
var fixAll = function() {
	rows = $("#grid-table").jqGrid('getGridParam', 'selarrrow');
	if (rows.length == 0) {
		alert("请选择需要操作的数据行!");
	}else if(!screen(rows,"待维修")){
		alert("所选数据不全为可维修状态,请重新选择！");
	}else {	
		$('#fixTypeModal').modal('toggle');
	}
}
function doFixAll(){
	var fixtype = $('#fix_type').val();
	var url = "/manager/bicycle/doBatchOpera?type=fix&regional=''&fixType="+fixtype+"&cd=''";
	var data = rows;
	function success(backData){
		alert("一键维修成功");
		tableReload1({})
	}
	doAjax(url,data,success);
	$('#fixTypeModal').modal('toggle');
}