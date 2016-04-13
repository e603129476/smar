<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../common/header.jsp" %>
<%@include file="../common/menu.jsp" %>
<div class="main-content">
    <div class="breadcrumbs" id="breadcrumbs">
        <ul class="breadcrumb">
            <li>
                <i class="icon-home home-icon"></i>
                <a href="/index">首页</a>
            </li>
            <li>
                <i></i>
                <a href="#">系统管理</a>
            </li>
            <li class="active">角色管理</li>
        </ul><!-- .breadcrumb -->
    </div>
    <div class="page-content">
        <div class="row">
            <div class="col-xs-12">
                <div class="row">
                    <div class="col-xs-12">
                        <div style="margin-left: 0px;margin-top: 0px;">
                            <a class="btn btn-primary marR10 btn-sm " id="btn_add">
                                <span class="fa fa-plus"></span> 新增角色
                            </a>
                        </div>
                        <div class="table-responsive">
                            <table id="tab_roleList" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th style="width: 80px;text-align: center">
                                        角色编号
                                        <%--<label>--%>
                                        <%--<input type="checkbox" class="ace" />--%>
                                        <%--<span class="lbl"></span>--%>
                                        <%--</label>--%>
                                    </th>
                                    <th>名称</th>
                                    <th>描述</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div><!-- /.page-content -->
</div>
<!-- /.main-content -->

<%@include file="modal-user.jsp" %>
<%@include file="../common/footer.jsp" %>
<script type="text/javascript" src="<%=contextPath%>/assets/js/system/role.js"></script>