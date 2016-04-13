<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../common/taglibs.jsp" %>
<%
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="renderer" content="webkit">
    <%--<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">--%>
    <link rel="stylesheet" href="<%=contextPath%>/css/base.css">
    <link rel="stylesheet" href="<%=contextPath%>/css/common.css">
    <link rel="icon" href="favicon.ico" />
    <link rel="shortcut icon" href="<%=contextPath%>/favicon.ico" />
    <link type="text/css" rel="stylesheet" href="<%=contextPath%>/assets/css/ztree/zTreeStyle/zTreeStyle.css">
    <link type="text/css" rel="stylesheet" href="<%=contextPath%>/assets/js/datatables/css/dataTables.bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="<%=contextPath%>/assets/js/datatables/css/jquery.dataTables.min.css">
    <title>瑞丽航空协作办公平台</title>
</head>
<body>

<input type="hidden" id="basePath" value="<%=contextPath%>"/>
<div class="ui-top-bar-bg">
    <div class="ui-top-bar fn-clear">
        <div class="ui-top-bar-title fn-left">
            系统设置
        </div>
        <div class="ui-top-bar-list fn-left" id="workflow-header-list">
            <ul class="ui-tab-side">
                <li onclick="window.location.href='<%=contextPath%>/sys/user/index'">
                    <%--<a href="<%=contextPath%>/sys/user/index">--%>
                        <i >
                    </i>
                        <span>用户管理</span></a>
                </li>
                <li class="on" onclick="window.location.href='<%=contextPath%>/role/index'">
                    <%--<a href="<%=contextPath%>/role/index">--%>
                        <i>

                        </i>
                        <span>角色管理</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="wrap" id="content-body">
    <div class="ui-content-box">
    <div style="margin-left: 0px;margin-top: 0px;">
        <a class="ui-btn" id="btn_add">
            <span class="fa fa-plus"></span> 新增角色
        </a>
    </div>
    <div>
        <table id="tab_roleList" class="ui-data-grid">
            <thead>
            <tr>
                <th>角色编号</th>
                <th>角色名称</th>
                <th>角色描述</th>
                <th>bank</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
        </div>
    <%@include file="../common/footer.jsp" %>
</div>

<script type="text/javascript" src="<%=contextPath%>/assets/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/assets/js/datatables/assets/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/assets/js/layers/layer.js"></script>
<script type="text/javascript" src="<%=contextPath%>/assets/js/ztree/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/assets/js/ztree/jquery.ztree.excheck-3.5.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/assets/js/system/role.js"></script>
