<%--
  Created by IntelliJ IDEA.
  User: 11477
  Date: 2021/12/16
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            background: url("img/3.jpg");
            /*background:#008B8B;*/
        }
        #login{
            position: absolute;
            float:left;
            top:50px;
        }
        #count{
            position: absolute;
            float: left;
            top:70px;
        }
        #logo{
            position: absolute;
            left:550px;
            top:30px;
        }
    </style>
</head>
<body>
<div id="logo">
    <center><font style="font-size: 30px;font-weight: bolder;font-family: 华文行楷">小区门禁安全系统</font></center>
</div>
<div id="login">欢迎${sessionScope.user.role}${sessionScope.user.username}登录</div><br>
<div id="count">当前共有${applicationScope.count}人在线</div>
</body>
</html>
