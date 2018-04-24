
/* 全局变量 */
 // 这是登陆与否的标志，也是是否缴纳押金的标志
 // 余额，只能用于显示
// 用户名，用于登陆后展示
var sign = "0";	
var currentPosition;
var timerCR;
var payMoney = "0";
var doRiding = false;


if (lgInfo != "-1") {
	if (lgInfo == "0") {
		$('#userLogin').modal({ // 0未登录
			show : true
		})
		doRiding = true;
	} else if (message == "1") { // 未交押金
		showUserDeposit()
	} else if (message == "2") { // 正在骑行
		showTimer()
	} else if (message == "3") { // 待付款
		showUserPay();
	} else {
		$('#scanTips').html("开锁成功！").fadeIn("slow", function() {
			setTimeout(function() {
				$('#scanTips').fadeOut("slow");
			}, 1000)
		});
		showTimer();
	}
} else {
	$('#userLogin').modal({ // 0未登录
		show : true
	})
}

$('#content').attr('type', 'hidden'); // 关闭content

$('#bicycleId').change(function() {
	if ($('#bicycleId').val() == "") {
		$('#feedbackTips').html("");
	}
})


/*ajax*/
function doAjax(url, data, success) {
	$.ajax({
		type : "post",
		url : url,
		data : JSON.stringify(data),
		contentType : 'application/json',
		success : success
	});
}

/*计时器插件*/
var s = 0;
var m = 0;
var h = 0;
var t;
function timedCount() {
	$('#clocks').html(s);
	$('#clockh').html(h + ":");
	$('#clockm').html(m + ":");
	s = s + 1;
	if (s == 60) {
		s = 0;
		m += 1;
	}
	if (m == 60) {
		m = 0;
		h += 1;
	}
	t = setTimeout("timedCount()", 1000)
}

/*停止计费*/
function stopCount() {
	c = 0
	setTimeout("$('#clock').html(0)", 0);
	clearTimeout(t);
}

/*单车数据*/
var mobikeDate = [ {
	"lnglat" : [ 113.37824000000002, 23.20594 ],
	"id" : 1,
	"regional" : "天河区"
}, {
	"lnglat" : [ 113.37824000100110, 23.20500 ],
	"id" : 2,
	"regional" : "天河区"
}, {
	"lnglat" : [ 113.38024000100110, 23.20450 ],
	"id" : 3,
	"regional" : "天河区"
}, {
	"lnglat" : [ 100.37924100100110, 20.20400 ],
	"id" : 4,
	"regional" : "其他地区"
}, ];
var map; //地图对象
var geolocation; //定位对象

/*地图生成方法*/
map = new AMap.Map(
		'container',
		{
			resizeEnable : true,
			zoom : 20,
			mapStyle : 'lbs.amap.com/dev/mapstyle/mapshare/7f0c95e71e9611e5e090fe05a5be8f55',
			center : [ 113, 23 ]
		});

/*设置地图插件*/
map.plugin('AMap.Geolocation', function() {
	geolocation = new AMap.Geolocation({
		enableHighAccuracy : true, //是否使用高精度定位，默认:true
		timeout : 10000, //超过10秒后停止定位，默认：无穷大
		/*buttonOffset: new AMap.Pixel(10, 20), //定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)*/
		zoomToAccuracy : true, //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
		/*buttonDom: '<input hidden="true" >',*///修改自带的按钮图标	　
		buttonPosition : 'RB'
	});
	map.addControl(geolocation);
	geolocation.getCurrentPosition();
	AMap.event.addListener(geolocation, 'complete', onComplete);//返回定位信息
	AMap.event.addListener(geolocation, 'error', onError); //返回定位出错信息
});
/*定位成功*/
function onComplete(data) {
	$('#tip').html('定位成功！').fadeIn("slow", function() {
		setTimeout(function() {
			$('#tip').fadeOut("slow");
		}, 1000)
	});

	currentPosition = data.position; //设置当前位置
	map.setCenter(data.position.getLng(), data.position.getLat()); //设置地图中心点	
}
/*定位错误信息*/
function onError(data) {
	$('#tip').html('定位失败！').fadeIn("slow");
}

/*生成地图覆盖层对象*/
var loca = Loca.create(map);
var layer = Loca.visualLayer({ //生成可视化图层
	container : loca,
	type : 'point',
	shape : 'circle',
	eventSupport : true,
	fitView : false
//标记物自适应地图缩放
});

layer.setData(mobikeDate, { //设置展示物的数据
	lnglat : 'lnglat' //设置标记物的坐标
})

layer.setOptions({ //设置展示物样式
	unit : 'px',
	style : {
		radius : 10, // 圆形半径，单位像素
		fill : '#b7eff7', // 填充颜色
		lineWidth : 0.5, // 边框宽度
		stroke : '#ffffff', // 边框颜色
	//offsetX: 100          //调整标记的位置
	}
})

