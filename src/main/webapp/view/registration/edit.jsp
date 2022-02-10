<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>挂号-- -2015</title>
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
<form action="registration/update2.do" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">姓名</td>
            <input type="text" name="medicalRecord" value="${registrationInfor.medicalRecord}" hidden="hidden">
            <td>
                <input type="text" name="name" value="${registrationInfor.name}"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">证件类型</td>
            <td>
                <select name="certificateType">
                    <option value="1" ${registrationInfor.certificateType == 1? 'selected':''}>身份证</option>
                    <option value="2" ${registrationInfor.certificateType == 2? 'selected':''}>护照</option>
                    <option value="3" ${registrationInfor.certificateType == 3? 'selected':''}>军人证</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">证件号</td>
            <td><input type="text" name="idNum" value="${registrationInfor.idNum}"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">挂号费</td>
            <td><input type="text" name="registrationFee" value="${registrationInfor.registrationFee}"/>元</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">社保号</td>
            <td><input type="text" name="socialSafeNum" value="${registrationInfor.socialSafeNum}"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">联系电话</td>
            <td><input type="text" name="phone" value="${registrationInfor.phone}"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">是否自费</td>
            <td>
                <input type="radio" name="selfPaying" value="1" ${registrationInfor.selfPaying == 1 ? 'checked':''}/>否&nbsp;&nbsp;&nbsp;
                <input type="radio" name="selfPaying" value="2" ${registrationInfor.selfPaying == 2 ? 'checked':''}/>是
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">性别</td>
            <td>
                <input type="radio" name="sex" value="1" ${registrationInfor.sex == 1 ? 'checked':''}/>男&nbsp;&nbsp;&nbsp;
                <input type="radio" name="sex" value="2" ${registrationInfor.sex == 2 ? 'checked':''}/>女
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">年龄</td>
            <td><input type="text" name="age" value="${registrationInfor.age}"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">职业</td>
            <td><input type="text" name="career" value="${registrationInfor.career}"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">初复诊</td>
            <td>
                <input type="radio" name="earlyAppointment"
                       value="1" ${registrationInfor.earlyAppointment == 1? 'checked':''}/>初诊&nbsp;&nbsp;&nbsp;
                <input type="radio" name="earlyAppointment"
                       value="2" ${registrationInfor.earlyAppointment == 2? 'checked':''}/>复诊
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">所挂科室</td>
            <td>
                <select name="sectionId">
                    <option value="1" ${registrationInfor.sectionId == 1 ? 'selected':''}>血液科</option>
                    <option value="2" ${registrationInfor.sectionId == 2 ? 'selected':''}>骨科</option>
                    <option value="3" ${registrationInfor.sectionId == 3 ? 'selected':''}>外科</option>
                    <option value="4" ${registrationInfor.sectionId == 4 ? 'selected':''}>急诊科</option>
                    <option value="5" ${registrationInfor.sectionId == 5 ? 'selected':''}>妇科</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">指定医生</td>
            <td><select name="doctorId">
                <option value="1" ${registrationInfor.doctorId == 1 ? 'selected':''}>华佗</option>
                <option value="2" ${registrationInfor.doctorId == 2 ? 'selected':''}>扁鹊</option>
                <option value="3" ${registrationInfor.doctorId == 3 ? 'selected':''}>李时珍</option>
                <option value="4" ${registrationInfor.doctorId == 4 ? 'selected':''}>张仲景</option>
                <option value="5" ${registrationInfor.doctorId == 5 ? 'selected':''}>逸仙</option>
                <option value="6" ${registrationInfor.doctorId == 6 ? 'selected':''}>神农氏</option>
                <option value="7" ${registrationInfor.doctorId == 7 ? 'selected':''}>孙思邈</option>
                <option value="8" ${registrationInfor.doctorId == 8 ? 'selected':''}>白求恩</option>
            </select></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">备注</td>
            <td><textarea name="noted">${registrationInfor.noted}</textarea></td>
        </tr>
        <tr>
            <td colspan="2">
                <center>
                    <button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;<button
                        type="button" class="btn btn-success" name="backid" id="backid">返回列表
                </button>
                </center>
            </td>
        </tr>
    </table>
</form>

</body>
</html>  
