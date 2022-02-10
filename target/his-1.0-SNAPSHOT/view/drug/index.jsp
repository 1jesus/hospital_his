<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>药品查询----2015</title>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="static/Css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="static/Css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="static/Css/style.css"/>
    <script type="text/javascript" src="static/Js/jquery.js"></script>
    <script type="text/javascript" src="static/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="static/Js/bootstrap.js"></script>
    <script type="text/javascript" src="static/Js/ckform.js"></script>
    <script type="text/javascript" src="static/Js/common.js"></script>

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }

        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
    <script type="text/javascript">
        $(function () {
            $('#newNav').click(function () {
                window.location.href = "http://localhost:8080/his/view/drug/add.jsp";
            });
        });

        function checkall() {
            var alls = document.getElementsByName("check");
            var ch = document.getElementById("checkall");
            if (ch.checked) {
                for (var i = 0; i < alls.length; i++) {
                    alls[i].checked = true;
                }
            } else {
                for (var i = 0; i < alls.length; i++) {
                    alls[i].checked = false;
                }
            }
        }

        function delAll() {
            var alls = document.getElementsByName("check");
            var ids = new Array();
            for (var i = 0; i < alls.length; i++) {
                if (alls[i].checked) {
                    ids.push(alls[i].value);
                }
            }
            if (ids.length > 0) {
                if (confirm("确认操作?")) {
                    alert("成功!");
                }
            } else {
                alert("请选中要操作的项");
            }
        }
    </script>
</head>
<body>

<form action="drug/list.do" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">药品名称：</td>
            <td><input type="text" name="drugName" value=""/></td>

            <td width="10%" class="tableleft">药品类型：</td>
            <td>
                <select name="drugType">
                    <option value="1">处方药</option>
                    <option value="2">非处方药</option>
                    <option value="3">中药</option>
                    <option value="4">西药</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="4">
                <center>
                    <button type="submit" class="btn btn-primary" type="button">查询</button>
                    <button type="submit" class="btn btn-primary" type="button">清空</button>
                </center>
            </td>
        </tr>
    </table>
</form>

<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th><input type="checkbox" id="checkall" onChange="checkall();"></th>
        <th>药品编号</th>
        <th>药品名称</th>
        <th>药品类型</th>
        <th>简单描述</th>
        <th>状态</th>
        <th>剩余量</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach var="d" items="${pageInfo.list}">
        <tr>
            <td style="vertical-align:middle;"><input type="checkbox" name="check" value="1"></td>
            <td style="vertical-align:middle;">${d.drugNum}</td>
            <td style="vertical-align:middle;">${d.drugName}</td>
            <td style="vertical-align:middle;">${d.drugType}</td>
            <td style="vertical-align:middle;">${d.simpleDetail}</td>
            <td style="vertical-align:middle;">${d.status}</td>
            <td style="vertical-align:middle;">${d.surplus}</td>
            <td style="vertical-align:middle;">
                <a href="drug/update1.do?drugNum=${d.drugNum}">更改</a>&nbsp;&nbsp;&nbsp;
                <a href="drug/detail.do?drugNum=${d.drugNum}">详情>>></a>
            </td>
        </tr>
    </c:forEach>
</table>

<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <th colspan="5">
            <div class="inline pull-right page">
                <a href='drug/list.do?pageNo=1&drugName=${drugName}&drugType=${drugType}'>第一页</a>
                <a href='drug/list.do?pageNo=${pageInfo.prePage}&drugName=${drugName}&drugType=${drugType}'>上一页</a>

                <c:forEach begin="1" end="${pageInfo.pages}" var="i">
                    <a href="drug/list.do?pageNo=${i}&drugName=${drugName}&drugType=${drugType}"
                       class="${pageInfo.pageNum == i ? 'current':''}">
                        <span>${i}</span>
                    </a>
                </c:forEach>

                <a href='drug/list.do?pageNo=${pageInfo.nextPage}&drugName=${drugName}&drugType=${drugType}'>下一页</a>
                <a href='drug/list.do?pageNo=${pageInfo.pages}&drugName=${drugName}&drugType=${drugType}'>最后一页</a>
                &nbsp;&nbsp;&nbsp;共<span class='current'>${pageInfo.total}</span>条记录
                <span class='current'> ${pageInfo.pageNum}/${pageInfo.pages} </span>页
            </div>
            <div>
                <button type="button" class="btn btn-success" id="newNav">添加新药</button>
                <button type="button" class="btn btn-success" id="delPro">导出Excel</button>
                <button type="button" class="btn btn-success" id="delPro">导出txt</button>
            </div>

        </th>
    </tr>
</table>


</body>
</html>