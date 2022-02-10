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
    <title>入院办理-- -2015</title>
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
                window.location.href = "http://localhost:8080/his/view/hospital/add.jsp";
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

<form action="hospital/list.do" method="post" class="definewidth m20">
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
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button type="submit" class="btn btn-primary" type="button">查询</button>
                <button type="submit" class="btn btn-primary" type="button">清空</button>
            </td>
        </tr>
    </table>
</form>

<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>
            <input type="checkbox" id="checkall" onChange="checkall();">
        </th>
        <th>病历号</th>
        <th>姓名</th>
        <th>床位号</th>
        <th>联系电话</th>
        <th>押金</th>
        <th>主治医生</th>
        <th>入院时间</th>
        <th>科室</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    </thead>
    <%--
    private String doctorName;
    private String sectionName;
    private Integer bedId;
    --%>
    <c:forEach var="h" items="${pageInfo.list}">
        <tr>
            <td style="vertical-align:middle;"><input type="checkbox" name="check" value="${h.medicalRecord}"></td>
            <td style="vertical-align:middle;">${h.medicalRecord}</td>
            <td style="vertical-align:middle;">${h.name}</td>
            <td style="vertical-align:middle;">${h.bedId}</td>
            <td style="vertical-align:middle;">${h.phone}</td>
            <td style="vertical-align:middle;">${h.payTheDeposit}</td>
            <td style="vertical-align:middle;">${h.doctorName}</td>
            <td style="vertical-align:middle;">
                <fmt:formatDate value="${h.time}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <td style="vertical-align:middle;">${h.sectionName}</td>
            <td style="vertical-align:middle;">
                <c:choose>
                    <c:when test="${h.status == 1}">
                        已挂号
                    </c:when>
                    <c:when test="${h.status == 2}">
                        已询医
                    </c:when>
                    <c:when test="${h.status == 3}">
                        已住院
                    </c:when>
                    <c:when test="${h.status == 4}">
                        已出院
                    </c:when>
                    <c:otherwise>
                        已退院
                    </c:otherwise>
                </c:choose>
            </td>
            <td style="vertical-align:middle;">
                <a href="hospital/detail.do?medicalRecord=${h.medicalRecord}">详情>>></a>&nbsp;&nbsp;&nbsp;
                <a href="hospital/update1.do?medicalRecord=${h.medicalRecord}">更改</a>&nbsp;&nbsp;&nbsp;
                <a href="hospital/discharged.do?medicalRecord=${h.medicalRecord}">退院</a>&nbsp;&nbsp;&nbsp;
                <a href="hospital/discharged2.do?medicalRecord=${h.medicalRecord}">出院</a>
            </td>
        </tr>
    </c:forEach>
</table>

<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <th colspan="5">
            <div class="inline pull-right page">
                <a href='hospital/list.do?pageNo=1&medicalRecord=${map.medicalRecord}&doctorName=${map.doctorName}&sectionName=${map.sectionName}&startTime=${map.startTime}&endTime=${map.endTime}'>第一页</a>
                <a href='hospital/list.do?pageNo=${pageInfo.prePage}&medicalRecord=${map.medicalRecord}&doctorName=${map.doctorName}&sectionName=${map.sectionName}&startTime=${map.startTime}&endTime=${map.endTime}'>上一页</a>

                <c:forEach begin="1" end="${pageInfo.pages}" var="i">
                    <a href="hospital/list.do?pageNo=${i}&medicalRecord=${map.medicalRecord}&doctorName=${map.doctorName}&sectionName=${map.sectionName}&startTime=${map.startTime}&endTime=${map.endTime}"
                       class="${pageInfo.pageNum == i ? 'current':''}">
                        <span>${i}</span>
                    </a>
                </c:forEach>

                <a href='hospital/list.do?pageNo=${pageInfo.nextPage}&medicalRecord=${map.medicalRecord}&doctorName=${map.doctorName}&sectionName=${map.sectionName}&startTime=${map.startTime}&endTime=${map.endTime}'>下一页</a>
                <a href='hospital/list.do?pageNo=${pageInfo.pages}&medicalRecord=${map.medicalRecord}&doctorName=${map.doctorName}&sectionName=${map.sectionName}&startTime=${map.startTime}&endTime=${map.endTime}'>最后一页</a>
                &nbsp;&nbsp;&nbsp;共<span class='current'>${pageInfo.total}</span>条记录
                <span class='current'> ${pageInfo.pageNum}/${pageInfo.pages} </span>页
            </div>
            <div>
                <button type="button" class="btn btn-success" id="newNav">录入住院信息</button>&nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-success" id="delPro" onClick="delAll();">出院</button>&nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-success" id="delPro" onClick="delAll();">退院</button>&nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-success" id="delPro">导出Excel</button>
                <button type="button" class="btn btn-success" id="delPro">打印</button>
            </div>

        </th>
    </tr>
</table>


</body>
</html>
