<%@ page language="java" pageEncoding="UTF-8" %>
<div class="modal fade" id="modal_user" data-backdrop="static">
    <div class="modal-dialog modal-hg">
        <div class="modal-content border-none">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">&times;</button>
                <h3 class="modal-title">用户信息</h3>
            </div>
            <div class="modal-body">
                <div class="col-md-12 marbot10">
                    <form id="form_condition" name="form_condition"  class="form-horizontal" method="POST" role="form">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">编号：</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="i_id" disabled>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">用戶名：</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="i_userName">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">账号：</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="i_account">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">是否启用：</label>

                                <div class="col-sm-8">
                                    <select type="text" class="form-control" id="s_disable">
                                        <option value="0">启用</option>
                                        <option value="1">禁用</option>
                                        </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">账号描述：</label>
                                <div class="col-sm-8">
                                    <textarea class="form-control" id="tt_desc"></textarea>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer" style="clear: both;">
                <button type="button" class="btn btn-primary" id="btn_user_save">
                    <i class="fa fa-check-circle"></i> 保存
                </button>
                <a href="#" class="btn btn-default" data-dismiss="modal"><i
                        class="fa fa-times"></i> 取消</a>
            </div>
        </div>
    </div>
</div>
