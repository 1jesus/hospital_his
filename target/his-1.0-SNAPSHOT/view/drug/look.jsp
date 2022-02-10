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
                window.location.href = "drug/list.do";
            });
        });
    </script>
</head>
<body>
<form action="index.html" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">药品编号</td>
            <td>${drug.drugNum}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">图片</td>
            <td><img width="100px" src="${drug.drugUrl}"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">进价</td>
            <td>${drug.purchasPrice}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">售价</td>
            <td>${drug.salePrice}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">药品名称</td>
            <td>${drug.drugName}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">药品类型</td>
            <td>
                <c:choose>
                    <c:when test="${drug.drugType == 1}">
                        处方药
                    </c:when>
                    <c:when test="${drug.drugType == 2}">
                        非处方药
                    </c:when>
                    <c:when test="${drug.drugType == 3}">
                        中药
                    </c:when>
                    <c:when test="${drug.drugType == 4}">
                        西药
                    </c:when>
                </c:choose>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">简单描述</td>
            <td>${drug.simpleDetail}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">生产日期</td>
            <td>
                <fmt:formatDate value="${drug.prodecedDate}" pattern="yyyy-MM-dd"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">保质期</td>
            <td>${drug.qualityDate}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">过期日期</td>
            <td>
                <fmt:formatDate value="${drug.expirationDate}" pattern="yyyy-MM-dd"/>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">详细描述</td>
            <td>${drug.detail}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">生产厂商</td>
            <td>${drug.manufacture}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">服用说明</td>
            <td>${drug.useInfor}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">库存</td>
            <td>${drug.totalStock}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">剩余量</td>
            <td>${drug.surplus}</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">备注</td>
            <td>${drug.noted}</td>
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
