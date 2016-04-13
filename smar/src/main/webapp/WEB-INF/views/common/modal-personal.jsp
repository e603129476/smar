<%@ page language="java" pageEncoding="UTF-8" %>
<div class="modal fade" id="modal-personal" data-backdrop="static">
    <div class="modal-dialog modal-hg">
        <div class="modal-content border-none">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">&times;</button>
                <h3 class="modal-title">修改密码</h3>
            </div>
            <div class="modal-body">
                <div class="col-md-12 marbot10">
                    <form id="form_condition" name="form_condition"  class="form-horizontal" method="POST" role="form">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">原密码：</label>
                                <div class="col-sm-8">
                                    <input type="password" class="form-control" id="i_old">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">新密码：</label>
                                <div class="col-sm-8">
                                    <input type="password" class="form-control" id="i_new1">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">重复密码：</label>
                                <div class="col-sm-8">
                                    <input type="password" class="form-control" id="i_new2">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer" style="clear: both;">
                <button type="button" class="btn btn-primary" id="btn_password_save">
                    <i class="fa fa-check-circle"></i> 保存
                </button>
                <a href="#" class="btn btn-default" data-dismiss="modal"><i
                        class="fa fa-times"></i> 取消</a>
            </div>
        </div>
    </div>
</div>
