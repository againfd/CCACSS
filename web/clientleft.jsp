<%--
  Created by IntelliJ IDEA.
  User: 11477
  Date: 2021/12/16
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            background: url("img/4.jpg");
            /*background:#008B8B;*/
        }
    </style>
</head>
<body>
<div>
    <a href="main.jsp" target="main">首页</a>
    <dl>
        <dt>用户信息管理</dt>
        <dd>
            <a href="lookfor.jsp" target="main">查询用户信息</a>
        </dd>
    </dl>
    <dl>
        <dt>安全模块</dt>
        <dd>
            <a href="http://192.168.43.24:8081" target="main">安全监测</a>
        </dd>
    </dl>
    <dl>
        <dt>系统管理</dt>
        <dd>
            <a href="logout" target="_parent">退出系统</a>
        </dd>
    </dl>
</div>
</body>
</html>
