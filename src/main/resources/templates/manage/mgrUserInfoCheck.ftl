<div class="container" id="user-find">
	<h4 class="page-header">注意：只能根据任意一个查询条件进行查询</h4>
	<div class="form-horizontal">
		<div class="form-group form-group-xs">
			<label class="col-xs-4 text-right">身份证号码：</label>
			<div class="col-xs-3">
				<input class="form-control" name="baseinfo-find-one"
					id="baseinfo-find-one" />
			</div>
			<div class="col-xs-5">
				<button class="btn btn-default"
					onclick="find_user('baseinfo-find-one')">查询</button>
			</div>
		</div>
		<div class="form-group form-group-xs">
			<label class="col-xs-4 text-right">用户编号：</label>
			<div class="col-xs-3">
				<input class="form-control" name="baseinfo-find-two"
					id="baseinfo-find-two" />
			</div>
			<div class="col-xs-5">
				<button class="btn btn-default"
					onclick="find_user('baseinfo-find-two')">查询</button>
			</div>
		</div>
	</div>
</div>