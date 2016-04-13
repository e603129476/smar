<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>页面未找到</title>
    <link rel="stylesheet" href="<%=contextPath%>/css/base.css" />
    <link rel="stylesheet" href="<%=contextPath%>/css/failure.css" />
</head>
<body>
<div class="failure-wrap">
    <div class="failure-box failure-type-unauthorized">
        <a href="<%=contextPath%>/index" >返回首页</a>
    </div>
</div>
</body>
</html>
