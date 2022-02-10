<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>修改住院信息-- -2015</title>
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
<%--
    private String doctorName;
    private String sectionName;
    private Integer bedId;     //床位号
    private Double payTheDeposit; //缴费押金
    private String caregiver; //护理
    private String stateIllness; //病情

    private String name;
    private Integer certificateType;
    private String idNum;
    private String socialSafeNum;
    private String phone;
    private Integer selfPaying;
    private Integer sex;
    private String career;
    private Integer earlyAppointment;
    private Integer doctorId;
    privte Integer status;
    private String noted;
    private Date time;
    private Integer sectionId;
    private Integer age;
    private Double registrationFee;

    private String caregiver;
    private Integer bedId;
    private Double payTheDeposit;
    private String stateIllness;
--%>
<form action="hospital/update2.do" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">病历号</td>
            <td>
                <input type="text" name="medicalRecord" value="${registrationInforVo.medicalRecord}"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">姓名</td>
            <td>
                <input type="text" name="name" value="${registrationInforVo.name}"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">证件类型</td>
            <td>
                <select name="certificateType">
                    <option value="1" ${registrationInforVo.certificateType == 1? 'selected':''}>身份证</option>
                    <option value="2" ${registrationInforVo.certificateType == 2? 'selected':''}>护照</option>
                    <option value="3" ${registrationInforVo.certificateType == 3? 'selected':''}>军人证</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">证件号</td>
            <td>
                <input type="text" name="idNum" value="${registrationInforVo.idNum}"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">社保号</td>
            <td><input type="text" name="socialSafeNum" value="${registrationInforVo.socialSafeNum}"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">联系电话</td>
            <td><input type="text" name="phone" value="${registrationInforVo.phone}"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">是否自费</td>
            <td>
                <input type="radio" name="selfPaying" value="1" ${registrationInforVo.selfPaying == 1 ? 'checked':''}/>否&nbsp;&nbsp;&nbsp;
                <input type="radio" name="selfPaying" value="2" ${registrationInforVo.selfPaying == 2 ? 'checked':''}/>是
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">性别</td>
            <td>
                <input type="radio" name="sex" value="1" ${registrationInforVo.sex == 1 ? 'checked':''}/>男&nbsp;&nbsp;&nbsp;
                <input type="radio" name="sex" value="2" ${registrationInforVo.sex == 2 ? 'checked':''}/>女
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">年龄</td>
            <td><input type="text" name="age" value="${registrationInforVo.age}"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">初复诊</td>
            <td>
                <input type="radio" name="earlyAppointment"
                       value="1" ${registrationInforVo.earlyAppointment == 1? 'checked':''}/>初诊&nbsp;&nbsp;&nbsp;
                <input type="radio" name="earlyAppointment"
                       value="2" ${registrationInforVo.earlyAppointment == 2? 'checked':''}/>复诊
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">所挂科室</td>
            <td>
                <select name="sectionId">
                    <option value="1" ${registrationInforVo.sectionId == 1 ? 'selected':''}>血液科</option>
                    <option value="2" ${registrationInforVo.sectionId == 2 ? 'selected':''}>骨科</option>
                    <option value="3" ${registrationInforVo.sectionId == 3 ? 'selected':''}>外科</option>
                    <option value="4" ${registrationInforVo.sectionId == 4 ? 'selected':''}>急诊科</option>
                    <option value="5" ${registrationInforVo.sectionId == 5 ? 'selected':''}>妇科</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">指定医生</td>
            <td><select name="doctorId">
                <option value="1" ${registrationInforVo.doctorId == 1 ? 'selected':''}>华佗</option>
                <option value="2" ${registrationInforVo.doctorId == 2 ? 'selected':''}>扁鹊</option>
                <option value="3" ${registrationInforVo.doctorId == 3 ? 'selected':''}>李时珍</option>
                <option value="4" ${registrationInforVo.doctorId == 4 ? 'selected':''}>张仲景</option>
                <option value="5" ${registrationInforVo.doctorId == 5 ? 'selected':''}>逸仙</option>
                <option value="6" ${registrationInforVo.doctorId == 6 ? 'selected':''}>神农氏</option>
                <option value="7" ${registrationInforVo.doctorId == 7 ? 'selected':''}>孙思邈</option>
                <option value="8" ${registrationInforVo.doctorId == 8 ? 'selected':''}>白求恩</option>
            </select></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">备注</td>
            <td><textarea name="noted">${registrationInforVo.noted}</textarea></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">护理</td>
            <td>
                <input type="text" name="caregiver" value="${registrationInforVo.caregiver}"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">床位号</td>
            <td>
                <input type="text" name="bedId" value="${registrationInforVo.bedId}"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">缴费押金</td>
            <td><input type="text" name="payTheDeposit" value="${registrationInforVo.payTheDeposit}"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">病情</td>
            <td><textarea name="stateIllness">${registrationInforVo.stateIllness}</textarea></td>
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
