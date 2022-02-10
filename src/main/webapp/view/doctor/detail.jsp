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
    <title>查看---2015</title>
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
                window.location.href = "doctor/list.do";
            });
        });
    </script>
</head>
<body>
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
<form action="index.html" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">姓名</td>
            <td>${doctor.name}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">证件类型</td>
            <td>
                <c:choose>
                    <c:when test="${doctor.certificateType == 1}">
                        身份证
                    </c:when>
                    <c:when test="${doctor.certificateType == 2}">
                        护照
                    </c:when>
                    <c:when test="${doctor.certificateType == 3}">
                        军官证
                    </c:when>
                </c:choose>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">证件号</td>
            <td>${doctor.idNum}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">手机</td>
            <td>${doctor.phone}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">座机</td>
            <td>${doctor.specialPlane}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">性别</td>
            <td>${doctor.sex == 1 ? '男':'女'}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">年龄</td>
            <td>${doctor.age}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">入院时间</td>
            <td>
                <fmt:formatDate value="${doctor.birthday}" pattern="yyyy-MM-dd"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">电子邮箱</td>
            <td>${doctor.email}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">所属科室</td>
            <td>
                <c:choose>
                    <c:when test="${doctor.sectionId == 1}">
                        血液科
                    </c:when>
                    <c:when test="${doctor.sectionId == 2}">
                        骨科
                    </c:when>
                    <c:when test="${doctor.sectionId == 3}">
                        外科
                    </c:when>
                    <c:when test="${doctor.sectionId == 4}">
                        急诊科
                    </c:when>
                    <c:otherwise>
                        妇科
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">学历</td>
            <td>
                <c:choose>
                    <c:when test="${doctor.education == 1}">
                        大专
                    </c:when>
                    <c:when test="${doctor.education == 2}">
                        本科
                    </c:when>
                    <c:when test="${doctor.education == 3}">
                        研究生
                    </c:when>
                    <c:when test="${doctor.education == 4}">
                        博士
                    </c:when>
                </c:choose>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">备注</td>
            <td>${doctor.noted}</td>
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
