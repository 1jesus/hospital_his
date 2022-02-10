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
    <title>门诊查询-- -2015</title>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="static/Css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="static/Css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="static/Css/style.css"/>
    <script type="text/javascript" src="static/Js/jquery.js"></script>
    <%--<script type="text/javascript" src="static/Js/jquery.sorted.js"></script>--%>
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
                window.location.href = "doctor/docList.do";
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

        // 批量删除
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
                    console.log(ids);
                    window.location.href = "registration/deleteAll.do?ids=" + ids;
                }
            } else {
                alert("请选中要操作的项");
            }
        }
    </script>
</head>
<body>

<form action="registration/list.do" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">病历号：</td>
            <td><input type="text" name="medicalRecord" value="${map.medicalRecord}"/></td>

            <td width="10%" class="tableleft">主治医生：</td>
            <td><input type="text" name="doctorName" value="${map.doctorName}"/></td>

            <td width="10%" class="tableleft">科室：</td>
            <td><input type="text" name="sectionName" value="${map.sectionName}"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">挂号时间：</td>
            <td colspan="5">
                <input type="text" name="startTime" value="${map.startTime}"/>&nbsp;至&nbsp;
                <input type="text" name="endTime" value="${map.endTime}"/>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button type="submit" class="btn btn-primary" type="button">查询</button>
                <button type="submit" class="btn btn-primary" type="button">清空</button>
            </td>
        </tr>
    </table>
</form>

<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th><input type="checkbox" id="checkall" onChange="checkall();"></th>
        <th>门诊编号</th>
        <th>患者名字</th>
        <th>主治医生</th>
        <th>挂号时间</th>
        <th>挂号科室</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach var="r" items="${pageInfo.list}">
        <tr>
            <td style="vertical-align:middle;"><input type="checkbox" name="check" value="${r.medicalRecord}"></td>
            <td style="vertical-align:middle;">${r.medicalRecord}</td>
            <td style="vertical-align:middle;">${r.name}</td>
            <td style="vertical-align:middle;">${r.doctorName}</td>
            <td style="vertical-align:middle;">
                <fmt:formatDate value="${r.time}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <td style="vertical-align:middle;">${r.sectionName}</td>
            <td style="vertical-align:middle;">
                <c:choose>
                    <c:when test="${r.status == 1}">
                        已挂号
                    </c:when>
                    <c:when test="${r.status == 2}">
                        已询医
                    </c:when>
                    <c:when test="${r.status == 3}">
                        已住院
                    </c:when>
                    <c:when test="${r.status == 4}">
                        已出院
                    </c:when>
                    <c:otherwise>
                        已退院
                    </c:otherwise>
                </c:choose>
            </td>
            <td style="vertical-align:middle;"><a
                    href="registration/detail.do?medicalRecord=${r.medicalRecord}">详情>>></a>&nbsp;&nbsp;&nbsp;
                <a href="registration/update1.do?medicalRecord=${r.medicalRecord}">更改</a>&nbsp;&nbsp;&nbsp;
                    <%--<a href="javascript:alert('退号成功！');">退号</a>--%>
                <a href="registration/delete.do?medicalRecord=${r.medicalRecord}">退号</a>
            </td>
        </tr>
    </c:forEach>
</table>

<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <th colspan="5">
            <div class="inline pull-right page">
                <a href='registration/list.do?pageNo=1&medicalRecord=${map.medicalRecord}&doctorName=${map.doctorName}&sectionName=${map.sectionName}&startTime=${map.startTime}&endTime=${map.endTime}'>第一页</a>
                <a href='registration/list.do?pageNo=${pageInfo.prePage}&medicalRecord=${map.medicalRecord}&doctorName=${map.doctorName}&sectionName=${map.sectionName}&startTime=${map.startTime}&endTime=${map.endTime}'>上一页</a>

                <c:forEach begin="1" end="${pageInfo.pages}" var="i">
                    <a href="registration/list.do?pageNo=${i}&medicalRecord=${map.medicalRecord}&doctorName=${map.doctorName}&sectionName=${map.sectionName}&startTime=${map.startTime}&endTime=${map.endTime}"
                       class="${pageInfo.pageNum == i ? 'current':''}">
                        <span>${i}</span>
                    </a>
                </c:forEach>

                <a href='registration/list.do?pageNo=${pageInfo.nextPage}&medicalRecord=${map.medicalRecord}&doctorName=${map.doctorName}&sectionName=${map.sectionName}&startTime=${map.startTime}&endTime=${map.endTime}'>下一页</a>
                <a href='registration/list.do?pageNo=${pageInfo.pages}&medicalRecord=${map.medicalRecord}&doctorName=${map.doctorName}&sectionName=${map.sectionName}&startTime=${map.startTime}&endTime=${map.endTime}'>最后一页</a>
                &nbsp;&nbsp;&nbsp;共<span class='current'>${pageInfo.total}</span>条记录
                <span class='current'> ${pageInfo.pageNum}/${pageInfo.pages} </span>页
            </div>
            <div>
                <button type="button" class="btn btn-success" id="newNav">门诊挂号</button>&nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-success" id="delPro" onClick="delAll();">退号</button>&nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-success" id="exportRegist">导出Excel</button>
                <button type="button" class="btn btn-success" id="delPro">打印</button>
            </div>
        </th>
    </tr>
</table>
<script>
    $("#exportRegist").click(function () {
        window.location.href = "registration/export2.do";
    })
</script>
</body>
</html>