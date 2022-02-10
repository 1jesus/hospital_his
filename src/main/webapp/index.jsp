<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>xx市第二人民医院信息管理系统</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="static/assets/css/dpl-min.css" rel="stylesheet" type="text/css"/>
    <link href="static/assets/css/bui-min.css" rel="stylesheet" type="text/css"/>
    <link href="static/assets/css/main-min.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<div class="header">

    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">程小凤</span>

        <a href="user/logout.do" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform">
            <div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div>
        </div>
        <ul id="J_Nav" class="nav-list ks-clear">
            <li class="nav-item dl-selected">
                <div class="nav-item-inner nav-home">医院管理系统</div>
            </li>

        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">
    </ul>
</div>
<script type="text/javascript" src="static/assets/js/jquery-1.6.js"></script>
<script type="text/javascript" src="static/assets/js/bui.js"></script>
<script type="text/javascript" src="static/assets/js/common/main-min.js"></script>
<script type="text/javascript" src="static/assets/js/config-min.js"></script>
<script>
    BUI.use('common/main', function () {
        var config = [
            {
                id: '1', menu: [

                    {
                        text: '快速通道', items: [
                            {id: '2', text: '挂号信息管理', href: 'registration/list.do'},
                            {id: '3', text: '门诊医生管理', href: 'doctor/list.do'},
                            {id: '4', text: '药品管理', href: 'drug/list.do'},
                            {id: '5', text: '住院办理', href: 'hospital/list.do'},

                            {id: '6', text: '收费项目登记', href: 'hospital/charge.html'},
                            {id: '7', text: '在院发药', href: 'hospital/dispensing.html'},
                            {id: '8', text: '住院结算', href: 'hospital/account.html'},
                            {id: '9', text: '月营业额统计', href: 'view/month/index.jsp'},
                            {id: '10', text: '年营业额统计', href: ''},

                            {id: '11', text: '用户管理', href: 'user/list.do'},
                            {id: '12', text: '角色管理', href: 'role/index.html'},
                            {id: '13', text: '资源管理', href: 'resource/index.html'},
                            {id: '14', text: '密码设置	', href: 'resource/index.html'}

                            //使用 JSTL 标签用于在 JSP页面进行权限控制
                            <%--                            <shiro:hasPermission name="/registration">--%>
                            <%--                            {id: '2', text: '挂号信息管理', href: 'registration/list.do'},--%>
                            <%--                            </shiro:hasPermission>--%>
                            <%--                            <shiro:hasPermission name="/doctor">--%>
                            <%--                            {id: '3', text: '门诊医生管理', href: 'doctor/list.do'},--%>
                            <%--                            </shiro:hasPermission>--%>
                            <%--                            <shiro:hasPermission name="/drug">--%>
                            <%--                            {id: '4', text: '药品管理', href: 'drug/list.do'},--%>
                            <%--                            </shiro:hasPermission>--%>
                            <%--                            <shiro:hasPermission name="/hospital">--%>
                            <%--                            {id: '5', text: '住院办理', href: 'hospital/list.do'},--%>
                            <%--                            </shiro:hasPermission>--%>

                            <%--                            <shiro:hasPermission name="/charge">--%>
                            <%--                            {id: '6', text: '收费项目登记', href: 'hospital/charge.html'},--%>
                            <%--                            </shiro:hasPermission>--%>
                            <%--                            <shiro:hasPermission name="/dispen">--%>
                            <%--                            {id: '7', text: '在院发药', href: 'hospital/dispensing.html'},--%>
                            <%--                            </shiro:hasPermission>--%>
                            <%--                            <shiro:hasPermission name="/clear">--%>
                            <%--                            {id: '8', text: '住院结算', href: 'hospital/account.html'},--%>
                            <%--                            </shiro:hasPermission>--%>
                            <%--                            <shiro:hasPermission name="/month">--%>
                            <%--                            {id: '9', text: '月营业额统计', href: 'view/month/index.jsp'},--%>
                            <%--                            </shiro:hasPermission>--%>
                            <%--                            <shiro:hasPermission name="/year">--%>
                            <%--                            {id: '10', text: '年营业额统计', href: ''},--%>
                            <%--                            </shiro:hasPermission>--%>

                            <%--                            <shiro:hasPermission name="/user">--%>
                            <%--                            {id: '11', text: '用户管理', href: 'user/list.do'},--%>
                            <%--                            </shiro:hasPermission>--%>
                            <%--                            <shiro:hasPermission name="/roles">--%>
                            <%--                            {id: '12', text: '角色管理', href: 'role/index.jsp'},--%>
                            <%--                            </shiro:hasPermission>--%>
                            <%--                            <shiro:hasPermission name="/permission">--%>
                            <%--                            {id: '13', text: '资源管理', href: 'resource/index.jsp'},--%>
                            <%--                            </shiro:hasPermission>--%>
                            <%--                            <shiro:hasPermission name="/password">--%>
                            <%--                            {id: '14', text: '密码设置	', href: 'resource/index.jsp'}--%>
                            <%--                            </shiro:hasPermission>--%>
                        ]
                    }
                ]
            }

        ];
        new PageUtil.MainPage({
            modulesConfig: config
        });
    });
</script>
</body>
</html>