/* 点击事件 */
layer.on('click', function(event) { //绑定触摸事件
	//通过session判断用户是否已登陆、缴纳押金并且完成所有骑行订单
	var rul = "/user/checkPay";
	function success(backData) {
		sign = backData.status;
	}

	if (vip == "") { //判断是否登陆		
		showUserLogin()
	} else if (vip == "0") { //判断是否缴纳押金		
		showUserDeposit()
	} else if (sign != "0") { //判断是否有未完成订单				
		showUserPay();
	} else if (sign == "-1") { //判断是否有未完成订单				
		alert("请先登录！")
	} else {
		var a = event.lnglat; //a是点击的车辆                    
		var myDistantc = currentPosition.distance(a).toString(); //计算两点间的距离

		alert("车辆距离您：" + myDistantc.split('.')[0] + "米！") //精确到米
	}

})

/* 触摸事件 */
layer.on('touchstart', function(event) { //绑定触摸事件
	//通过session判断用户是否已登陆、缴纳押金并且完成所有骑行订单
	var rul = "/user/checkPay";
	function success(backData) {
		sign = backData;
	}

	if (vip == "") { //判断是否登陆		
		showUserLogin()
	} else if (vip == "0") { //判断是否缴纳押金		
		showUserDeposit()
	} else if (sign != "0") { //判断是否有未完成订单				
		showUserPay();
	} else {
		var a = event.lnglat; //a是点击的车辆
		var b = map.getCenter(); //b是当前位置
		var myDistantc = b.distance(a).toString(); //计算两点间的距离

		alert("车辆距离您：" + myDistantc.split('.')[0] + "米！") //精确到米
	}
})

layer.render(); //渲染地图，把展示物加载到地图上

/*----------模态框内动作---------*/
function showPassword() {

}

function showUserRegist() {
	$('#userRegist').modal('toggle')
}

function showUserLogin() {
	if (vip != "") {
		$('#userinfoLogin').html("切换账号")
	}
	$('#userLogin').modal('toggle')
}

function showUserDeposit() {
	if (vip == "") { //如果vip为1，代表已交押金，屏蔽交押金按钮
		$('#userinfoDeposit').attr('disabled', 'true');
		$('#userinfoRefund').attr('disabled', 'true');
		$('#depositTip')
				.html(
						"押金金额为：299元        <strong style='float:right'>请先登陆,后交押金！</strong>");
	} else if (vip == "1") {
		$('#userinfoRefund').removeAttr('disabled');
		$('#userinfoDeposit').attr('disabled', 'true');
		$('#depositTip').html(
				"押金金额为：299元<strong style='float:right'>您已缴纳押金，开始骑行吧</strong>");
	} else {
		$('#userinfoDeposit').removeAttr('disabled');
		$('#userinfoRefund').attr('disabled', 'true');
		$('#depositTip').html("押金金额为：299元");
	}
	$('#userDeposit').modal('toggle')
}

function showUserPay() {
	$('#userPay').modal('toggle')
}

function showTimer() {
	checkRiding(); //刷新一下开始时间
	timedCount(); //开始前端计时
	$('#timer').modal('toggle') //打开模态框
}

function showFeedback() {

	if (vip == "") { //如果vip为1，代表已交押金，屏蔽交押金按钮
		$('#userinfoFeedback').attr('disabled', 'true');
	} else if (vip == "1") {
		$('#userinfoFeedback').removeAttr('disabled');
	} else {
		$('#userinfoFeedback').attr('disabled', 'true');
	}
	$('#feedback').modal('toggle');
}

function showWallet() {
	if (vip == "") { //如果vip为""，代表已交押金，屏蔽交押金按钮
		$('#userinfoRecharge').attr('disabled', 'true');
	} else if (vip == "1") {
		$('#userinfoRecharge').removeAttr('disabled');
	} else {
		$('#userinfoRecharge').attr('disabled', 'true');
	}
	$('#money').html("余额为：" + number);
	$('#wallet').modal('toggle');
}

