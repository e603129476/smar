<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<%--<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">--%>
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/assets/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/assets/css/bootstrap-theme.min.css">
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/assets/css/ztree/zTreeStyle/zTreeStyle.css">
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/assets/js/iCheck/css/all.css">
<script type="text/javascript" src="<%=contextPath%>/assets/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" language="JavaScript"
        src="<%=contextPath%>/assets/js/bootstrap.min.js"></script>
<script type="text/javascript" language="JavaScript"
        src="<%=contextPath%>/assets/js/ztree/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" language="JavaScript"
        src="<%=contextPath%>/assets/js/iCheck/js/icheck.min.js"></script>
<script type="text/javascript" language="JavaScript"
        src="<%=contextPath%>/assets/js/layers/layer.js"></script>
<title>互助帮后台管理平台</title>
</head>
<body>
<input type="hidden" id="basePath" value="<%=contextPath%>"/>
<div class="container">
    <div id="wrapper" class="page-wrap">
        <div id="page-wrapper">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="<%=contextPath%>/">系统管理</a></li>
                    <li><a class="amenu">资源管理</a></li>
                </ol>
            </div>
            <div class="row">
                <div class="col-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">资源管理</div>
                        <div class="panel-body">
                            <div id="garage-show">
                                <div class="row martop1">
                                    <button type="button" class="btn btn-info btn-sm" id="btn_add">
                                        <span class="fa fa-plus"></span> 新增
                                    </button>
                                    <button type="button" class="btn btn-info btn-sm" id="btn_delete">
                                        <span class="fa fa-plus"></span> 删除
                                    </button>
                                    <button type="button" class="btn btn-info btn-sm" id="btn_edit">
                                        <span class="fa fa-plus"></span> 修改
                                    </button>
                                    <button type="button" class="btn btn-info btn-sm" id="btn_privilege">
                                        <span class="fa fa-plus"></span>权限定义
                                    </button>
                                </div>
                            </div>
                            <div class="row martop2">
                                <div class="zTreeDemoBackground left">
                                    <ul id="tr_resource"  class="ztree"></ul>
                                </div>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="modal-resource-add.jsp" %>
<%@include file="modal-resource-edit.jsp"%>
<%@include file="modal-resource-privilege.jsp"%>
<%@include file="../common/footer.jsp" %>
<script type="text/javascript" language="JavaScript" src="<%=contextPath%>/assets/js/system/resource.js"></script>