<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="row">
		<div class="col-sm-1"></div>
		
		<span class="col-sm-1 text-right">用户编号:</span> <input class="col-sm-2"
			type="" name="" id="feedback_userId" value="" /> <span
			class="col-sm-1 text-right">反馈状态:</span> <input class="col-sm-2" type=""
			name="" id="feedback_status" value="" />
		
		<div class="col-sm-1"></div>
	
		<button class="col-sm-1 btn-info" onclick="update_table3('feedback_userId','feedback_status')">查询</button>
	</div>
	<hr>
	<!-- Table -->
	<div class="ridingList">
		<table id="user-feedback"></table>
		<div id="user-feedback-nav"></div>
	</div>
</div>
