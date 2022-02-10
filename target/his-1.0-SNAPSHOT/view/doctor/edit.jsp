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
    <title>修改医生---2015</title>
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
<form action="doctor/update2.do" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">姓名</td>
            <input type="text" name="id" value="${doctor.id}" hidden="hidden">
            <td>
                <input type="text" name="name" value="${doctor.name}"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">证件类型</td>
            <td><select name="certificateType">
                <option value="1" ${doctor.certificateType == 1? 'selected':''}>身份证</option>
                <option value="2" ${doctor.certificateType == 2? 'selected':''}>护照</option>
                <option value="3" ${doctor.certificateType == 3? 'selected':''}>军人证</option>
            </select>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">证件号</td>
            <td>
                <input type="text" name="idNum" value="${doctor.idNum}"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">手机</td>
            <td>
                <input type="text" name="phone" value="${doctor.phone}"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">座机</td>
            <td>
                <input type="text" name="specialPlane" value="${doctor.specialPlane}"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">性别</td>
            <td>
                <input type="radio" name="sex" value="1" ${doctor.sex == 1 ? 'checked':''}/>男&nbsp;&nbsp;&nbsp;
                <input type="radio" name="sex" value="2" ${doctor.sex == 2 ? 'checked':''}/>女
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">入院时间</td>
            <td>
                <input type="date" name="birthday" value=""/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">年龄</td>
            <td>
                <input type="text" name="age" value="${doctor.age}"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">电子邮箱</td>
            <td>
                <input type="text" name="email" value="${doctor.email}"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">所属科室</td>
            <td>
                <select name="sectionId">
                    <option value="1" ${doctor.sectionId == 1 ? 'selected':''}>血液科</option>
                    <option value="2" ${doctor.sectionId == 2 ? 'selected':''}>骨科</option>
                    <option value="3" ${doctor.sectionId == 3 ? 'selected':''}>外科</option>
                    <option value="4" ${doctor.sectionId == 4 ? 'selected':''}>急诊科</option>
                    <option value="5" ${doctor.sectionId == 5 ? 'selected':''}>妇科</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">学历</td>
            <td>
                <select name="education">
                    <option value="1" ${doctor.education == 1 ? 'selected':''}>专科</option>
                    <option value="2" ${doctor.education == 2 ? 'selected':''}>本科</option>
                    <option value="3" ${doctor.education == 3 ? 'selected':''}>博士</option>
                    <option value="4" ${doctor.education == 4 ? 'selected':''}>博士后</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">备注</td>
            <td><textarea name="noted">${doctor.noted}</textarea></td>
        </tr>
        <tr>
            <td colspan="2">
                <center>
                    <button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
                    <button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
                </center>
            </td>
        </tr>
    </table>
</form>

</body>
</html>  
