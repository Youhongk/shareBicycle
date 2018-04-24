/**
 * map管理端地图
 */
var map; // 地图对象
var geolocation; // 定位对象

// 样式数据:不同状态的车辆不同样式
var styleData = new Array('#ffffff','#999999','#21ffff','#21ff21','#278ddd','#e82f3a','#ad722f','#519b73')
//区域数据：一个区域对应一个经纬度
var regionalData = new Array();

// 加载区域信息方法
function reloadRegional(){
	for(var idx in bicycleData){		
		var regionalName = bicycleData[idx].regional;// 得到每个对象的所属区域
		var regionalLngnal = bicycleData[idx].coordinates;// 得到每个对象的坐标值
		var $regional = $('#regional');
		$('<option></option>').text(regionalName).val(regionalLngnal).appendTo($regional);
	}
} 

//初始化区域数据
function bicycleInit(){
	var url = "/manager/bicycle/bicycleInit";
	var data = {};
	doAjax(url,data,function(data){
		bicycleData = data;
		//reloadRegional();
	});
} 

// 地图生成方法
function newMap(left,right,sly){
	map = new AMap.Map('mapManager', {
		resizeEnable: true,
		zoom: 20,
		mapStyle: 'amap://styles/2fd4eb84a033ed5139c6ea80d9cdd63c',
		center: [left, right]
	});
	
	// 设置地图插件
	map.plugin('AMap.Geolocation', function() {
		geolocation = new AMap.Geolocation({
			enableHighAccuracy: true, // 是否使用高精度定位，默认:true
			timeout: 10000, // 超过10秒后停止定位，默认：无穷大
			buttonOffset: new AMap.Pixel(10, 20), // 定位按钮与设置的停靠位置的偏移量，默认：Pixel(10,
													// 20)
			zoomToAccuracy: true, // 定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
			//buttonDom: '<input hidden="true" >', 	　
			buttonPosition: 'RB' //设置定位按钮的位置
		});
		map.addControl(geolocation);
		/*
		 * geolocation.getCurrentPosition(); AMap.event.addListener(geolocation,
		 * 'complete', onComplete);//返回定位信息 AMap.event.addListener(geolocation,
		 * 'error', onError); //返回定位出错信息
		 */
	});
	
	function onError(data) {
		$('#tip').attr('style','display: block;').html('定位失败');
	}
	
	// 生成覆盖层对象
	var loca = Loca.create(map); 
	// 生成可视化图层
	var layer = Loca.visualLayer({ 
		container: loca,
		type: 'point',
		shape: 'circle',
		eventSupport: true,
		fitView: false // 标记物自适应地图缩放
	});
	// 设置展示物的数据
	layer.setData(bicycleData, {
		lnglat: 'coordinates' // 设置经纬度信息
	})
	// 设置展示物样式
	layer.setOptions({
		unit: 'px',
		style: {
			radius: 10,           // 圆形半径，单位像素
			fill: styleData[sly], // 填充颜色
			lineWidth: 0.5,       // 边框宽度
			stroke: '#ffffff',    // 边框颜色
			// offsetX: 100       //调整标记的位置
		}
	})
	// 绑定点击事件
	layer.on('click', function(event) {
		// 通过session判断用户是否已登陆并且缴纳押金
		var a = 2;
		if(a == 1) { // 判断是否登陆
			
		} else if(a == 2) { // 判断是否缴纳押金
			
		} else if(a == 3) { // 判断是否有未完成订单
			
		} else {
			var a = event.lnglat;
			var b = map.getCenter();
			var myDistantc = b.distance(a).toString();
			alert("车辆距离您：" + myDistantc.split('.')[0] + "米！")
		}
	})
	
	// 渲染地图，把展示物加载到地图上
	layer.render();
}
  	
//根据触发条件动态加载不同区域的地图
function reloadMap(e){
	var sly;
	var lg;
	
	if(e=="BR"){
		var id= parseInt($('#regional').val())-1;
		 sly = parseInt($('#bicycleStatus').val())-1;  //样式数据
		 lg = regionalParam[id].meno;   //区域数据
	}
	
	if(e=="bicycleId"){
		sly = parseInt(bicycleData[0].bicycleStatus)-1;
		lg = bicycleData[0].coordinates;   //这里其实区域信息已经更新
		if(lg==null||lg==""){
			alert("该车辆没有地图位置信息！");
			return false;
		}
	}
	
	var arry = lg.split(",");
	newMap(parseFloat(arry[0]),parseFloat(arry[1]),parseInt(sly));
}

//车辆实时地图查询 
function coordinates_bicycle(e) {
	
	var url = "/manager/bicycle/getBicycleData";
	var bicycleId = $('#bicycleId').val()
	var bicycleStatus = $('#bicycleStatus').val();
	var regional = $('#regional').val();
	
	if(e=="BR"){
		if(regional==""){
			alert("请选择区域！")
			return false;
		}			
		if(bicycleStatus==""){
			alert("请选择车辆状态！")
			return false;
		}		
	}	
	var data = {
			"bicycleStatus" : bicycleStatus,
			"regional" : regional
	}
	
	if(e=="bicycleId"){
		if(bicycleId!=null){
			alert("编号不能为空！");
			return false;
		}else{
			data={
					"bicycleId" : bicycleId
				}
		}	
	}
	
	function success(backData) {	
		
		 bicycleData = backData;	//更新车辆数据	 
		 //reloadRegional();          //更新区域信息
		 reloadMap(e);            //更新地图
	}
	doAjax(url,data, success)
}

function idCheck(){
	alert(111);
	// ajax 根据id将车辆数据查询出来然后更新bikeData
	/*
	 * var sly 将拿到数据的状态信息,得到sly,判断是否为可用和待回收,不是则提示
	 * if(!sly.equal("可用")||sly.equal("待回收")){ alert("车辆处于:"+sly+"状态!"); return; }
	 * var coordinate 将拿到数据的位置信息, var arry = coordinate.split(",");
	 * newMap(arry[0],arry[1],sly);
	 */
}


bicycleInit();       //有车辆数据
newMap(113.2759952545166,23.117055306224895,0);  //生成以广州为中心的基础地图



