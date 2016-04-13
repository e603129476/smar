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
    <div>
        <form class="form-inline">
            <div class="form-group">
                <label class="control-label"> 账号:</label> <input class="input-large ui-autocomplete-input"
                                                                 id="i_condition" placeholder="输入账号或名字">
                <button id="btn_user_search" class="btn btn-default btn-sm">查询</button>
                <button id="btn_user_add" class="btn btn-primary marR10 btn-sm">新增</button>
                <button id="btn_user_delete" class="btn btn-danger marR10 btn-sm">删除</button>
            </div>
        </form>
    </div><!-- /.row -->
    <div class="row">
        <table id="tab_userList" class="col-sm-12">
            <thead>
            <tr>
                <th>编号</th>
                <th>用户名</th>
                <th>登录账号</th>
                <th>状态</th>
                <th>描述</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
        </div>
        </div>
</div>
<!-- /.main-content -->
</div><!-- /.main-container-inner -->
<div></div>
<%@include file="../common/footer.jsp" %>
<script type="text/javascript" src="<%=contextPath%>/assets/js/system/user.js"></script>

