<div role="tabpanel" class="tab-pane" id="recycle">
	<br />
	<div class="form-horizontal">
		<div class="form-group form-group-xs">
			<label class="col-xs-4 text-right">车辆编号：</label>
			<div class="col-xs-3">
				<input class="form-control" id="bicycleIdRecycle" />
			</div>
			<div class="col-xs-5">
				<button class="btn btn-default" onclick="recycle_find()">查询</button>
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
			<td id="recycle_bicycleId"></td>
			<td id="recycle_bicycleStatus"></td>
			<td >
				<button id="recycle_opera" class="btn btn-info"
					onclick="recycle()">回收</button>
			</td>
		</tr>
	</table>
</div>