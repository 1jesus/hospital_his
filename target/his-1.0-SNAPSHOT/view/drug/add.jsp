<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>添加药品---2015</title>
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
                window.location.href = "drug/index.jsp";
            });
        });
    </script>
</head>
<body>
<form action="drug/add.do" method="post" class="definewidth m20" enctype="multipart/form-data">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">药品编号</td>
            <td><input type="text" name="drugNum" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">图片</td>
            <td>
                <input type="file" name="file"/>
                <input type="hidden" name="drugUrl" value="">
                <%-- 预备回显图片的位置 --%>
                <img src="" width="300px" height="300px">
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">进价</td>
            <td><input type="text" name="purchasPrice" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">售价</td>
            <td><input type="text" name="salePrice" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">药品名称</td>
            <td><input type="text" name="drugName" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">药品类型</td>
            <td>
                <input type="radio" name="drugType" value="1"/>处方药&nbsp;&nbsp;&nbsp;
                <input type="radio" name="drugType" value="2"/>非处方药&nbsp;&nbsp;&nbsp;
                <input type="radio" name="drugType" value="3"/>中药&nbsp;&nbsp;&nbsp;
                <input type="radio" name="drugType" value="4"/>西药
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">简单描述</td>
            <td><input type="text" name="simpleDetail" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">生产日期</td>
            <td><input type="date" name="prodecedDate" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">过期日期</td>
            <td><input type="date" name="expirationDate" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">保质期</td>
            <td><input type="text" name="qualityDate" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">详细描述</td>
            <td><textarea name="detail"></textarea></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">生产厂商</td>
            <td><textarea name="manufacture"></textarea></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">服用说明</td>
            <td><input type="text" name="useInfor" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">总的进货量</td>
            <td><input type="text" name="totalStock" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">剩余量</td>
            <td><input type="text" name="surplus" value=""/></td>
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
<script>
    // 文件上传的输入框,绑定改变事件
    $("input[type=file]").change(function () {
        // new FormData的参数是一个DOM对象，而非jQuery对象
        var formData = new FormData($("form")[0]);
        $.ajax({
            url: "drug/upload.do",
            type: "POST",
            data: formData,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function (data) {
                $("img").attr("src", data.data);
                $("input[name=drugUrl]").val(data.data);
            }
        });
    })
</script>
</body>
</html>   
