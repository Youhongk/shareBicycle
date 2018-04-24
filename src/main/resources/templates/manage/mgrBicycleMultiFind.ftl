
<div role="tabpanel" class="tab-pane" id="output">
	<div class="container">
		<div class="form-horizontal">
			<div class="form-group form-group-xs">
				<label class="col-xs-4 text-right">车辆编号：</label>
				<div class="col-xs-3">
					<input class="form-control" id="bicycleIdInfo" />
				</div>
				<div class="col-xs-5">
					<button class="btn btn-default" onclick="find_bicycleId()">查询</button>
				</div>
			</div>

			<div class="form-group form-group-xs">
				<label class="col-xs-4 text-right">车辆状态：</label>
				<div class="col-xs-3">
					<select class="form-control" id="bicycleStatusInfo">
						<option>请选择</option>
						<option value="1">待入仓</option>
						<option value="2">待入库</option>
						<option value="3">待投放</option>
						<option value="6">带回收</option>
						<option value="7">待维修</option>
						<option value="8">报废</option>
					</select>
				</div>
				<div class="col-xs-5">
					<button class="btn btn-default" onclick="find_bicycleStatus()">查询</button>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<div class="main" id="main">
					<!--jqGrid所在-->
					<table id="grid-table"></table>
					<!--jqGrid 浏览导航栏所在-->
					<div id="grid-pager"></div>
				</div>
			</div>
		</div>
	</div>
</div>
