<%@ page language="java" pageEncoding="UTF-8" %>
<div class="modal fade" id="modal-skin" data-backdrop="static">
    <div class="modal-dialog modal-hg">
        <div class="modal-content border-none">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">&times;</button>
                <h3 class="modal-title">颜色主题</h3>
            </div>
            <div class="modal-body">
                <div class="col-md-12 marbot10">
                    <div>
                        <select id="skin-colorpicker" style="color: #222A2D;">
                            <option data-skin="default" value="#438EB9">默认颜色</option>
                            <option data-skin="skin-1" value="#222A2D">传统黑色</option>
                            <option data-skin="skin-2" value="#C6487E">流水彩色</option>
                            <option data-skin="skin-3" value="#D0D0D0">传统灰色</option>
                        </select>
                    </div>

                </div>
            </div>
            <div class="modal-footer" style="clear: both;">
                <button type="button" class="btn btn-primary" id="btn_skin">
                    <i class="fa fa-check-circle"></i> 保存
                </button>
                <a href="#" class="btn btn-default" data-dismiss="modal"><i
                        class="fa fa-times"></i> 取消</a>
            </div>
        </div>
    </div>
</div>
