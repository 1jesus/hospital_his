<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
</head>
<body>

<!-- 为 ECharts 准备一个定义了宽高的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>
<script src="static/Js/echarts.js"></script>
<script src="static/Js/jquery-2.1.0.js"></script>
<script type="text/javascript">
    // 页面加载事件
    $(document).ready(function () {
        $.ajax({
            url: "ajax/month.do",
            type: "get",
            success: function (res) {
                console.log(res.data)
                if (res.code == 200) {
                    var myChart = echarts.init($('#main')[0]);
                    var option = {
                        title: {
                            text: '月营业额'
                        },
                        tooltip: {},
                        legend: {
                            data: ['销量']
                        },
                        xAxis: {
                            data: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"]
                        },
                        yAxis: {},
                        series: [{
                            name: '销量',
                            type: 'bar',
                            data: res.data
                        }]
                    };
                    myChart.setOption(option);
                }
            },
            error: function () {
                alert("失败");
            }
        });
    });
</script>
</body>
</html>
