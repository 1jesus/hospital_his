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
                if (confirm("确认删除?")) {
                    alert("删除成功!");
                }
            } else {
                alert("请选中要删除的项");
            }
        }
    </script>
</head>
<body>
<form class="form-inline definewidth m20" action="index.jsp" method="get">
    用户名称：
    <input type="text" name="username" id="username" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">查询</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th width="5%"><input type="checkbox" id="checkall" onChange="checkall();"></th>
        <th>用户账户</th>
        <th>真实姓名</th>
        <th>角色</th>
        <th width="10%">操作</th>
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
                <a href="editUser.html">编辑</a>&nbsp;&nbsp;&nbsp;<a href="javascript:alert('删除成功！');">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <th colspan="5">
            <div class="inline pull-right page">
                <a href='user/list.do?pageNo=1'>第一页</a>
                <a href='user/list.do?pageNo=${pageInfo.prePage}'>上一页</a>

                <c:forEach begin="1" end="${pageInfo.pages}" var="i">
                    <a href="user/list.do?pageNo=${i}"
                       class="${pageInfo.pageNum == i ? 'current':''}">
                        <span>${i}</span>
                    </a>
                </c:forEach>

                <a href='user/list.do?pageNo=${pageInfo.nextPage}'>下一页</a>
                <a href='user/list.do?pageNo=${pageInfo.pages}'>最后一页</a>
                &nbsp;&nbsp;&nbsp;共<span class='current'>${pageInfo.total}</span>条记录
                <span class='current'> ${pageInfo.pageNum}/${pageInfo.pages} </span>页
            </div>
            <div>
                <button type="button" class="btn btn-success" id="newNav">添加用户</button>&nbsp;&nbsp;&nbsp;<button
                    type="button" class="btn btn-success" id="delPro" onClick="delAll();">删除选中
            </button>
            </div>
        </th>
    </tr>
</table>
</body>
</html>