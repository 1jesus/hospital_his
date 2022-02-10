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
                window.location.href = "registration/list.do";
            });
        });
    </script>
</head>
<body>
<form action="registration/list.do" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">姓名</td>
            <td>${registrationInfor.name}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">证件类型</td>
            <td>${registrationInfor.certificateType}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">证件号</td>
            <td>${registrationInfor.idNum}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">挂号费</td>
            <td>${registrationInfor.registrationFee}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">社保号</td>
            <td>${registrationInfor.socialSafeNum}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">联系电话</td>
            <td>${registrationInfor.phone}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">是否自费</td>
            <td>${registrationInfor.selfPaying == 1 ? '是':'否'}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">性别</td>
            <td>${registrationInfor.sex == 1 ? '男':'女'}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">年龄</td>
            <td>${registrationInfor.age}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">职业</td>
            <td>${registrationInfor.career}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">初复诊</td>
            <td>${registrationInfor.earlyAppointment == 1? '初诊':'复诊'}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">所挂科室</td>
            <td>
                <c:choose>
                    <c:when test="${registrationInfor.sectionId == 1}">
                        血液科
                    </c:when>
                    <c:when test="${registrationInfor.sectionId == 2}">
                        骨科
                    </c:when>
                    <c:when test="${registrationInfor.sectionId == 3}">
                        外科
                    </c:when>
                    <c:when test="${registrationInfor.sectionId == 4}">
                        急诊科
                    </c:when>
                    <c:when test="${registrationInfor.sectionId == 5}">
                        妇科
                    </c:when>
                </c:choose>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">指定医生</td>
            <td>
                <c:choose>
                    <c:when test="${registrationInfor.doctorId == 1}">
                        华佗
                    </c:when>
                    <c:when test="${registrationInfor.doctorId == 2}">
                        扁鹊
                    </c:when>
                    <c:when test="${registrationInfor.doctorId == 3}">
                        张仲景
                    </c:when>
                    <c:when test="${registrationInfor.doctorId == 4}">
                        李时珍
                    </c:when>
                    <c:when test="${registrationInfor.doctorId == 5}">
                        逸仙
                    </c:when>
                    <c:when test="${registrationInfor.doctorId == 6}">
                        神农氏
                    </c:when>
                    <c:when test="${registrationInfor.doctorId == 7}">
                        孙思邈
                    </c:when>
                    <c:when test="${registrationInfor.doctorId == 8}">
                        白求恩
                    </c:when>
                </c:choose>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">备注</td>
            <td>${registrationInfor.noted}</td>
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
