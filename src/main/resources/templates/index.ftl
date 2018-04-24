<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no" />
		<title>SBCMS管理后台</title>
		<link rel="stylesheet" href="/css/mycss2.css" />				
		<link rel="stylesheet" href="/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/css/ui.jqgrid.css" />
		<!--引入字体库-->
		<link rel="stylesheet" href="/css/font-awesome/css/font-awesome.min.css" />
		<!--引入JQuery-->
		<script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
		<!--引入bootstrap-->
		<script type="text/javascript" src="/js/bootstrap.min.js"></script>
		<!--引入jdgrid-->
		<script type="text/javascript" src="/js/i18n/grid.locale-cn.js"></script>
		<script type="text/javascript" src="/js/jquery.jqGrid.min.js"></script>
		<!--引入高德地图api-->
		<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.4.4&key=f929f85b748d6e6eb11099449793ba32"></script>
		<script src="http://webapi.amap.com/loca?key=f929f85b748d6e6eb11099449793ba32"></script>
		<!-- UI组件库 1.0 -->
    	<script src="//webapi.amap.com/ui/1.0/main.js?v=1.0.11"></script>

	</head>

	<body>
		<!-- 顶部信息栏-->
		<div class="container-fluid" style="position: fixed; top: 0; z-index: 20; width: 100%;">
			<div class="row">
				<div class="col-sm-2 text-center" style="padding-right: 0px;">
					<div class="left-nav" style="line-height: 30px;">
						<i class="fa fa-bicycle"></i> <span class="text-center">共享单车后台管理系统</span>
						<i class="fa fa-toggle-off" id="i-sidenav" style="padding-left: 15px;"></i>
					</div>
				</div>
				<div class="col-sm-10 text-right" style="padding-left: 0px;">
					<div class="right-nav" style="">
						<ul class="list-inline" style="line-height: 30px;">
							<li class=""><i class="fa fa-unlink"></i>
								<a href="" style="color: #FFFFFF">登陆</a>
							</li>
							<li class=""><i class="fa fa-registered"></i>
								<a href="" style="color: #FFFFFF">注册</a>
							</li>
							<li class=""><i class="fa fa-upload"></i>
								<a href="" style="color: #FFFFFF">退出登陆</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 主要内容 -->
		<#include "manage/mgrMain.ftl">
			
		<!-- 底部信息栏-->
		<div class="container-fluid" style="position: fixed; bottom: 0; z-index: 20; width: 100%;">
			<div class="row">
				<div class="col-sm-2 text-center" style="padding-right: 0px;">
					<div class="left-foot">
						<i class="fa fa-"></i>
					</div>
				</div>
				<div class="col-sm-10 text-right" style="padding-left: 0px;">
					<div class="right-foot">尾部</div>
				</div>
			</div>
		</div>

		<!-- 模态框  -->
		<#include "modal/mgrUserInfoModal.ftl">
		<#include "modal/ouput.ftl">
		<#include "modal/fixTypeModal.ftl">
		
		<!--自定义js-->
		<script type="text/javascript" src="/js/paramInit.js"></script>
		<script type="text/javascript" src="/js/index.js"></script>
		<script type="text/javascript" src="/js/manageMap.js"></script>
		<script type="text/javascript" src="/js/manageTable.js"></script>
		<script type="text/javascript" >
			/* 兼容toggle()绑定多事件 */
			$.fn.toggle = function(fn, fn2) {
				var args = arguments, guid = fn.guid || $.guid++, i = 0, toggle = function(
						event) {
					var lastToggle = ($._data(this, "lastToggle" + fn.guid) || 0) % i;
					$._data(this, "lastToggle" + fn.guid, lastToggle + 1);
					event.preventDefault();
					return args[lastToggle].apply(this, arguments) || false;
				};
				toggle.guid = guid;
				while (i < args.length) {
					args[i++].guid = guid;
				}
				return this.click(toggle);
			};
			
			/* 信息展示互调 */
			function change(e_none, e_block) {
				$('#' + e_none).attr('style', "display: none;");
				$('#' + e_block).attr('style', "display: block;");
			}

			/* 模态框处理 */
			function edit_baseinfo() {
				alert($('#userinfo_phone').val());
				alert($('#userinfo_status').val());
				// update_baseInfo();
			}

			/* 基本框架 */
			function show(e) {
				$('.curry').attr("style", "display: none;").removeClass('curry');
				$('#' + e).attr("style", "display: block;").addClass('curry');
			}

			/* 隐藏侧边栏 */
			$('#i-sidenav').toggle(function() {
				$('#side-nav').hide();
				$('#main').attr('class', "col-sm-12");
				$('.right-main').attr('style', "width: 100%;");
				$(this).attr('class', "fa fa-toggle-on");
			}, function() {
				$('#main').attr('class', "col-sm-10");
				$('#side-nav').show();
				$(this).attr('class', "fa fa-toggle-off");
			});
		</script>
	</body>

</html>