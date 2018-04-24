
var grid_data;  //综合处理表格数据 
var grid_data2; //骑行记录表格数据
var grid_data3; //反馈记录表格数据
var bicycleData; //地图车辆数据


/*
 * 查询车辆ajax
 */
function doAjax(url,data,success) {
	$.ajax({
		url : url,
		data : JSON.stringify(data),
		type : "post",
		dataType:"json",
		contentType : "application/json",
		success : success
	})
}
/*
 * 车辆更新ajax
 */
function doAjaxUpdate(data,success) {
	$.ajax({
		url : "/manager/bicycle/updateBicycle",
		data : JSON.stringify(data),
		type : "post",
		dataType:"json",
		contentType : "application/json",
		success : success
	});
}

/* 用户查询 */
function find_user(e) {
	var target = $('#' + e);
	alert(target.val());
	// 进行异步查询-返回数据-填充用户基本信息/处理器为findbase
	target.parents('.container').attr('style', "display: none;");
	$('#user-info').attr('style', "display: block;");
}

/* 车辆综合处理id查询 */
function find_bicycleId() {
	var value = $('#bicycleIdInfo').val();
	var data = {
		"bicycleId" : parseInt(value)
	}
	tableReload1(data);
}
/* 车辆综合处理status查询 */
function find_bicycleStatus() {
	var value = $('#bicycleStatusInfo').val();
	var data = {
		"bicycleStatus" : parseInt(value)
	}
	tableReload1(data);
}

/* 车辆维修查询 */
function fix_find() {
	var value = $('#bicycleIdFix').val();
	var url = "/manager/bicycle/getBicycleData";
	var data = {
		"bicycleId" : parseInt(value)
	};
	function success(data) {
		$('#fix_bicycleId').text(data[0].bicycleId);
		var status = $('#fix_bicycleStatus');
		status.text(data[0].bicycleStatus);
		
		$('#destory').removeAttr("disabled");
		$('#storage').removeAttr("disabled");

		if(status.text()!="7"){
			$('#destory').attr("disabled",true);
			$('#storage').attr("disabled",true);
		}		
	};
	doAjax(url,data, success)
}
/* 车辆回收查询 */
function recycle_find() {
	var url = "/manager/bicycle/getBicycleData";
	var value = $('#bicycleIdRecycle').val();	
	var data = {
		"bicycleId" : parseInt(value)
	};
	function success(data) {		
		$('#recycle_bicycleId').text(data[0].bicycleId);
		var status = $('#recycle_bicycleStatus');
		status.text(data[0].bicycleStatus);
		
		$('#recycle_opera').removeAttr("disabled");
		if(status.text()!="6"){			
			$('#recycle_opera').attr('disabled',true);			
		}		
	}
	doAjax(url,data,success);
}
/* 车辆报废 */
function destory() {
	var value = $('#bicycleIdFix').val();	
	var data = {
		"bicycleId" : parseInt(value),
		"bicycleStatus":8
	}
	function success(data) {
		alert("成功报废！")
		$('#fix_bicycleId').text("");
		var status = $('#fix_bicycleStatus');
		status.text("");		
	}
	doAjaxUpdate(data,success);	
}
/* 车辆回收 */
function recycle() {
	var value = $('#bicycleIdRecycle').val();
	var data = {
		"bicycleId" : parseInt(value),
		"bicycleStatus" : 7
	}	
	function success(data) {
		alert("已回收！");
		$('#recycle_bicycleId').text("");
		var status = $('#recycle_bicycleStatus');
		status.text("");	
	}
	doAjaxUpdate(data,success);	
}
/* 车辆重新入库 */
function storage() {
	var value = $('#bicycleIdFix').val();
	var data = {
		"bicycleId" : parseInt(value),
		"bicycleStatus" : 3
	}
	function success(data) {
		alert("入库成功！");
		$('#fix_bicycleId').text("");
		var status = $('#fix_bicycleStatus');
		status.text("");		
	}
	doAjaxUpdate(data,success);		
}

/* 骑行记录表更新 */
function update_table2(id,status) {
	var userId = $('#' + id).val();	
	var ridingStatus = $('#' + status).val();
	var data = {
		"userId":parseInt(userId),
		"ridingStatus" : parseInt(ridingStatus)
	};
	tableReload2(data);		
}

/* 反馈记录表更新 */
function update_table3(id,status) {
	var userId = $('#' + id).val();	
	var feedbackStatus = $('#' + status).val();
	var data = {
			"userId":parseInt(userId),
			"feedbackStatus" : feedbackStatus
		};
	tableReload3(data);			
}
