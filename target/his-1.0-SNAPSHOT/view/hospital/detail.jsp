<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>查看-- -2015</title>
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
    <script type="text/javascript" src="static/Js/ckeditor/ckeditor.js"></script>


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
            $('#backid').click(function () {
                window.location.href = "index.html";
            });
        });
    </script>
</head>
<body>
<form action="index.html" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">姓名</td>
            <td>${hospital.name}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">证件类型</td>
            <td>
                <c:choose>
                    <c:when test="${hospital.certificateType == 1}">
                        身份证
                    </c:when>
                    <c:when test="${hospital.certificateType == 2}">
                        护照
                    </c:when>
                    <c:when test="${hospital.certificateType == 3}">
                        军官证
                    </c:when>
                </c:choose>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">证件号</td>
            <td>${hospital.idNum}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">社保号</td>
            <td>${hospital.socialSafeNum}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">联系电话</td>
            <td>${hospital.phone}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">是否自费</td>
            <td>
                ${hospital.selfPaying == 1 ? '是':'否'}
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">性别</td>
            <td>${hospital.sex == 1 ? '男':'女'}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">年龄</td>
            <td>${hospital.age}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">职业</td>
            <td>${hospital.career}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">初复诊</td>
            <td>
                ${hospital.earlyAppointment == 1? '初诊':'复诊'}
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">所挂科室</td>
            <td>${hospital.sectionName}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">指定医生</td>
            <td>${hospital.doctorName}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">备注</td>
            <td>${hospital.noted}</td>
        </tr>
        <tr>
            <td colspan="2">
                <center>
                    <button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
                </center>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
