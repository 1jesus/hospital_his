<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>录入住院信息-- -2015</title>
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
            <%--异步回显数据:
                 绑定失去焦点事件,触发后获得病历号,ajax异步查询病例信息`
            --%>
            <td width="10%" class="tableleft">病历号</td>
            <td><input id="i1" type="text" name="medicalRecord" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">姓名</td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">证件类型</td>
            <td>
                <input type="text" name="certificateType">
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">证件号</td>
            <td>
                <input type="text" name="idNum">
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">社保号</td>
            <td>
                <input type="text" name="socialSafeNum">
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">联系电话</td>
            <td>
                <input type="text" name="phone">
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">是否自费</td>
            <td>
                <input type="radio" name="selfPaying" value="2"/>否&nbsp;&nbsp;&nbsp;
                <input type="radio" name="selfPaying" value="1"/>是
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
            <td>
                <input type="text" name="age">
            </td>
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
                <select name="sectionId">
                </select></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">指定医生</td>
            <td><select name="doctorId">
                <option>程俊</option>
                <option>欧阳雨露</option>
                <option>王博</option>
            </select></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">备注</td>
            <td><textarea name="noted"></textarea></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">护理</td>
            <td><input type="text" name="caregiver" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">床位号</td>
            <td><input type="text" name="bedId" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">缴费押金</td>
            <td><input type="text" name="payTheDeposit" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">病情</td>
            <td><textarea name="stateIllness"></textarea></td>
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
<script>
    // 输入框失去焦点
    $("#i1").blur(function () {
        var medicalRecord = $("#i1").val();
        console.log(medicalRecord);
        $.ajax({
            url: "registration/one.do",
            data: "medicalRecord=" + medicalRecord,
            success: function (data) {
                var r = data.data;
                console.log(r);
                $("input[name=medicalRecord]").val(r.medicalRecord);
                $("input[name=name]").val(r.name);
                var certificateType = ""; // 证件类型
                if (r.certificateType == 1) {
                    certificateType = "身份证";
                } else if (r.certificateType == 2) {
                    certificateType = "护照";
                } else if (r.certificateType == 3) {
                    certificateType = "军官证";
                }
                $("input[name=certificateType]").val(certificateType);
                $("input[name=idNum]").val(r.idNum);
                $("input[name=socialSafeNum]").val(r.socialSafeNum);
                $("input[name=phone]").val(r.phone);
                // 是否自费 1是 2否
                if (r.selfPaying == 1) {
                    // 复合属性选择器,两个条件同时生效
                    $("input[name=selfPaying][value='1']").attr("checked", "checked");
                } else {
                    $("input[name=selfPaying][value='2']").attr("checked", "checked");
                }
                // 男/女
                if (r.sex == 1) { // 男
                    // 复合属性选择器,两个条件同时生效
                    $("input[name=sex][value='1']").attr("checked", "checked");
                } else {
                    $("input[name=sex][value='2']").attr("checked", "checked");
                }
                $("input[name=age]").val(r.age);
                // 初复诊
                if (r.earlyAppointment == 1) { // 初诊
                    // 复合属性选择器,两个条件同时生效
                    $("input[name=earlyAppointment][value='1']").attr("checked", "checked");
                } else {
                    $("input[name=earlyAppointment][value='2']").attr("checked", "checked");
                }
                // 所挂科室
                $("select[name=sectionId]").empty();
                $("select[name=sectionId]").append("<option>" + r.sectionName + "</option>");

                // 医生
                $("select[name=doctorId]").empty();
                $("select[name=doctorId]").append("<option>" + r.doctorName + "</option>");
            }
        })
    });
</script>
</body>
</html>