//反馈菜单响应
function fdHidden() {

	if ($('#feedbackType').val() == 1) {
		$('#damageType').attr('style', 'display:none');
		$('#bicycleId').attr('type', 'hidden');
		$('#content').attr('type', 'text');

	} else {
		$('#bicycleId').attr('type', 'text');
		$('#damageType').attr('style', 'display:inline-block');
		$('#content').attr('type', 'hidden');
	}
}
//注册
function doUserRegist() {
	var userName = $('#userName_regist');
	var phone = $('#userPhone_regist');
	var password = $('#password_regist');
	var passwordAgain = $('#passwordAgain_regist');
	if (!password.val() == passwordAgain.val()) {
		$('#errorInfo_regist').html("两次密码不匹配，请再次输入！")
		passwordAgain.val("");
	} else if (userName.val() == '') {
		alert("请输入用户名")
	} else if (password.val() == '') {
		alert("请输入密码")
	} else {

		var url = '/user/regist';
		var data = {
			'name' : userName.val(),
			'password' : password.val(),
			'phone' : phone.val()
		};

		function success(backData) {

			if ("success" == backData) {
				alert("注册成功，请登陆！");
				showUserRegist();
			} else {
				alert("系统错误！") //这种情况不存在
			}
		}
		;
		doAjax(url, data, success);
	}
}
//登陆
function doUserLogin() {
	userName = $('#userName_login').val();
	password = $('#password_login').val();
	if (userName == '') {
		alert("请输入用户名！");
	} else if (password == '') {
		alert("请输入密码！");
	} else {

		if (vip != "") {
			vip = ""; //若已经登陆，再次登陆时会清空登陆信息
		}

		url = "/user/login";
		data = {
			'name' : userName,
			'password' : password
		};

		function success(backData) {

			if (backData != "") { //登陆失败，账户密码错误
				vip = backData.vip; //加载个人信息
				console.log(vip);
				number = parseInt(backData.number);
				name = backData.name;
				$('#userName_home').html(name);
				$('#money').text(number);
				alert("登陆成功！");
				showUserLogin();				
				if (doRiding) {
					function success() {
						//stratTimerCR();       //登陆成功后开始定时扫描骑行状态						
						location.reload(true) ;						
					}
					;
					doAjax("/jump/scan?id=0", null, success);
				}
							
			} else {
				alert("用户名或密码错误")
			}
		}
		;
		doAjax(url, data, success)
		
	}

}
//缴纳押金
function doUserDeposit() {
	//传入用户id,判断用户的vip是否为1，不是则打开缴纳窗口是则提示已经缴纳或不可用缴纳按钮

	url = "/user/deposit";
	function success(backData) {
		if (backData == "UL1") { //这里是防止前台的修改vip的值，造成误操作			
			alert("请先登陆");
			return;
		} else if (backData == "UD1") {
			alert("已缴纳押金")
		}
		alert("成功缴纳押金，开始用车吧！")
		showUserDeposit();
		vip = "1";
	}
	;

	doAjax(url, null, success)

}
//退押金
function doUserRefund() {
	url = "/user/refund";
	function success(backData) {
		alert("退押金成功，期待您再次回来！");
		showUserDeposit();
		vip = "0";
	}
	;
	doAjax(url, null, success)
}
//付款
function doUserPay() {

	$.ajax({
		type : "post",
		url : "/user/pay",
		data : JSON.stringify({
			pass : $('#password_pay').val(),
			name : "haha"
		}),
		contentType : 'application/json',
		success : function success(backData) {
			if (backData == "2") {
				alert("密码错误!");
			} else if (backData == "0") {
				alert("付款成功");
				showUserPay();
				//stratTimerCR();   //付款成功开始扫描骑行状态
			} else if (backData == "1") {
				alert("没有未付款的骑行记录")
			} else {
				alert("余额不足，请充值！")
			}
		}
	})
}
//停止计费
function doRidingStop() {

	var url = "/user/calculation";
	function success(backData) {
		payMoney = backData;
		$('#payCount').html("<strong>" + payMoney + "</strong>");
		stopCount(); //停止计时	
		showTimer(); //关闭计时模态框
		showUserPay(); //打开付款窗口
	}
	;
	doAjax(url, null, success);
}
//反馈
function doFeedback() {
	var ft = $('#feedbackType').val();
	var content = $('#content').val();
	var bicycleId = $('#bicycleId').val();
	var dt = $('#damageType').val();
	var feedbackJson = {
		'feedbackType' : ft,
		'bicycleId' : bicycleId,
		'content' : content,
		'damageType' : dt
	};
	var url = "/user/feedback";
	var data = feedbackJson;
	function success(backDate) {
		if (backDate == "nobike") {
			$('#feedbackTips').html("<strong>没有该车辆的相关信息，请检查车辆编号是否正确！</strong>");
			return;
		} else if (backDate == "fail") {
			alert("请先登陆！")
		} else {
			alert("反馈成功！")
		}
		showFeedback()

	}
	;
	doAjax(url, data, success)
}
//充值
function doRecharge() {

	var url = "/user/recharge";
	var data = {
		"number" : $('#rechargeCount').val()
	};
	function success(backData) {
		if (backData != -1) {
			number = parseInt(backData);
			showWallet();
			return;
		}
		alert("请先登陆!");
	}

	doAjax(url, data, success);
}

/* 开始骑行检查定时器 */
function stratTimerCR() {
	timerCR = window.setTimeout(checkRiding);
}

/* 检查骑行状态 */
function checkRiding() {

	$.ajax({
		type : "get",
		url : "/user/checkRiding",
		success : function success(backData) {
			if (backData.status == "1") {
				return;
			} else {
				clearTimeout(timerCR);//停止扫描				
				var startTime = parseInt(backData.startTime);
				s = startTime / 1000;
				m = s / 60;
				h = m / 60;
				m = m % 60;
				s = s % 60;
				s = Math.floor(s);
				m = Math.floor(m);
				h = Math.floor(h);
			}
		}
	})
}

//检查骑行状态
function checkRidingStatus() {
	var url = "/user/checkRidingStatus";
	function success(backData) {
		
		if(backData.ridingStatus==""){
			alert("您还开始骑行，现在就去扫码开锁吧！")
		}else if (backData.ridingStatus == "0") {
			showTimer();
		} else if(backData.ridingStatus == "1"){
			$('#payCount').text(backData.payCount);
			showUserPay();
		}
	};
	
	doAjax(url,null,success)
}
