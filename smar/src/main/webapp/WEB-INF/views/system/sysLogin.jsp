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
            <li class="active">登录日志</li>
        </ul><!-- .breadcrumb -->
    </div>
    <div class="page-content">
        <div class="row">
            <div class="col-xs-12">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="table-responsive">
                            <table id="tab_sysLogin" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th style="width: 80px;text-align: center">
                                        编号
                                    </th>
                                    <th>登录账号</th>
                                    <th>类型</th>
                                    <th>登录时间</th>
                                    <th>登录IP</th>
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
<script type="text/javascript" src="<%=contextPath%>/assets/js/system/sysLogin.js"></script>