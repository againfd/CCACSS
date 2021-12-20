<%--
  Created by IntelliJ IDEA.
  User: 11477
  Date: 2021/12/16
  Time: 8:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <script type="text/javascript">
        function validate() {
            var username = document.getElementById("username");
            var password = document.getElementById("password");
            var role=document.getElementById("role");
            var pattern = /^.{6,20}$/;
            var pattern1=/^[a-zA-Z]\w{5,17}$/;

            if (username.value == "") {
                alert("用户名不能为空！");
                username.focus();
                return false;
            } else if (!pattern.test(username.value)) {
                alert("用户名长度必须是6-20个字符组成");
                username.focus();
                return false;
            }
            if (password.value == "") {
                alert("密码不能为空！");
                password.focus();
                return false;
            } else if (!pattern1.test(password.value)) {
                alert("密码必须以字母开头，长度在6-18之间，只能包含字母，数字和下划线");
                password.focus();
                return false;
            }
            if(role.value==""){
                alert("请选择您的身份");
                role.focus();
                return false;
            }
            return true;
        }
    </script>
    <!--    <style>-->
    <!--        body{-->
    <!--            /*background: url("img/6.jpg");*/-->
    <!--            background:#008B8B;-->
    <!--        }-->
    <!--    </style>-->

    <style>
        body{
            background-image: url("img/1.jpg");
            background-repeat: no-repeat;
            background-size: cover;
            /*background:#008B8B;*/
            /*background: #008B8B;*/
        }
    </style>
    <style>

        p{
            /*position:absolute;*/
            font-size:25px;
            width: 270px;
            color:darkturquoise;
            text-align: center;
            margin-top: 10px;
            margin-left: 20px;
            /*margin: 100px auto 0;*/
            /*margin:0px auto;*/
            font-family:"微软雅黑";
        }
        .user{
            display: block;
            margin-top: 10px;
            margin-left: 20px;
            font-size:18px;
            width:270px;
            height: 44px;
            color:black;
            background:rgba(45,45,45,0.15);
            border-radius: 6px;
            border:1px solid rgba(255,255,255,.15);
            box-shadow:0 2px 3px 0 rgba(0,0,0,1) inset;
            text-indent:10px;
        }
        .aa{
            margin-left: 100px;
        }
        .bb{
            margin-left: 95px;
        }


        #login{
            position: absolute;
            background: white;
            width: 300px;
            height: 350px;
            margin-top: 130px;
            margin-left: 500px;

        }
        #img{
            position: absolute;
        }
    </style>
</head>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    function checkName() {
        var username=$("#username").val();
        console.log(username);
        $.post(//使用post请求
            'checkName',//访问后台的url路径
            {"username":username},//往后台传的参数
            //回调函数 就使后台执行完毕之后再执行的函数 data表示后台执行的结果，返回的值
            function (data) {
                console.log(data);
                // alert(data);
                if(data==1){
                    //用户名存在
                    $("#ff").html("用户名已存在！请重新输入！")
                    $("#username").val("")
                }else{
                    $("#ff").html("该用户名不存在！可以使用！")
                }
            })
    }
</script>
<body>
<div>
    <div id="login">
        <form  action="register" method="post" onsubmit="return validate();">
            <p>注册界面</p>
            <input type="text" placeholder="username:" class="user" name="username" id="username" onblur="checkName()"/><font id="ff" color="red" size="2"></font>
            <input type="password" placeholder="password:" class="user pwd" name="password" id="password"/><br>
            <!--            <input type="text" placeholder="role" class="user" id="role"/>-->
            身份：<select name="role" id="role" class="user">
            <option value="管理员">管理员</option>
            <option value="客户">客户</option>
        </select><br>
            <input type="submit" value="注册">
        </form>
    </div>
</div>
</body>
</html>
