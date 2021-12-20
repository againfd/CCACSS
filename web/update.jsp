<%--
  Created by IntelliJ IDEA.
  User: 11477
  Date: 2021/12/16
  Time: 16:40
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
    <h2>修改用户信息</h2>
    <form action="update" method="post">
        <input type="hidden" name="id" value="${s.id}">
        <table width="50%" height="35%">
            <tr>
                <td>姓名</td>
                <td>
                    <input type="text" name="name" value="${s.name}">
                </td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <input type="text" name="sex" value="${s.sex}">
                </td>
            </tr>
            <tr>
                <td>年龄</td>
                <td>
                    <input type="text" name="age" value="${s.age}">
                </td>
            </tr>
            <tr>
                <td>地址</td>
                <td>
                    <input type="text" name="address" value="${s.address}">
                </td>
            </tr>
            <tr>
                <td>手机号</td>
                <td>
                    <input type="text" name="tele" value="${s.tele}">
                </td>
            </tr>
            <tr>
                <td>头像</td>
                <td>
                    <input type="text" name="picture" value="${s.picture}">
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="修改"></td>
                <td><input type="reset" name="重置"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
