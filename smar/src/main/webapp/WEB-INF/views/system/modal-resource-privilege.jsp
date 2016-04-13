<%@ page language="java" pageEncoding="UTF-8" %>
<div class="modal fade" id="modal_resource_privilege" data-backdrop="static">
    <div class="modal-dialog modal-hg">
        <div class="modal-content border-none">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">&times;</button>
                <h3 class="modal-title">资源权限定义</h3>
            </div>
            <div class="modal-body">
                <div class="col-md-12 marbot10">
                    <form id="form_condition" name="form_condition"
                          class="form-horizontal" method="POST" role="form">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" id="ck_visit" name="checkGroup" value="2" checked="true">访问权限
                            </label>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" id="ck_create" name="checkGroup" value="5" checked="true">新增权限
                            </label>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" id="ck_delete" name="checkGroup" value="4" checked="true">删除权限
                            </label>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" id="ck_编辑" name="checkGroup" value="3" checked="true">编辑权限
                            </label>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" id="ck_view" name="checkGroup" value="1" checked="true">查看权限
                            </label>
                        </div>

                        <%--<div class="checkbox">--%>
                            <%--<label>--%>
                                <%--<input  type="checkbox" id="ck_delete" name="checkGroup" value="4" checked="true">删除权限--%>
                            <%--</label>--%>
                        <%--</div>--%>
                        <%--<div class="checkbox">--%>
                            <%--<label>--%>
                                <%--<input type="checkbox" id="ck_view" name="checkGroup" value="1" checked="true">查看权限--%>
                            <%--</label>--%>
                        <%--</div>--%>
                        <%--<div class="checkbox">--%>
                            <%--<label>--%>
                                <%--<input type="checkbox" id="ck_query" name="checkGroup">检索权限--%>
                            <%--</label>--%>
                        <%--</div>--%>
                        <%--<div class="checkbox">--%>
                            <%--<label>--%>
                                <%--<input type="checkbox" id="ck_print" name="checkGroup" value="7">打印权限--%>
                            <%--</label>--%>
                        <%--</div>--%>
                        <%--<div class="checkbox">--%>
                            <%--<label>--%>
                                <%--<input type="checkbox" id="ck_upload"  name="checkGroup" value="5">上传权限--%>
                            <%--</label>--%>
                        <%--</div>--%>
                        <%--<div class="checkbox">--%>
                            <%--<label>--%>
                                <%--<input type="checkbox" id="ck_download" name="checkGroup" value="6" >下载权限--%>
                            <%--</label>--%>
                        <%--</div>--%>
                    </form>
                </div>
            </div>
            <div class="modal-footer" style="clear: both;">
                <button type="button" class="btn btn-primary" id="btn_privilege_save">
                    <i class="fa fa-check-circle"></i> 保存
                </button>
                <a href="#" class="btn btn-default" data-dismiss="modal"><i
                        class="fa fa-times"></i> 取消</a>
            </div>
        </div>
    </div>
</div>
