<%@ page language="java" pageEncoding="UTF-8"%>
<div  class="modal fade" id="modal_resource_add" data-backdrop="static">
	<div class="modal-dialog modal-hg" >
		<div class="modal-content border-none">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				<h3 class="modal-title">新增资源</h3>
			</div>
			<div class="modal-body">
				<div class="col-md-12 marbot10">
					<form id="form_condition" name="form_condition"
						  class="form-horizontal" method="POST" role="form">
						<div class="col-md-12">
							<div class="form-group" hidden >
								<label class="col-sm-3 control-label">资源编号：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="i_id">
								</div>
							</div>
							<div class="form-group" >
								<label class="col-sm-3 control-label">资源名称：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="i_name">
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label class="col-sm-3 control-label">资源编码：</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="i_code">
								</div>
							</div>
						</div>
						<div class="col-md-12" hidden>
							<div class="form-group">
								<label class="col-sm-3 control-label">资源类型：</label>
								<div class="col-sm-8">
									<select id="s_type">
										<option value="1">模块</option>
										<option value="2">业务</option>
										<option value="3">功能</option>
									</select>
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label class="col-sm-3 control-label">资源说明：</label>
								<div class="col-sm-8">
									<textarea class="form-control" id="tt_desc"></textarea>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="modal-footer" style="clear: both;">
				<button type="button" class="btn btn-primary" id="btn_save">
					<i class="fa fa-check-circle"></i> 保存
				</button>
				<a href="#" class="btn btn-default" data-dismiss="modal" ><i
						class="fa fa-times"></i> 取消</a>
			</div>
		</div>
	</div>
</div>
