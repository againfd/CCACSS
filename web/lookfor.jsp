<%--
  Created by IntelliJ IDEA.
  User: 11477
  Date: 2021/12/16
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

<script>
    function fun() {
        var sname=$("#username").val();
        location="lookfor?name="+sname;
        // alert(sname);
    }
    function fun1() {
        var stele=$("#usertele").val();
        location="lookfor1?tele="+stele;
        // alert(stele);
    }
</script>
<body>
<center>
    <h2>用户信息管理</h2>
    <div>按姓名查找</div><br>
    <div>
        姓名：<input type="text" class="username" id="username">
        <input type="submit" name="submit" value="搜索" onclick="fun()">
    </div><br>
    <div>按手机号码查找</div><br>
    <div>
        手机号码：<input type="text" class="usertele" id="usertele">
        <input type="submit" name="submit" value="搜索" onclick="fun1()">
    </div>
    <table width="70%" height="50%">
        <tr>
            <td>id</td>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>地址</td>
            <td>手机号</td>
            <td>头像</td>
            <%--            <td>--%>
            <%--                <a href="add.jsp">添加客户</a>--%>
            <%--            </td>--%>
        </tr>
        <c:if test="${requestScope.list!=null}">
            <c:if test="${requestScope.list ne null and requestScope.list.size() gt 0}">
                <c:forEach var="s" items="${requestScope.list}">
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.name}</td>
                        <td>${s.sex}</td>
                        <td>${s.age}</td>
                        <td>${s.address}</td>
                        <td>${s.tele}</td>
                        <td>
                            <img src="${s.picture}" width="20px" height="20px"/>
                        </td>
                        <td>
                            <a href="load?id=${s.id}">修改</a>
                            <a href="delete?id=${s.id}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
        </c:if>
    </table>
</center>
</body>
</html>
