<div id="fixTypeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">

			<!--head-->
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h3 class="modal-title text-center">
					<span class="glyphicon glyphicon-user">维修结果</span>
				</h3>
			</div>

			<!--body-->
			<div class="modal-body">

				<div class="row">
					<div class="col-xs-12 col-xs-offset-2">
						<select class="form-control" id="fix_type">
							<option>请选择维修结果</option>									
						</select>
					</div>
				</div>
			</div>

			<!--foot-->
			<div class="modal-footer">
				<button type="button" id="" class="btn btn-success"
					onclick="doFixAll()">
					<span class="glyphicon glyphicon-phone"></span> 确认维修结果
				</button>
			</div>
		</div>
	</div>
</div>
