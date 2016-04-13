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
            <li class="active">用户管理</li>
        </ul><!-- .breadcrumb -->
    </div>
    <div class="page-content">
        <div class="row">
            <div class="col-xs-12">
                <div class="row">
                    <div class="col-xs-12">

                        <%--<div class="table-header">--%>
                        <form class="form-inline">
                            <div class="form-group">
                                <label class="control-label"> 账号:</label> <input
                                    class="input-large ui-autocomplete-input"
                                    id="i_condition" placeholder="输入账号或名字">
                                <a id="btn_user_search" class="btn btn-default btn-sm">查询</a>
                                <a id="btn_user_add" class="btn btn-primary marR10 btn-sm">新增用户</a>
                                <%--<a id="btn_user_delete" class="btn btn-danger marR10 btn-sm">删除</a>--%>
                            </div>
                        </form>
                        <%--</div>--%>
                        <div class="table-responsive">
                            <table id="tab_userList" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th style="width: 80px;text-align: center">
                                        用户编号
                                        <%--<label>--%>
                                        <%--<input type="checkbox" class="ace" />--%>
                                        <%--<span class="lbl"></span>--%>
                                        <%--</label>--%>
                                    </th>
                                    <th>用户名</th>
                                    <th>登录账号</th>
                                    <th>状态</th>
                                    <th>描述</th>
                                    <th>创建时间</th>
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
<script type="text/javascript" src="<%=contextPath%>/assets/js/system/user.js"></script>