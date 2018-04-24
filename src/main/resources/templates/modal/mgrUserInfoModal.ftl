<!-- 模态框 引用bootstrap -->
		<div id="userInfoModal1" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">

					<!--head-->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
						<h3 class="modal-title text-center">
						<span class="glyphicon glyphicon-user"></span>
					</h3>
					</div>

					<!--body-->
					<div class="modal-body">

						<div class="row">
							<div class="col-xs-12 col-xs-offset-2">
								<input type="text" name="userinfophone" id="userinfo_phone" placeholder="填手机号^o^" class="form-control" />
							</div>
						</div>

						<div class="row">
							<div class="col-xs-12 col-xs-offset-2">
								<select class="form-control" name="" id="userinfo_status">
									<option value="">请选择骑行状态</option>								
								</select>
							</div>
						</div>

					</div>

					<!--foot-->
					<div class="modal-footer">
						<!--验证信息-->
						<button type="button" id="userinfoBtn" class="btn btn-success" onclick="edit_baseinfo()">
						<span class="glyphicon glyphicon-phone"></span>提交
					</button>
					</div>
				</div>
			</div>
		</div>
		