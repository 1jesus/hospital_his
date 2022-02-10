<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>门诊医生---2015</title>
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
                window.location.href = "http://localhost:8080/his/view/doctor/add.jsp";
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

<form action="doctor/list.do" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">医生编号：</td>
            <td>
                <input type="text" name="id" value="${map.id}"/>
            </td>

            <td width="10%" class="tableleft">医生姓名：</td>
            <td>
                <input type="text" name="name" value="${map.name}"/>
            </td>

            <td width="10%" class="tableleft">科室：</td>
            <td>
                <input type="text" name="sectionId" value="${map.sectionId}"/>
            </td>
        </tr>
        <tr>
            <td colspan="6">
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
        <th>医生编号</th>
        <th>医生姓名</th>
        <th>入院时间</th>
        <th>所属科室</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach var="d" items="${pageInfo.list}">
        <tr>
            <td style="vertical-align:middle;"><input type="checkbox" name="check" value="1"></td>
            <td style="vertical-align:middle;">${d.id}</td>
            <td style="vertical-align:middle;">${d.name}</td>
            <td style="vertical-align:middle;">
                <fmt:formatDate value="${d.birthday}" pattern="yyyy-MM-dd"/>
            </td>
            <td style="vertical-align:middle;">${d.sectionName}</td>
            <td style="vertical-align:middle;">
                <a href="doctor/detail.do?id=${d.id}">详情>>></a>&nbsp;&nbsp;&nbsp;
                <a href="doctor/update1.do?id=${d.id}">更改</a>
            </td>
        </tr>
    </c:forEach>
    <%--
    private Integer id;
    private String name;
    private Integer certificateType;
    private String idNum;
    private String phone;
    private String specialPlane;
    private Integer sex;
    private Integer age;
    private Date birthday;
    private String email;
    private Integer sectionId;
    private Integer education;
    private String noted;
    --%>
</table>

<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <th colspan="5">
        <th colspan="5">
            <div class="inline pull-right page">
                <a href='doctor/list.do?pageNo=1&id=${map.id}&name=${map.name}&sectionId=${map.sectionId}'>第一页</a>
                <a href='doctor/list.do?pageNo=${pageInfo.prePage}&id=${map.id}&name=${map.name}&sectionId=${map.sectionId}'>上一页</a>

                <c:forEach begin="1" end="${pageInfo.pages}" var="i">
                    <a href="doctor/list.do?pageNo=${i}&id=${map.id}&name=${map.name}&sectionId=${map.sectionId}"
                       class="${pageInfo.pageNum == i ? 'current':''}">
                        <span>${i}</span>
                    </a>
                </c:forEach>

                <a href='doctor/list.do?pageNo=${pageInfo.nextPage}&id=${map.id}&name=${map.name}&sectionId=${map.sectionId}'>下一页</a>
                <a href='doctor/list.do?pageNo=${pageInfo.pages}&id=${map.id}&name=${map.name}&sectionId=${map.sectionId}'>最后一页</a>
                &nbsp;&nbsp;&nbsp;共<span class='current'>${pageInfo.total}</span>条记录
                <span class='current'> ${pageInfo.pageNum}/${pageInfo.pages} </span>页
            </div>
            <div>
                <button type="button" class="btn btn-success" id="newNav">添加新医生</button>
                <button type="button" class="btn btn-success" id="delPro">导出Excel</button>
            </div>

        </th>
    </tr>
</table>


</body>
</html>
