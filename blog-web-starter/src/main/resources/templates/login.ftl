<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
<#--        <meta name="viewport" content="width=device-width, initial-scale=1.0">-->
<#--        <meta http-equiv="X-UA-Compatible" content="ie=edge">-->
    <title>欢迎来到Posin的后台管理系统</title>
    <#include "./emglobal.ftl">
    <link rel="stylesheet" href="${UI_WEB_SERVICE}css/login.css">
</head>
<body>
    <div class="container">
        <div class="login_body l_clear">
            <div class="login_form l_float">
                <div class="login_top">
                    <img src="${UI_WEB_SERVICE}icons/logo_z.svg" alt="" class="">

                    <div class="login_tags b_clear">
                        <span class="top_tag l_float active" onClick="PwdLogin()">密码登录</span>
                        <span class="top_tag r_float" onClick="QrcodeLogin()">扫码登录</span>
                    </div>
                </div>
                <div class="login_con">
                    <form action="" method="POST">
                        <div>
                            <label for="user_name">用户名</label>
                            <input type="text" name="" id="user_name" placeholder="账号/手机号/邮箱">
                            <img src="${UI_WEB_SERVICE}icons/user.svg">
                            <p class="tips hidden">请检查您的账号</p>
                        </div>
                        <div>
                            <label for="user_pwd">密码</label>
                            <input type="password" name="" id="user_pwd" placeholder="请输入账户密码">
                            <img src="${UI_WEB_SERVICE}icons/lock.svg">
                            <p class="tips hidden">请检查您的密码</p>
                        </div>
                        <div class="b_clear">
                            <label for="auth_code" class="b_clear">验证码</label>
                            <input type="text" name="" id="auth_code" placeholder="" class="l_float" maxlength="6">

                            <button class="auth_code l_float">获取验证码</button>
                            <img src="${UI_WEB_SERVICE}icons/auth_code.svg">
                            <p class="tips hidden">验证码错误</p>

                        </div>
                        <div class="b_clear submit">

                            <button type="submit">登&nbsp;&nbsp;录</button>
                            <a href="#" class="r_float">忘记密码？</a>
                            <p class="tips hidden">登录失败，请检查您的账户与密码</p>
                        </div>
                    </form>
                </div>
                <div class="login_con hidden">
                    <div class="qr_code">
                            <img src="${UI_WEB_SERVICE}img/qr.png" alt="">
                            <p>请使用微信扫码登录<br>仅支持已绑定微信的账户进行快速登录</p>
                    </div>

                </div>
                <div class="login_otherAccount">
                    <span>第三方登录</span>
                    <a href="http://"><img src="${UI_WEB_SERVICE}icons/wechat.svg" alt="微信登录"></a>
<#--                    <a href="http://"><img src="${UI_WEB_SERVICE}icons/weibo.svg" alt="微博登录"></a>-->
<#--                    <a href=""><img src="${UI_WEB_SERVICE}icons/qq.svg" alt="QQ登录"></a>-->
                </div>

            </div>
            <div class="login_ad l_float" id="AdImg">
                <div>
                    <h3>欢迎来到 Posin 的后台管理系统</h3>
                </div>
            </div>
        </div>
        <div class="footer">
                    <a href="https://beian.miit.gov.cn/" target="_blank"><img src="${UI_WEB_SERVICE}icons/icp_record_filing.svg" alt="工信部备案">京ICP备2023040310号</a>
                    <p>郑重申明:本网站所载内容未经许可严禁转载</p>
                </div>
    </div>

    <script src="${UI_WEB_SERVICE}js/login.js"></script>
<style>
.copyrights{text-indent:-9999px;height:0;line-height:0;font-size:0;overflow:hidden;}

</style>
</body>
</html>
