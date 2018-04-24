
<!-- 主要内容-->
<div class="container-fluid" style="margin-top: 30px;">
	<div class="row" id="main_one">

		<div class="col-sm-2" id="side-nav">
			<!--左侧导航栏-->
			<div class="list-group">
				<a href="#" class="list-group-item text-left"
					onclick="show('homea')"><i class="fa fa-apple"
					style="float: left; margin-top: 2px; margin-right: 2px;"></i><span>首页</span><i
					class="fa fa-caret-right" style="float: right"></i></a> <a href="#"
					class="list-group-item text-left" onclick="show('bicycle')"><i
					class="fa fa-bicycle"
					style="float: left; margin-top: 2px; margin-right: 2px;"></i><span>车辆管理</span><i
					class="fa fa-caret-right" style="float: right"></i></a> <a href="#"
					class="list-group-item text-left" onclick="show('user')"><i
					class="fa fa-user"
					style="float: left; margin-top: 2px; margin-right: 2px;"></i><span>用户管理</span><i
					class="fa fa-caret-right" style="float: right"></i></a> <a href="#"
					class="list-group-item text-left" onclick="show('wallet')"><i
					class="fa fa-money"
					style="float: left; margin-top: 2px; margin-right: 2px;"></i><span>钱包管理</span><i
					class="fa fa-caret-right" style="float: right"></i></a> <a href="#"
					class="list-group-item text-left" onclick="show('system')"><i
					class="fa fa-laptop"
					style="float: left; margin-top: 2px; margin-right: 2px;"></i><span>系统维护</span><i
					class="fa fa-caret-right" style="float: right"></i></a>
			</div>
		</div>

		<div class="col-sm-10" id="main">
			<main class="right-main"> 
				<!-- 首页 -->
				<div id="homea" style="display: block;" class="curry">
					<ul class="nav nav-tabs" role="tablist" id="nav-tabs-one">
						<li role="presentation" class="active"><a href="#home"
							aria-controls="home" role="tab" data-toggle="tab">首页</a></li>
					</ul>
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="home"
							style="height: 647px; background: url(/img/promo-04.jpg);"></div>
					</div>
				</div>
	
				<!-- 车辆管理选项 -->
				<div id="bicycle" style="display: none;">
	
					<ul class="nav nav-tabs" role="tablist" id="nav-tabs-one">				
						<li role="presentation"><a href="#mapModal"
							aria-controls="mapModal" role="tab" data-toggle="tab">车辆实时位置地图</a></li>
						<li role="presentation"><a href="#output"
							aria-controls="output" role="tab" data-toggle="tab">车辆综合处理</a></li>
						<li role="presentation"><a href="#recycle"
							aria-controls="recycle" role="tab" data-toggle="tab">车辆回收处理</a></li>
						<li role="presentation"><a href="#fix" aria-controls="fix"
							role="tab" data-toggle="tab">车辆维修登记</a></li>
					</ul>
	
					<div class="tab-content">
											
						<!-- 地图 -->
						<#include "mgrBicycleMap.ftl">
						
						<!-- 综合查询处理 -->
						<#include "mgrBicycleMultiFind.ftl">
					
						<!-- 回收 -->
						<#include "mgrBicycleRecycle.ftl">						
	
						<!--维修-->
						<#include "mgrBicycleFix.ftl">	
						
					</div>
	
				</div>
	
				<!-- 用户管理选项-->
				<div id="user" style="display: none;">
	
					<ul class="nav nav-tabs" role="tablist" id="nav-tabs-three">
						<li role="presentation" class="active"><a href="#baseinfo"
							aria-controls="baseinfo" role="tab" data-toggle="tab">用户信息查询</a></li>
						<li role="presentation"><a href="#bicycleinfo"
							aria-controls="bicycleinfo" role="tab" data-toggle="tab">用户用车查询</a>
						</li>
						<li role="presentation"><a href="#feedbackinfo"
							aria-controls="feedbackinfo" role="tab" data-toggle="tab">用户反馈查询</a>
						</li>
					</ul>
	
					<div class="tab-content">
						<!-- 信息管理 -->						
						<div role="tabpanel" class="tab-pane active" id="baseinfo">	
							<!--用户基本信息查询页-->
							<#include "mgrUserInfoCheck.ftl">							
							<!--用户基本信息展示页-->
							<#include "mgrUserInfo.ftl">							
						</div>	
						<!-- 骑行管理 -->					
						<div role="tabpanel" class="tab-pane" id="bicycleinfo">
							<#include "mgrUserRiding.ftl">				
						</div>	
						<!-- 反馈管理 -->
						<div role="tabpanel" class="tab-pane" id="feedbackinfo">
							<#include "mgrUserFeedback.ftl">
						</div>
					</div>
				</div>
	
				<!-- 钱包管理选项-->
				<div id="wallet" style="display: none;">
					<ul class="nav nav-tabs" role="tablist" id="nav-tabs-four">
						<li role="presentation" class="active"><a href="#deposit"
							aria-controls="deposit" role="tab" data-toggle="tab">押金管理</a></li>
						<li role="presentation"><a href="#balance"
							aria-controls="balance" role="tab" data-toggle="tab">余额管理</a></li>
					</ul>
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="deposit">
							<div class="form-horizontal">
								<div class="form-group form-group-xs">
									<label class="col-xs-4 text-right">用户账户：</label>
									<div class="col-xs-3">
										<input class="form-control" name="find-wallet" id="find-wallet" />
									</div>
									<div class="col-xs-5">
										<button class="btn btn-default"
											onclick="find_bicycle('find-wallet','find_walletInfo')">查询</button>
									</div>
								</div>
								<!-- Table -->
								<div class="ridingList">
									<table id="user-riding"></table>
									<div id="user-riding-nav"></div>
								</div>
							</div>
						</div>
						<div role="tabpanel" class="tab-pane" id="balance">
							<div class="form-horizontal">
								<div class="form-group form-group-xs">
									<label class="col-xs-4 text-right">车辆编号：</label>
									<div class="col-xs-3">
										<input class="form-control" name="find-one" id="find-one" />
									</div>
									<div class="col-xs-5">
										<button class="btn btn-default"
											onclick="find_bicycle('find-one','find_bicycleInfo')">查询</button>
									</div>
								</div>
								<div class="form-group form-group-xs">
									<label class="col-xs-4 text-right">车辆实时坐标：</label>
									<div class="col-xs-3">
										<input class="form-control" name="find-one" id="find-two" />
									</div>
									<div class="col-xs-5">
										<button class="btn btn-default"
											onclick="find_bicycle('find-two','find_bicycleMap')">查询</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
	
				<!-- 系统管理选项-->
				<div id="system" style="display: none;">
					<ul class="nav nav-tabs" role="tablist" id="nav-tabs-two">
						<li role="presentation" class="active"><a href="#ware"
							aria-controls="ware" role="tab" data-toggle="tab">车辆入仓</a></li>
						<li role="presentation"><a href="#house" aria-controls="house"
							role="tab" data-toggle="tab">车辆入库</a></li>
					</ul>
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="ware">车辆入仓</div>
						<div role="tabpanel" class="tab-pane" id="house">车辆入库</div>
					</div>
				</div>

			</main>
		</div>

	</div>
</div>