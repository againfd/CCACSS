<%--
  Created by IntelliJ IDEA.
  User: 11477
  Date: 2021/12/16
  Time: 16:08
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
<center>
    <h2>添加用户</h2>
    <form action="add" method="post" enctype="multipart/form-data">
        <table width="50%" htight="35%">
            <tr>
                <td>姓名</td>
                <td><input type="text" name="name" id="name">
                </td>
            </tr>
            <tr>
                <td>性别</td>
                <td><input type="radio"  value="1" name="sex">男</td>
                <td><input type="radio"  value="2" name="sex">女</td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input type="text" name="age"></td>
            </tr>
            <tr>
                <td>地址</td>
                <td><input type="text" name="address"></td>
            </tr>
            <tr>
                <td>手机号</td>
                <td><input type="text" name="tele"></td>
            </tr>
            <tr>
                <td>图像</td>
                <td>请选择图像：<input type="file" name="picture"></td>
            </tr>
            <tr>
                <td><input type="submit" value="添加"></td>
                <td><input type="reset" name="重置"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
