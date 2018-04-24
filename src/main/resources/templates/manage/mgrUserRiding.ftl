<div class="panel panel-default">
	<!-- 用户用车记录查询 -->
	<div class="row">
		<div class="col-sm-1"></div>

		<span class="col-sm-1 text-right">用户编号:</span> <input class="col-sm-2"
			type="" name="" id="riding_userId" value="" /> <span
			class="col-sm-1 text-right">骑行状态:</span> <select
			class="col-sm-2 " id="riding_status">
			<option value="">请选择</option>			
		</select>

		<div class="col-sm-1"></div>

		<button class="col-sm-1 btn-info"
			onclick="update_table2('riding_userId','riding_status')">查询</button>
	</div>
	<hr>
	<!-- Table -->
	<div class="ridingList">
		<table id="user-riding"></table>
		<div id="user-riding-nav"></div>
	</div>
</div>