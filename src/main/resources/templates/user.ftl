<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="chrome=1">	
		<meta name="viewport" content="initial-scale=1.0, user-scalable=yes, width=device-width">
		<title>SBCMS用户平台</title>	    	
		<!--引入jqery-->
		<script type="text/javascript" src="/js/jquery-2.1.1.min.js" ></script>	
		<!-- 调用手机相机扫描二维码 -->
		<script type="text/javascript" src="/js/scan.js" ></script>	
		<!--离线bootstrap文件-->
		<script type="text/javascript" src="/js/bootstrap.min.js" ></script>		
		<link rel="stylesheet" href="/css/bootstrap.min.css" />
		
		<style type="text/css">
	      body,html,#container{
	        height: 100%;
	        margin: 0px;
	      }
	      #userHome{
	      	position: fixed;
	      	top:0;
	      	left: 0;
	      	z-index: 20;
	      }
	      #positioning{
	      	position: fixed;
	      	top:0;
	      	right: 0;
	      	z-index: 19;
	      }
	      .tips{
	      	display: none;
	      	position: fixed;
	      	top:60%;
	      	right: 50%;
	      	z-index: 25;
	      	color:black;
	      	font-size:20px;
	      }
	      #tip{
	      	top:0;
	      	right:0;
	      }
	      #scan{	      	
	      	position: fixed;
	      	botton:0px;
	      	left:50px;	      	
	      	z-index: 22;
	      }
	    </style>		
	</head>
	<body>
		<!--HOME-->
		<div class="dropdown" id="userHome">			
			<button class="btn btn-default dropdown-toggle" type="button" id="userHome" 
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
				<span class="glyphicon glyphicon-home"></span>
				HOME
			</button>
			<ul class="dropdown-menu" aria-labelledby="userHome">
				<li><a><span class="glyphicon glyphicon-home"></span><strong id="userName_home"></strong></a></li>
				<li role="separator" class="divider"></li>
			    <li><a onclick="showUserLogin()"><span class="glyphicon glyphicon-user"></span>注册/登陆</a></li>
			    <li role="separator" class="divider"></li>
			    <li><a onclick="checkRidingStatus()"><span class="glyphicon glyphicon-bell"></span>骑行状态</a></li>
			    <li role="separator" class="divider"></li>
			    <li><a onclick="showUserDeposit()"><span class="glyphicon glyphicon-bold"></span>缴纳/退还押金</a></li>
			    <li role="separator" class="divider"></li>
			    <li><a onclick="showWallet()"><span class="glyphicon glyphicon-usd"></span>钱包</a></li>			    
			    <li role="separator" class="divider"></li>
			    <li><a onclick="showFeedback()"><span class="glyphicon glyphicon-envelope"></span>反馈</a></li>
			 </ul>
		</div>
					
		<!-- 定位信息提示 -->
		<p class="tips" id="tip" ></p>
		<!-- 扫码信息提示 -->
		<p class="tips" id="scanTips" ></p>
		
		<!-- 扫一扫 -->
		<!--<div id="scan">
			<div id="support"></div>  
			<div id="contentHolder">    
				<video id="video" width="320" height="320" autoplay></video>         
				<canvas style="display:none; background-color:#F00;" id="canvas" width="320" height="320"></canvas> <br/>  
				<button id="snap" style="display:none; height:50px; width:120px;">开始扫描</button>    
			</div>
		</div>-->
					
		<!--地图容器-->
		<div id="container" tabindex="0"></div>
					
		<!-- 登陆模态框 -->
		<div id="userLogin" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					
					<!--head-->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h3 class="modal-title text-center">
							<span class="glyphicon glyphicon-user">登陆</span>
						</h3>
					</div>
					
					<!--body-->
					<div class="modal-body">
						
						<div class="row">
							<div class="col-xs-12 col-xs-offset-2">
								<input type="text" name="userName_login" id="userName_login" placeholder="用户名^o^" class="form-control" />							
							</div>
						</div>
						
						<div class="row">
							<div class="col-xs-12 col-xs-offset-2">								
								<input type="password" name="password_login" id="password_login" placeholder="请输入密码^o^" class="form-control"/>	
								<span id="errorInfo_login">
									
								</span>
							</div>
						</div>
															
					</div>
					
					<!--foot-->
					<div class="modal-footer">				
						<button type="button" id="userinfoRegist" class="btn btn-success" onclick="showUserRegist()">
							<span class="glyphicon glyphicon-phone"></span> 注册
						</button>
						<button type="button" id="userinfoLogin" class="btn btn-success" onclick="doUserLogin()">
							<span class="glyphicon glyphicon-phone"></span>登陆
						</button>
					</div>
				</div>
			</div>
		</div>
					
		<!--注册模态框-->
		<div id="userRegist" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					
					<!--head-->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h3 class="modal-title text-center">
							<span class="glyphicon glyphicon-user">注册</span>
						</h3>
					</div>
					
					<!--body-->
					<div class="modal-body">
						
						<div class="row">
							<div class="col-xs-12 col-xs-offset-2">
								<input type="text" name="userName_regist" id="userName_regist" placeholder="用户名^o^" class="form-control" />
								<input type="number" name="userPhone_regist" id="userPhone_regist" placeholder="手机11位号码^o^" class="form-control"/>
							</div>
						</div>
						
						<div class="row">
							<div class="col-xs-12 col-xs-offset-2">								
								<input type="password" name="password_regist" id="password_regist" placeholder="密码^o^" class="form-control"/>
								<input type="password" name="passwordAgain_regist" id="passwordAgain_regist" placeholder="请确认您的密码^o^" class="form-control"/>
								<span id="errorInfo_regist"></span>
							</div>
						</div>
															
					</div>
					
					<!--foot-->
					<div class="modal-footer">				
						<button type="button" id="userinfoRegist" class="btn btn-success" onclick="doUserRegist()">
							<span class="glyphicon glyphicon-phone"></span> 立即注册
						</button>

					</div>
				</div>
			</div>
		</div>
		
		<!--押金模态框-->
		<div id="userDeposit" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					
					<!--head-->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h3 class="modal-title text-center">
							<span class="glyphicon glyphicon-user">押金</span>
						</h3>
					</div>
					
					<!--body-->
					<div class="modal-body">
						
						<div class="row">
							<div class="col-xs-12 col-xs-offset-2">	
								<span id="depositTip">
									押金金额为：299元
								</span>
							</div>
						</div>											
					</div>
					
					<!--foot-->
					<div class="modal-footer">				
						<button type="button" id="userinfoDeposit" class="btn btn-success" onclick="doUserDeposit()">
							<span class="glyphicon glyphicon-phone"></span> 缴纳押金
						</button>
						<button type="button" id="userinfoRefund" class="btn btn-success" onclick="doUserRefund()">
							<span class="glyphicon glyphicon-phone"></span> 退押金
						</button>

					</div>
				</div>
			</div>
		</div>
		
		<!--付款模态框-->
		<div id="userPay" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					
					<!--head-->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h3 class="modal-title text-center">
							<span class="glyphicon glyphicon-user">付款</span>
						</h3>
					</div>
					
					<!--body-->
					<div class="modal-body">
						
						<div class="row">
							<div class="col-xs-6 col-xs-offset-2">	
								这次骑行共花费：<span id="payCount">0</span>元
							</div>
							<div class="col-xs-6 col-xs-offset-2">	
								<input type="password" name="password_pay" id="password_pay" placeholder="请输入付款码！" class="form-control"/>
							</div>
						</div>											
					</div>
					
					<!--foot-->
					<div class="modal-footer">				
						<button type="button" id="userinfoPay" class="btn btn-success" onclick="doUserPay()">
							<span class="glyphicon glyphicon-phone"></span> 立即付款
						</button>
						
					</div>
				</div>
			</div>
		</div>
		
		<!--计时模态框-->
		<div id="timer" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					
					<!--head-->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h3 class="modal-title text-center">
							<span class="glyphicon glyphicon-user">计时计费</span>
						</h3>
					</div>
					
					<!--body-->
					<div class="modal-body">
						
						<div class="row">
							<div class="col-xs-12 col-xs-offset-2">	
								<span>已骑行时间：</span>
								<span id="clockh">0:</span>
								<span id="clockm">0:</span>
								<span id="clocks">0</span>
							</div>
						</div>											
					</div>
					
					<!--foot-->
					<div class="modal-footer">				
						<button type="button" id="userinfoRiding" class="btn btn-success" onclick="doRidingStop()">
							<span class="glyphicon glyphicon-phone"></span> 结束骑行，关上车锁
						</button>
						
					</div>
				</div>
			</div>
		</div>
		
		<!--反馈模态框-->
		<div id="feedback" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					
					<!--head-->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h3 class="modal-title text-center">
							<span class="glyphicon glyphicon-user">用户反馈</span>
						</h3>
					</div>
					
					<!--body-->
					<div class="modal-body">
						
						<div class="row">
							<div class="col-xs-3 col-xs-offset-2">	
								<select class="form-control" id="feedbackType" onchange="fdHidden()">
									<option value="">请选择反馈类型</option>									
								</select>
							</div>
							<div class="col-xs-6 col-xs-offset-2">
								<input type="text" name="" id="content" placeholder="请写如您的意见！" class="form-control" />	
								<input type="text" name="" id="bicycleId" placeholder="请输入车辆编号!" class="form-control" />
								<span id="feedbackTips" style="color:red"></span>
							</div>
							<div class="col-xs-3 col-xs-offset-2">	
								<select class="form-control" id="damageType">
									<option value="">请选择损坏类型</option>									
								</select>
							</div>
						</div>											
					</div>
					
					<!--foot-->
					<div class="modal-footer">				
						<button type="button" id="userinfoFeedback" class="btn btn-success" onclick="doFeedback()">
							<span class="glyphicon glyphicon-phone"></span>立即反馈
						</button>
						
					</div>
				</div>
			</div>
		</div>
		
		<!--钱包模态框-->
		<div id="wallet" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					
					<!--head-->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h3 class="modal-title text-center">
							<span class="glyphicon glyphicon-user">钱包</span>
						</h3>
					</div>
					
					<!--body-->
					<div class="modal-body">
						
						<div class="row">
							<div class="col-xs-12 col-xs-offset-2">
								余额:<span id="money"></span>	元
								<input type="number" id="rechargeCount" placeholder="请输入充值金额！" style="float:right"/>								
							</div>							
						</div>											
					</div>
					
					<!--foot-->
					<div class="modal-footer">				
						<button type="button" id="userinfoRecharge" class="btn btn-success" onclick="doRecharge()">
							<span class="glyphicon glyphicon-phone"></span>充值
						</button>
					
					</div>
				</div>
			</div>
		</div>
			
		<!--引入高德地图api-->
		<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.4.4&key=f929f85b748d6e6eb11099449793ba32"></script>
		<script src="http://webapi.amap.com/loca?key=f929f85b748d6e6eb11099449793ba32"></script>				
		<script type="text/javascript">
			var message = '${message}'; // 权限信息
			var lgInfo = '${lgInfo}'; // 未登录时应为0，登陆了为1
			var vip ='${vip}';
			var number=parseInt('${number}');
			var name = '${name}';
			$('#userName_home').text(name);
		</script>
		<script type="text/javascript" src="/js/user.js" ></script>
	</body>
</html>
