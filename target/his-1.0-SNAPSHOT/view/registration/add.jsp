<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>更改挂号-- -2015</title>
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
<form action="registration/add.do" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">姓名</td>
            <td><input type="text" name="name" value=""/><span>用户名的长度2-6位</span></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">证件类型</td>
            <td><select name="certificateType">
                <option value="1">身份证</option>
                <option value="2">护照</option>
                <option value="3">军人证</option>
            </select></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">证件号</td>
            <td><input type="text" name="idNum" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">社保号</td>
            <td><input type="text" name="socialSafeNum" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">挂号费</td>
            <td><input type="text" name="registrationFee" value=""/>元</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">联系电话</td>
            <td><input type="text" name="phone" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">是否自费</td>
            <td><input type="radio" name="selfPaying" value="1"/>否&nbsp;&nbsp;&nbsp;
                <input type="radio" name="selfPaying" value="2"/>是
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">性别</td>
            <td><input type="radio" name="sex" value="1"/>男&nbsp;&nbsp;&nbsp;
                <input type="radio" name="sex" value="2"/>女
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">年龄</td>
            <td><input type="text" name="age" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">职业</td>
            <td><input type="text" name="career" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">初复诊</td>
            <td><input type="radio" name="earlyAppointment" value="1"/>初诊&nbsp;&nbsp;&nbsp;
                <input type="radio" name="earlyAppointment" value="2"/>复诊
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">所挂科室</td>
            <td>
                <select name="sectionId" id="s1">
                    <c:forEach var="doctor" items="${doctorList}">
                        <option value="${doctor.id}">${doctor.sectionName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">指定医生</td>
            <td><select name="doctorId" id="d1">
                <option>--指定医生--</option>
                <%--<option value="1">华佗</option>--%>
                <%--<option value="2">扁鹊</option>--%>
                <%--<option value="3">李时珍</option>--%>
            </select></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">备注</td>
            <td><textarea name="noted"></textarea></td>
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
<script type="text/javascript">
    //异步查询医生
    $("#s1").change(function () {
        var s1 = $("#s1").val();

        console.log(s1);

        $.ajax({
            url: "doctor/findDoctors.do",
            data: "sectionId=" + s1,
            success: function (data) {
                //拼接医生名字前,先青空之前医生名字
                $("#d1").empty();
                if (data.code == 200) {
                    for (var i = 0; i < data.data.length; i++) {
                        $("#d1").append("<option value='" + data.data[i].id + "'>" + data.data[i].name + "</option>")
                    }
                }
            }
        })
    })
</script>
</body>
</html>    
