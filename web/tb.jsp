<%--
  Created by IntelliJ IDEA.
  User: 11477
  Date: 2021/12/17
  Time: 14:46
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
<script type="text/javascript" src="js/echarts.min.js"></script>
<body>
<center><h1>按地址统计</h1></center>
<%--${list}--%>
<%--为ECharts准备一个具备大小（宽高）的Dom--%>
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    //基于准备好的dom,初始化echarts实例
    var myChart=echarts.init(document.getElementById('main'));
    myChart.setOption(
        {
            series:[
                {
                    name:'访问来源',
                    type:'pie',//设置图标类型为饼图
                    radius:'55%',//饼图的半径，外半径为可视区尺寸（容器高宽中较小的一项）的55%长度
                    data:${list}
                }
            ]
        }
    )
</script>
</body>
</html>
