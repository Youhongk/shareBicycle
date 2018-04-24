/**
 * 该文件用于初始化与参数表有关的事件
 */

var regionalParam;
var bsParam;
var fsParam;
var fbtParam;
var dtParam;
var rsParam;
var ttParam;
var vipParam;
var ftParam;

/**
 * 加载option标签
 * @param data：需要加载的参数数据
 * @param idName：下拉框标签的id
 * @returns
 */
function reloadParam(data,idName){
	var selector;
	var t ;
	var v;
	for(var idx in data){
		 selector = $('#'+idName);
		 t = data[idx].pvalue;
		 v = data[idx].pkey;
		$('<option></option>').text(t).val(v).appendTo(selector);
	}
}

/**
 * 数据翻译
 * @param gdata:需要翻译的数据
 * @param pdata：参数数据
 * @param property：需要翻译的属性
 * @returns
 */
function translate(gdata,pdata,property){

	for(var gIdx in gdata){			
		for(var pIdx in pdata){
			if(gdata[gIdx][property]==pdata[pIdx]["pkey"]){
				gdata[gIdx][property]=pdata[pIdx]["pvalue"];
				break;
			}
		}
	}
	return gdata;
}

/**
 * ajax
 * @param data:json格式的参数数据
 * @param success:回调函数
 * @returns
 */
function doAjaxInit(data,success){
	$.ajax({
		url : "/manager/bicycle/getParamInit",
		data : JSON.stringify(data),
		type : "post",
		dataType:"json",
		contentType : "application/json",
		success : success
	})
}

//初始化参数的方法
function doRegionalInit(){
	var data = {
		"paramName" : "regional"
	}
	function success(backData){	
		regionalParam=backData;	
		reloadParam(regionalParam,"regional");
		reloadParam(regionalParam,"output_regional");
	}
	doAjaxInit(data,success)
}
function doBicycleStatusInit(){
	var data = {
		"paramName" : "bicycleStatus"	
	}
	function success(backData){
		bsParam=backData;		
	}
	doAjaxInit(data,success)
}
function doFeedbackStatusInit(){

	var data = {
		"paramName" : "feedbackStatus"	
	}
	function success(backData){
		fsParam=backData;
		
	}
	doAjaxInit(data,success)
}
function doFeedbackTypeInit(){

	var data = {
		"paramName" : "feedbackType"	
	}
	function success(backData){
		fbtParam=backData;
		reloadParam(fbtParam,"feedbackType");
	}
	doAjaxInit(data,success)
}
function doDamageTypeInit(){

	var data = {
		"paramName" : "damageType"	
	}
	function success(backData){
		dtParam=backData;
		reloadParam(dtParam,"damageType");
	}
	doAjaxInit(data,success)
}
function doRidingStatusInit(){

	var data = {
		"paramName" :"ridingStatus"	
	}
	function success(backData){
		rsParam=backData;
		reloadParam(rsParam,"userinfo_status");
		reloadParam(rsParam,"riding_status");
	}
	doAjaxInit(data,success)
}
function doTransactionsTypeInit(){

	var data = {
		"paramName" : "transactionsType"
	}
	function success(backData){
		ttParam=backData;
		
	}
	doAjaxInit(data,success)
}
function doVipInit(){

	var data = {
		"paramName" :"vip"		
	}
	function success(backData){
		vipParam=backData;
		
	}
	doAjaxInit(data,success)
}
function doFixTypeInit(){

	var data = {
		"paramName" :"fixType"		
	}
	function success(backData){
		ftParam=backData;
		reloadParam(ftParam,"fix_type")
	}
	doAjaxInit(data,success)
}

//初始化参数数据
doRegionalInit();
doBicycleStatusInit();
doFeedbackStatusInit();
doFeedbackTypeInit();
doDamageTypeInit();
doRidingStatusInit();
doTransactionsTypeInit();
doVipInit();
doFixTypeInit();

