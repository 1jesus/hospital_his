<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title></title>
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
    <script type="text/javascript" src="static/Js/captcha.js"></script>
    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signin {
            max-width: 300px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }

    </style>
</head>
<body>
<div class="container form-signin">

    <h2 class="form-signin-heading">&nbsp;&nbsp;&nbsp;????????????</h2>
    <div>
        <button id="loginByUsername">?????????????????????</button>
        <button id="loginByEmail">?????????????????????</button>
        <button id="loginByPhone">?????????????????????</button>
    </div>

    <form id="form1" method="post" action="user/login.do">
        ?????????<input type="text" name="username" class="input-block-level" placeholder="??????">
        ??????<input type="password" name="password" class="input-block-level" placeholder="??????">
        <input id="captchaCode" type="text" class="input-medium" placeholder="?????????">
        <canvas width="80" height="35" id="captcha1"></canvas>
        <span>${msg}</span>
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button id="btn1" type="submit" class="btn btn-lg btn-primary">??????
        </button>
        </p>
    </form>

    <form id="form2" method="post" action="user/login/email.do" style="display:none;">
        ??????<input type="email" name="email" class="input-block-level" placeholder="??????">
        ?????????<input type="password" name="code" class="input-block-level" placeholder="?????????">
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button id="btn2" type="submit" class="btn btn-lg btn-primary">??????
        </button>
        </p>
    </form>

    <form id="form3" method="post" action="user/login/phone.do" style="display:none;">
        ?????????<input type="text" name="phone" class="input-block-level" placeholder="?????????">
        ?????????<input type="password" name="code" class="input-block-level" placeholder="?????????">
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button id="btn3" type="submit" class="btn btn-lg btn-primary">??????
        </button>
        </p>
    </form>
    <script type="text/javascript">
        // ??????????????????
        $("#loginByUsername").click(function () {
            $('#form1').css("display", "");
            $('#form2').css("display", "none");
            $('#form3').css("display", "none");

        });
        $("#loginByEmail").click(function () {
            $('#form1').css("display", "none");
            $('#form2').css("display", "");
            $('#form3').css("display", "none");

        });

        $("#loginByPhone").click(function () {
            $('#form1').css("display", "none");
            $('#form2').css("display", "none");
            $('#form3').css("display", "");

        });

        // (??????)????????????????????????
        $("input[name=email]").blur(function () {
            var email = $("input[name=email]").val();
            $.ajax({
                url: "user/send/email.do",
                data: "email=" + email,
                success: function (data) {
                    if (data.code = 200) {
                        alert("??????????????????,???????????????");
                    }
                },
                error: function () {
                    alert("???????????????!")
                }
            })
        })

        // (?????????)????????????????????????
        $("input[name=phone]").blur(function () {
            var phone = $("input[name=phone]").val();
            $.ajax({
                url: "user/send/phone.do",
                data: "phone=" + phone,
                success: function (data) {
                    var jsonStr = data.data;
                    var json = JSON.parse(jsonStr);
                    alert(json.returnsms.returnstatus + "-" + json.returnsms.message)
                },
                error: function () {
                    alert("???????????????!")
                }
            })
        })

        // ??????????????????,??????????????????????????????
        // $(function () {
        //     // ?????????????????????
        //     var captcha1 = new Captcha();
        //     // ???????????????,
        //     captcha1.draw(document.querySelector('#captcha1'), function (r) {
        //         // ?????????????????????????????????????????????
        //         var input = document.getElementById("captchaCode");
        //         input.onblur = function () {
        //             if (input.value != r) {
        //                 document.getElementById("btn1").setAttribute("disabled", "disabled");
        //             } else {
        //                 document.getElementById("btn1").removeAttribute("disabled");
        //             }
        //         }
        //     });
        // });
    </script>
</div>
</body>
</html>