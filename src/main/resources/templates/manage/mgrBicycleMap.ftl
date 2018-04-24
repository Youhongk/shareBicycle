<div role="tabpanel" class="tab-pane" id="mapModal">

	<div class="row">
		<div class="col-xs-8">
			<!--选择区域查询-->
			<select id="regional">
				<option value="">请选择区域</option>
			</select>						
			<select id="bicycleStatus">
				<option value="">请选择车辆状态</option>
				<option value="4">可用</option>
				<option value="6">待回收</option>
			</select>
			<button class="btn btn-default"
				onclick="coordinates_bicycle('BR')">区域状态查询</button>
		</div>
		<div class="col-xs-4">
			<input type="text" id="bicycleId" placeholder="请输入车辆编号" />
			<button class="btn btn-default"
				onclick="coordinates_bicycle('bicycleId')">编号查询</button>
		</div>
	</div>

	<!--地图容器-->
	<div id="mapManager" style="height: 648px; width: 100%;"></div>
</div>