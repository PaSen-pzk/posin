<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>欢迎来到Posin的后台管理系统</title>
  <meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
  <meta name="author" content="Vincent Garreau" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <#include "./emglobal.ftl">
  <link rel="stylesheet" media="screen" href="${UI_WEB_SERVICE}css/style_.css">
  <link rel="stylesheet" type="text/css" href="${UI_WEB_SERVICE}css/reset_.css"/>
</head>
<body>

<div id="particles-js">
	<div class="login">
		<div class="login-top">
			登录
		</div>
		<form method="POST">
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="img/name.png"/></div>
				<div class="login-center-input">
					<input id="username" type="text" name="username" value="" placeholder="请输入您的用户名" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的用户名'"/>
					<div class="login-center-input-text">用户名</div>
				</div>
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="img/password.png"/></div>
				<div class="login-center-input">
					<input id="password" type="password" name="password" value="" placeholder="请输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'"/>
					<div class="login-center-input-text">密码</div>
				</div>
			</div>
<#--		<div class="login-button" type="submit">登&nbsp;&nbsp;录</div>-->
			<div class="login-center">
				<button class="login-button" type="button">登&nbsp;&nbsp;录</button>
			</div>
		</form>
	</div>
	<div class="sk-rotating-plane"></div>
</div>
<div class="footer">
	<a href="https://beian.miit.gov.cn/" target="_blank"><img src="${UI_WEB_SERVICE}icons/icp_record_filing.svg" alt="工信部备案">京ICP备2023040310号</a>
	<p>郑重申明:本网站所载内容未经许可严禁转载</p>
</div>

<!-- scripts -->
<script src="js/particles.min.js"></script>
<script src="js/app.js"></script>
<script type="text/javascript">
function hasClass(elem, cls) {
  cls = cls || '';
  if (cls.replace(/\s/g, '').length == 0) return false; //当cls没有参数时，返回false
  return new RegExp(' ' + cls + ' ').test(' ' + elem.className + ' ');
}

function addClass(ele, cls) {
  if (!hasClass(ele, cls)) {
	ele.className = ele.className == '' ? cls : ele.className + ' ' + cls;
  }
}

function removeClass(ele, cls) {
  if (hasClass(ele, cls)) {
	var newClass = ' ' + ele.className.replace(/[\t\r\n]/g, '') + ' ';
	while (newClass.indexOf(' ' + cls + ' ') >= 0) {
	  newClass = newClass.replace(' ' + cls + ' ', ' ');
	}
	ele.className = newClass.replace(/^\s+|\s+$/g, '');
  }
}
document.querySelector(".login-button").onclick = function(){
	addClass(document.querySelector(".login"), "active")
	setTimeout(function(){
		addClass(document.querySelector(".sk-rotating-plane"), "active")
		document.querySelector(".login").style.display = "none"
	},800)
	let username = document.getElementById("username").value;
	let password = document.getElementById("password").value;
	let param = {
		username: username,
		password: password
	}
	AjaxInvk(ADMIN_API_SERVICE + ADMIN_SERVER.SYS_LOGIN, JSON.stringify(param),"post",function (res) {
		console.log(res)
		if(res.code == SERVICE_RESPONSE.SUCCESS.CODE){
			console.log("登录成功")
			sessionStorage.setItem("X-AUTH-TOKEN", res.data.token);
			window.location.href = window.origin.concat("/view/index");
			history.pushState(null, null, window.location.href);
		} else {
			setTimeout(function(){
				removeClass(document.querySelector(".login"), "active")
				removeClass(document.querySelector(".sk-rotating-plane"), "active")
				document.querySelector(".login").style.display = "block"
				// alert("登录成功")
			},5000)
		}
	});
	// setTimeout(function(){
	// 	removeClass(document.querySelector(".login"), "active")
	// 	removeClass(document.querySelector(".sk-rotating-plane"), "active")
	// 	document.querySelector(".login").style.display = "block"
	// 	// alert("登录成功")
	// },5000)
}
</script>
<style>
.copyrights{text-indent:-9999px;height:0;line-height:0;font-size:0;overflow:hidden;}
.footer {
	font-size: 12px;
	padding: 0 10px;
	text-align: center;
	margin-top: 26px;
	width: 1200px;
	margin: 20px auto;
}
.footer, .footer>p, .footer a {
	color: #999999;
	text-decoration: none;
}
.footer>a>img {
	height: 20px;
	vertical-align: middle;
	margin-right: 4px;
}
</style>
</body>
</html>
