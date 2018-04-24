<div role="tabpanel" class="tab-pane" id="fix">
	<br />
	<div class="form-horizontal">
		<div class="form-group form-group-xs">
			<label class="col-xs-4 text-right">车辆编号：</label>
			<div class="col-xs-3">
				<input class="form-control" id="bicycleIdFix" />
			</div>
			<div class="col-xs-5">
				<button class="btn btn-default" onclick="fix_find()">查询</button>
			</div>
		</div>
	</div>
	<hr />
	<table
		class="table table-bordered table-condensed table-striped table-hover">
		<tr>
			<td>车辆编号</td>
			<td>车辆状态</td>
			<td>操作</td>
		</tr>
		<tr>
			<td id="fix_bicycleId"></td>
			<td id="fix_bicycleStatus"></td>
			<td id="fix_opera">
				<button id="storage" class="btn btn-info"
					onclick="storage()">重新入库</button>
				<button id="destory" class="btn btn-danger"
					onclick="destory()">报废</button>
			</td>
		</tr>
	</table>
</div>