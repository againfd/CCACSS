<%--
  Created by IntelliJ IDEA.
  User: 11477
  Date: 2021/12/16
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
<body>
<script type="text/javascript" src="js/jquery-1.8.3%20.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script>
    $(
        function () {
            //全选
            $("#qx").click(
                function () {
                    $(".one").attr("checked",true);
                }
            ),
                //全不选
                $("#qbx").click(
                    function () {
                        $(".one").attr("checked",false);
                    }
                ),
                //反选
                $("#fx").click(
                    function () {
                        $(".one").each(function () {
                            $(this).attr("checked",!$(this).attr("checked"));
                        })
                    }
                )
        }
    )
    //批量删除
    function plsc() {
        var ids="";
        $(".one:checked").each(
            function () {
                var id=$(this).val();
                ids+=","+id;
            }
        )
        ids=ids.substring(1);
        console.log("ids="+ids);
        $.post(
            'deleteplsc',
            {ids:ids},
            function (obj) {
                if(obj==1){
                    alert("删除成功");
                    location="listpage";
                }else{
                    alert("删除失败");
                }
            },
            'json'
        )
    }
</script>
<center>
    <h2>用户信息管理</h2>
    <div>
        <input type="button" value="批量删除" onclick="plsc()">
    </div>
    <table width="80%" height="50%">
        <tr>
            <td>
                <input type="button" id="qx" value="全选">
                <input type="button" id="qbx" value="全不选">
                <input type="button" id="fx" value="反选">
            </td>
            <td>id</td>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>地址</td>
            <td>手机号</td>
            <td>头像</td>
            <td>
                <a href="add.jsp">添加客户</a>
            </td>
        </tr>
        <c:if test="${requestScope.page!=null}">
            <c:if test="${requestScope.page.list ne null and requestScope.page.list.size() gt 0}">
                <c:forEach var="s" items="${requestScope.page.list}">
                    <tr>
                        <td>
                            <input type="checkbox" class="one" value="${s.id}">
                        </td>
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

        <tr>
            <td colspan="7">
                <input type="button" value="首页" onclick="toFirst()">
                <input type="button" value="上一页" onclick="toPrev()">
                当前页${requestScope.page.currentPageNum}|${requestScope.page.totalPageNum}总页数
                <input type="button" value="下一页" onclick="toNext()">
                <input type="button" value="末页" onclick="toLast()">
            </td>
        </tr>
    </table>
</center>
</body>
<script>
    var currentPage=${requestScope.page.currentPageNum};
    var totalPage=${requestScope.page.totalPageNum};

    function toFirst() {
        location.href="listpage?currentPage=1";
    }
    function toPrev() {
        var url="";
        if(currentPage==1){
            url="listpage?currentPage=1";
        }else{
            url="listpage?currentPage="+(currentPage-1);
        }
        location.href=url;
    }
    function toNext() {
        var url="";
        if(currentPage==totalPage){
            url="listpage?currentPage="+totalPage;
        }else{
            url="listpage?currentPage="+(currentPage+1);
        }
        location.href=url;
    }
    function toLast() {
        location.href="listpage?currentPage="+${requestScope.page.totalPageNum};
    }
</script>
</html>

