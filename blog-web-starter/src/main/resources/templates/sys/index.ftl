<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Posin 后台管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="js/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/index.css">
<#--    <link rel="stylesheet" href="/view/webjars/element/css/index.css">-->
<#--    <link rel="stylesheet" href="/view/webjars/icon-font/iconfont.css">-->
    <link rel="stylesheet" href="css/skins/all-skins.css">
<#--    <link rel="icon" href="favicon.ico" type="image/x-icon">-->
    <script src="/view/webjars/vue/vue.js"></script>
    <script src="js/sys/framework.js"></script>
    <#include "../emglobal.ftl">
    <#include "../component/audioPlayer.ftl">

</head>
<body class="hold-transition skin-blue sidebar-mini" style="overflow:hidden;">
<script src="js/jquery/jQuery-2.2.4.min.js"></script>
<script src="js/bootstrap/js/bootstrap.min.js"></script>

<div id="ajax-loader" style="cursor: progress; position: fixed; top: -50%; left: -50%; width: 200%; height: 200%; background: #fff; z-index: 10000; overflow: hidden;">
    <img src="img/ajax-loader.gif" style="position: absolute; top: 0; left: 0; right: 0; bottom: 0; margin: auto;" />
</div>
<div id="portal" class="wrapper">

    <!--头部信息-->
    <header class="main-header">
        <a href="/view/index" target="_blank" class="logo">
            <span class="logo-mini">Posin</span>
            <span class="logo-lg">Article<strong>后台管理</strong></span>
        </a>
        <nav class="navbar navbar-static-top">
            <a class="sidebar-toggle">
                <span class="sr-only">Article后台管理</span>
            </a>
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <li class="dropdown messages-menu">
                        <div style="margin-top: 4px; margin-right: 500px;">
                            <audio-player :is-pause-tts-audio="isPauseTtsAudio" :audio-url="audioUrl"></audio-player>
                        </div>
                    </li>
                    <li class="dropdown messages-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-envelope-o "></i>
                            <span class="label label-success">8</span>
                        </a>
                    </li>
                    <li class="dropdown notifications-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-bell-o"></i>
                            <span class="label label-warning">12</span>
                        </a>
                    </li>
                    <li class="dropdown tasks-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-flag-o"></i>
                            <span class="label label-danger">5</span>
                        </a>
                    </li>
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="img/user301.jpg" class="user-image" alt="User Image">
                            <span class="hidden-xs">系统管理员</span>
                        </a>
                        <ul class="dropdown-menu pull-right">
                            <li><a class="menuItem" data-id="userInfo" href="/view/userInfo"><i class="fa fa-user"></i>个人信息</a></li>
                            <li><a href="javascript:void();"><i class="fa fa-trash-o"></i>清空缓存</a></li>
                            <li><a href="javascript:void();"><i class="fa fa-paint-brush"></i>皮肤设置</a></li>
                            <li class="divider"></li>
                            <li><a @click="logout"><i class="ace-icon fa fa-power-off"></i>安全退出</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!--左边导航-->
    <div class="main-sidebar">
        <div class="sidebar">
            <div class="user-panel" style="cursor: pointer;">
                <div class="pull-left image">
                    <img src="img/user301.jpg" class="img-circle" alt="用户头像">
                </div>
                <div class="pull-left info">
                    <p>系统管理员</p>
                    <a><i class="fa fa-circle text-success"></i>在线</a>
                </div>
            </div>
            <form action="#" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" name="q" class="form-control" placeholder="搜索...">
                    <span class="input-group-btn">
                            <a class="btn btn-flat"><i class="fa fa-search"></i></a>
                        </span>
                </div>
            </form>
            <ul class="sidebar-menu" id="sidebar-menu">
                <!--<li class="header">导航菜单</li>-->
                <li class="treeview" v-for="menu in menus" :key="menu.id">
                    <a href="#">
                        <i :class="menu.icon"></i><span>{{menu.fullName}}</span><i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu" v-if="menu.childs && menu.childs.length > 0">
                        <li v-for="child in menu.childs" :key="child.id">
                            <a class="menuItem" :data-id="child.moduleId" :href="child.urlAddress" target="_parent"><i :class="child.icon"></i>{{child.fullName}}</a>
                        </li>

                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--中间内容-->
    <div id="content-wrapper" class="content-wrapper">
    <div class="content-tabs">
        <button class="roll-nav roll-left tabLeft">
            <i class="fa fa-backward"></i>
        </button>
        <nav class="page-tabs menuTabs">
            <div class="page-tabs-content" style="margin-left: 0px;">
                <a href="javascript:;" class="menuTab active" data-id="default"></a><!--默认页，但后面会被隐藏-->
            </div>
        </nav>
        <button class="roll-nav roll-right tabRight">
            <i class="fa fa-forward" style="margin-left: 3px;"></i>
        </button>
        <div class="btn-group roll-nav roll-right">
            <button class="dropdown tabClose" data-toggle="dropdown">
                页签操作<i class="fa fa-caret-down" style="padding-left: 3px;"></i>
            </button>
            <ul class="dropdown-menu dropdown-menu-right">
                <li><a class="tabReload" href="javascript:void();">刷新当前</a></li>
                <li><a class="tabCloseCurrent" href="javascript:void();">关闭当前</a></li>
                <li><a class="tabCloseOther" href="javascript:void();">关闭其他</a></li>
                <li><a class="tabCloseAll" href="javascript:void();">全部关闭</a></li>
            </ul>
        </div>
        <button class="roll-nav roll-right fullscreen"><i class="fa fa-arrows-alt"></i></button>
    </div>
    <div class="content-iframe" style="overflow: hidden;">
        <div class="mainContent" id="content-main" style="margin: 10px; margin-bottom: 0px; padding: 0;">
            <iframe class="LRADMS_iframe" width="100%" height="100%" src="default" frameborder="0" data-id="default.html"></iframe>
        </div>
    </div>
</div>
</div>
<script src="js/component/audioPlayer.js"></script>
</body>
<script type="text/javascript">

</script>
<script src="js/sys/portal.js"></script>
</html>
