<%--
  Created by IntelliJ IDEA.
  User: 11477
  Date: 2021/12/15
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="js/jquery.cookie.js"></script>
    <script type="text/javascript" src="js/jquery.base64.js"></script>
    <script type="text/javascript">
        function setCookie() {
            var loginCode=$("#username").val();
            var pwd=$("#password").val();
            var role=$("#role").val();
            var checked=$("input[type='checkbox']").is(':checked');//获取“是否记住密码”复选框

            if(checked){//判断是否选中了“记住密码”复选框
                //设置cookie过期时间
                var date=new Date();
                date.setTime(date.getTime()+60*1000);
                $.cookie("login_code",loginCode,{expires:date,path:'/'});//调用jquery.cookie.js中的方法设置cookie中的用户
                $.cookie("pwd",$.base64.encode(pwd),{expires: date,path: '/'});//调用jquery.cookie.js中的方法设置cookie中的
                // 登录密码，并使用base64(jquery.base64.js)进行加密
                $.cookie("role1",role,{expires:date,path:'/'});
            }else{
                $cookie("login_code",null);
                $cookie("pwd",null);
                $cookie("role1",null);
            }
        }
        //清除所有cookie函数
        function clearAllCookie() {
            var date=new Date();
            date.setTime(date.getTime()-10000);
            var keys=document.cookie.match(/[^ =;]+(?=\=)/g);
            console.log("需要删除的cookie名字："+keys);
            if(keys){
                for(var i=keys.length;i--;)
                    document.cookie=keys[i]+"=0;expire="+date.toGMTString()+"; path=/";
            }
        }
        //获取cookie
        function getCookie() {

            var loginCode=$.cookie("login_code");//获取cookie中的用户名
            var pwd=$.cookie("pwd");//获取cookie中的登录密码
            var role=$.cookie("role1");
            console.log("获取cookie:用户名："+loginCode);
            console.log("获取cookie:密码："+pwd);
            console.log("获取cookie:身份："+role);
            if(!loginCode||loginCode==0){
                console.log("用户名："+!loginCode);
                //alert("请输入内容");
            }else{
                $("#username").val(loginCode);
            }
            if(!pwd||pwd==0){
                console.log("密码："+!pwd);
            }else{
                //密码存在的话把密码填充到密码文本框
                //console.log("密码解密后："+$.base64.decode(pwd));
                $("#password").val($.base64.decode(pwd));
                //密码存在的话把“记住用户名和密码”复选框勾选住
                $("[name='jizhu']").attr("checked","true");
            }
            if(!role||role==0){
                console.log("身份："+!role);
            }else{
                $("#role").val(role);
            }
        }
        function checkLogin() {
            var userName=$('#username').val();
            console.log("用户名："+userName);
            if(userName==''){
                alert("请输入用户名");
                return;
            }
            var userPass=$('#password').val();
            console.log("密码："+userPass);
            if(userPass==''){
                alert("请输入密码");
                return;
            }
            var userRole=$('#role').val();
            // console.log(userRole)
            console.log("身份："+userRole);
            if(userRole==''){
                alert("请选择身份");
                return;
            }

            //判断是否选中复选框，如果选中，添加cookie
            var jizhupwd=$("input[type='checkbox']").is(':checked');
            console.log("是否记住密码："+jizhupwd);
            if(jizhupwd){
                //添加cookie
                setCookie();
            }else{
                clearAllCookie();
            }
            login(userName,userPass,userRole);//联网上传账号密码
        }
        // 异步登录逻辑
        function login(username,password,role) {
            console.log(username+" "+password+" "+role);
            $.post(
                "login",
                {
                    "username":username,
                    "password":password,
                    "role":role,
                },
                function (data) {
                    if(data==1){
                        // alert(data);
                        location.href="index.jsp";
                    }else if(data==0){
                        // alert(data);
                        location.href="client.jsp";
                    }else{
                        alert("登录失败");
                    }
                }
            );
        }
        function validate() {
            var username=document.getElementById("username");
            var password=document.getElementById("password");
            var role=document.getElementById("role");
            if(username.value==""){
                alert("用户名不能为空！");
                username.focus();
                return false;
            }
            if(password.value==""){
                alert("密码不能为空！");
                password.focus();
                return false;
            }
            if(role.value==""){
                alert("身份不能为空！");
                role.focus();
                return false;
            }
            return true;
        }
    </script>
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
<body onload="getCookie()">
<div>
    <div id="login">
        <form method="post" onsubmit="return validate();">
            <p>登录界面</p>
            <input type="text" placeholder="username:" class="user" id="username"/>
            <input type="password" placeholder="password:" class="user pwd" id="password"/><br>
            <!--            <input type="text" placeholder="role" class="user" id="role"/>-->
            <select name="role" id="role" class="user">
                <option value="管理员">管理员</option>
                <option value="用户">用户</option>
            </select>
            <input type="checkbox" name="jizhu" class="aa" id="jizhu">记住密码<br><br>
            <span class="bb">
                <input type="button" value="登录" id="denglu" onclick="checkLogin()">
                <button onclick="window.location.href='register.jsp'">注册</button>
            </span>
<%--            <a href="register.jsp">立即注册</a>--%>
        </form>
    </div>
</div>
</body>
</html>
