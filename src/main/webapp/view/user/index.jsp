<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>User</title>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="static/Css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="static/Css/bootstrap-responsive.css">
    <link rel="stylesheet" type="text/css" href="static/Css/style.css"/>
    <script type="text/javascript" src="static/Js/jquery.js"></script>
    <script type="text/javascript" src="static/Js/bootstrap.js"></script>
    <script type="text/javascript" src="static/Js/ckform.js"></script>
    <script type="text/javascript" src="static/Js/common.js"></script>


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
            $('#newNav').click(function () {
                window.location.href = "user/role/list.do";
            });
        });


        function checkall() {
            var alls = document.getElementsByName("check");
            var ch = document.getElementById("checkall");
            if (ch.checked) {
                for (var i = 0; i < alls.length; i++) {
                    alls[i].checked = true;
                }
            } else {
                for (var i = 0; i < alls.length; i++) {
                    alls[i].checked = false;
                }
            }
        }

        function delAll() {
            var alls = document.getElementsByName("check");
            var ids = new Array();
            for (var i = 0; i < alls.length; i++) {
                if (alls[i].checked) {
                    ids.push(alls[i].value);
                }
            }
            if (ids.length > 0) {
                if (confirm("?????????????")) {
                    alert("????????????!");
                }
            } else {
                alert("????????????????????????");
            }
        }
    </script>
</head>
<body>
<form class="form-inline definewidth m20" action="index.jsp" method="get">
    ???????????????
    <input type="text" name="username" id="username" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">??????</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th width="5%"><input type="checkbox" id="checkall" onChange="checkall();"></th>
        <th>????????????</th>
        <th>????????????</th>
        <th>??????</th>
        <th width="10%">??????</th>
    </tr>
    </thead>
    <c:forEach var="u" items="${pageInfo.list}">
        <tr>
            <td style="vertical-align:middle;">
                <input type="checkbox" name="check" value="1">
            </td>
            <td>${u.userName}</td>
            <td>${u.realName}</td>
            <td>
                <c:forEach var="role" items="${u.roles}">
                    <span class="glyphicon glyphicon-user"></span>
                    ${role.roleName}
                </c:forEach>
            </td>
            <td>
                <a href="editUser.html">??????</a>&nbsp;&nbsp;&nbsp;<a href="javascript:alert('???????????????');">??????</a>
            </td>
        </tr>
    </c:forEach>
</table>
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <th colspan="5">
            <div class="inline pull-right page">
                <a href='user/list.do?pageNo=1'>?????????</a>
                <a href='user/list.do?pageNo=${pageInfo.prePage}'>?????????</a>

                <c:forEach begin="1" end="${pageInfo.pages}" var="i">
                    <a href="user/list.do?pageNo=${i}"
                       class="${pageInfo.pageNum == i ? 'current':''}">
                        <span>${i}</span>
                    </a>
                </c:forEach>

                <a href='user/list.do?pageNo=${pageInfo.nextPage}'>?????????</a>
                <a href='user/list.do?pageNo=${pageInfo.pages}'>????????????</a>
                &nbsp;&nbsp;&nbsp;???<span class='current'>${pageInfo.total}</span>?????????
                <span class='current'> ${pageInfo.pageNum}/${pageInfo.pages} </span>???
            </div>
            <div>
                <button type="button" class="btn btn-success" id="newNav">????????????</button>&nbsp;&nbsp;&nbsp;<button
                    type="button" class="btn btn-success" id="delPro" onClick="delAll();">????????????
            </button>
            </div>
        </th>
    </tr>
</table>
</body>
</html>