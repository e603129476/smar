<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String contextPath = request.getContextPath();
%>
<%@include file="taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>互助帮后台管理平台</title>
    <meta name="keywords" content="智能家居,互助帮"/>
    <meta name="description" content="智能家居,互助帮"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <!-- basic styles -->
    <link href="<%=contextPath%>/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="<%=contextPath%>/assets/css/font-awesome.min.css"/>

    <!--[if IE 7]>
    <link rel="stylesheet" href="<%=contextPath%>/assets/css/font-awesome-ie7.min.css"/>
    <![endif]-->

    <!-- page specific plugin styles -->

    <link rel="stylesheet" href="<%=contextPath%>/assets/css/ace.min.css"/>
    <link rel="stylesheet" href="<%=contextPath%>/assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="<%=contextPath%>/assets/css/ace-skins.min.css"/>

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="<%=contextPath%>/assets/css/ace-ie.min.css"/>
    <![endif]-->

    <%--datatables--%>
    <link type="text/css" rel="stylesheet" href="<%=contextPath%>/assets/js/datatables/css/dataTables.bootstrap.css">
    <!-- inline styles related to this page -->
    <link type="text/css" rel="stylesheet" href="<%=contextPath%>/assets/css/ztree/zTreeStyle/zTreeStyle.css">

    <!-- ace settings handler -->
    <script src="<%=contextPath%>/assets/js/jquery-2.0.3.min.js"></script>
    <%--<script src="<%=contextPath%>/assets/js/ace-extra.min.js"></script>--%>
    <%--<script src="<%=contextPath%>/assets/js/html5shiv.js"></script>--%>
    <%--<script src="<%=contextPath%>/assets/js/respond.min.js"></script>--%>
    <%--<script src="<%=contextPath%>/assets/js/excanvas.min.js"></script>--%>
    <%--<script src="<%=contextPath%>/assets/js/jquery-ui-1.10.3.custom.min.js"></script>--%>
    <%--<script src="<%=contextPath%>/assets/js/jquery.ui.touch-punch.min.js"></script>--%>
    <%--<script src="<%=contextPath%>/assets/js/jquery.slimscroll.min.js"></script>--%>
    <%--<script src="<%=contextPath%>/assets/js/jquery.easy-pie-chart.min.js"></script>--%>
    <%--<script src="<%=contextPath%>/assets/js/jquery.sparkline.min.js"></script>--%>
    <%--<script src="<%=contextPath%>/assets/js/flot/jquery.flot.min.js"></script>--%>
    <%--<script src="<%=contextPath%>/assets/js/flot/jquery.flot.pie.min.js"></script>--%>
    <%--<script src="<%=contextPath%>/assets/js/flot/jquery.flot.resize.min.js"></script>--%>
    <%--<script src="<%=contextPath%>/assets/js/ace-elements.min.js"></script>--%>
    <%--<script src="<%=contextPath%>/assets/js/ace.min.js"></script>--%>
    <script src="<%=contextPath%>/assets/js/bootstrap.min.js"></script>
    <script src="<%=contextPath%>/assets/js/datatables/js/jquery.dataTables.min.js"></script>
    <script src="<%=contextPath%>/assets/js/datatables/js/dataTables.bootstrap.min.js"></script>
    <script src="<%=contextPath%>/assets/js/layers/layer.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/assets/js/ztree/jquery.ztree.core-3.5.min.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/assets/js/ztree/jquery.ztree.excheck-3.5.min.js"></script>
    <%--<script src="<%=contextPath%>/assets/js/datatables/js/dataTables.jqueryui.min.js"></script>--%>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!--[if lt IE 9]>

    <![endif]-->
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<input type="hidden" id="basePath" value="<%=contextPath%>">

<div class="navbar navbar-default" id="navbar">
    <script type="text/javascript">
        try {
            ace.settings.check('navbar', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="icon-leaf"></i>
                    互助帮后台管理平台
                </small>
            </a><!-- /.brand -->
        </div><!-- /.navbar-header -->

        <div class="navbar-header pull-right" style="position: absolute;right: 0px;bottom: 0px; role=" navigation
        ">
        <span style="color: white;">
            <i class="user-info"></i>
            欢迎你 管理员
        </span>
        <a id="a_change_skin" href="#" style="color: white;">
            <i class="icon-cog"></i>
            切换主题
        </a>
        <a id="a_personal" href="#" style="color: white;">
            <i class="icon-user"></i>
            修改密码
        </a>
        <a id="a_logout" href="#" style="color: white;">
            <i class="icon-off"></i>
            退出
        </a>
        <%--<ul class="nav ace-nav">--%>
        <%--<li>--%>
        <%--<a href="#">--%>
        <%--<i class="user-info"></i>--%>
        <%--欢迎你 管理员--%>
        <%--</a>--%>
        <%--</li>--%>
        <%--<li id="a_change_skin">--%>
        <%--<a   href="#" >--%>
        <%--<i class="icon-cog"></i>--%>
        <%--切换主题--%>
        <%--</a >--%>
        <%--</li>--%>
        <%--<li id="a_personal">--%>
        <%--<a href="#">--%>
        <%--<i class="icon-user"></i>--%>
        <%--修改密码--%>
        <%--</a>--%>
        <%--</li>--%>
        <%--<li id="a_logout">--%>
        <%--<a href="#">--%>
        <%--<i class="icon-off"></i>--%>
        <%--退出--%>
        <%--</a>--%>
        <%--</li>--%>
        <%--</ul><!-- /.ace-nav -->--%>
    </div><!-- /.navbar-header -->
</div><!-- /.container -->
</div>
<%@include file="modal-skin.jsp" %>
<%@include file="modal-personal.jsp" %>
<script type="text/javascript">
    $("#a_change_skin").on('click', function () {
        $("#modal-skin").modal("show");
    })
    $("#a_personal").on('click', function () {
        $("#modal-personal").modal("show");
    })
    $("#btn_password_save").on('click', function () {
        $("#modal-personal").modal("hide");
    })

    $("#a_logout").on('click', function () {
        var basePath = $("#basePath").val();
        $.ajax({
            async: false,
            type: "GET",
            url: basePath + "/userLogout",
            success: function (data) {
            },
            error: function () {
            }
        });
        window.location.href = basePath + "/login";
    })

    $("#btn_skin").on("click", function () {
        var d = $("#skin-colorpicker").find("option:selected").data("skin");
        var c = $(document.body);
        c.removeClass("skin-1 skin-2 skin-3");
        if (d != "default") {
            c.addClass(d)
        }
        if (d == "skin-1") {
            $(".ace-nav > li.grey").addClass("dark")
        } else {
            $(".ace-nav > li.grey").removeClass("dark")
        }
        if (d == "skin-2") {
            $(".ace-nav > li").addClass("no-border margin-1");
            $(".ace-nav > li:not(:last-child)").addClass("light-pink").find('> a > [class*="icon-"]').addClass("pink").end().eq(0).find(".badge").addClass("badge-warning")
        } else {
            $(".ace-nav > li").removeClass("no-border margin-1");
            $(".ace-nav > li:not(:last-child)").removeClass("light-pink").find('> a > [class*="icon-"]').removeClass("pink").end().eq(0).find(".badge").removeClass("badge-warning")
        }
        if (d == "skin-3") {
            $(".ace-nav > li.grey").addClass("red").find(".badge").addClass("badge-yellow")
        } else {
            $(".ace-nav > li.grey").removeClass("red").find(".badge").removeClass("badge-yellow")
        }

        $("#modal-skin").modal("hide");
    })
</script>
