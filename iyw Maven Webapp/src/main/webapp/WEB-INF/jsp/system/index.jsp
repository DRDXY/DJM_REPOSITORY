<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>管理首页 | IYW用户中心</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta content="IE=11.0000" http-equiv="X-UA-Compatible">
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <link type="text/css" rel="stylesheet" href="${basePath}temp/resource/css/framework.css" />
    <link type="text/css" rel="stylesheet" href="${basePath}temp/resource/css/main.css" />

  </head>
  
  <body>
    <div class="page">
<!--header begin-->
<header>
	<div class="bigcontainer">
		<div id="logo">
			<a href="./">yeelink用户中心</a>
		</div>
		<div class="user">
			<div class="ui compact notif menu">
			  <a class="item">
				<i class="mail large icon"></i>
				<span class="circular floating ui small red label"> 2 </span>
			  </a>
			</div>
            <div class="ui inline labeled icon top right pointing dropdown">
                <img class="ui avatar image" src="${basePath}temp/resource/images/avatar-default.gif">
			欢迎，$用户名
			<i class="dropdown icon"></i>
				<div class="menu">
					<a class="item" href="http://www.yeelink.net"><i class="reply mail icon"></i>返回首页</a>
					<a class="item" href="/login/login.jsp"><i class="sign out icon"></i>注销登录</a>
				</div>
			</div>
		</div>
	</div>
</header>
<!-- the main menu-->
<div class="ui teal inverted menu">
	<div class="bigcontainer">
		<div class="right menu">
			<a class="active item" href="./index.html"><i class="home icon"></i>管理首页</a>
			<a class="item" href="./devices_list.html"><i class="sitemap icon"></i>设备</a>
            <a class="item" href="./product_list.html"><i class="cloud icon"></i>产品</a>
			<a class="item" href="./user_profile.html"><i class="info icon"></i>账户</a>
		</div>
	</div>
</div>

<!--the main content begin-->
	<div class="container">
	<!--the content-->
		<div class="pageHeader">
			<div class="segment">
				<h3 class="ui dividing header">
  					<i class="large home icon"></i>
  					<div class="content">
    					管理首页
    				<div class="sub header">快速查看和编辑</div>
  					</div>
				</h3>
			</div>
		</div>
        <div class="ui warning message">
            	<i class="close icon" data-dismiss="alert"></i>
            <div class="header">
            	<i class="warning icon"></i> 当前帐户还未激活.
            </div>
            未激活账户无法使用Yeelink服务，请检查注册时填写的邮箱，完成验证。
            <a href="http://www.yeelink.net/login/resend_activate_mail" title="重新发送激活邮件">未收到激活邮件？</a>
        </div>
       <div class="ui small message" id="showApiKey">
           <div class="ui form segment">
                <div class="inline field">
                    <label>您的API Key :</label>
                    <div class="ui small left icon input short">
                        <i class="key icon"></i>
                        <input type="text" value="793jIEGJjkjkljfUI3JRTJOIO" readonly="readonly" id="apiKey">
                    </div>
                    <a class="ui mini green button" id="copy-apiKey" href="#">复制</a>
                    <a class="ui mini blue animated button" href=./apikey_manage.html>
                        <span class="visible content">管理</span>
                        <span class="hidden content">
                            <i class="key icon"></i>
                        </span>
                    </a>
                    <a id="deviceQuickButton" class="ui red small labeled icon button" href="./devices_list.html">
                        <i class="settings icon"></i>管理所有设备
                    </a>
                </div>
          </div>
      </div>
	<!--device list-->
	<div class="ui three column grid" id="indexList">
		<div class="row">
			<div class="column">
				<div class="ui blue segment">
					<a href="./device.html" class="content">
						<h4 class="deviceName">设备名01</h4>
						<p class="deviceId">设备ID：234</p>
						<p class="deviceDescription">这里是设备描述。</p>
						<p class="sensorStatus">传感器状态：
                            <span class="ui green ok label" ></span>
                            <span class="ui green ok label" ></span>
                            <span class="ui green ok label" ></span>
                            <span class="ui red error label" ></span>
                            <span class="ui green ok label" ></span>
                            <span class="ui green ok label" ></span>
                            <span class="ui green ok label" ></span>
                            <span class="ui green ok label" ></span>
                            <span class="ui green ok label" ></span>
                            <span class="ui green ok label" ></span>
                        </p>
					</a>
				</div>
			</div>
			<div class="column">
				<div class="ui blue segment">
					<a class="content" href="#">
						<h4 class="deviceName">设备名02</h4>
						<p class="deviceId">设备ID：4354</p>
						<p class="deviceDescription">这里是设备描述。</p>
                        <p class="sensorStatus">传感器状态：
                            <span class="ui green ok label" ></span>
                            <span class="ui green ok label" ></span>
                            <span class="ui green ok label" ></span>
                        </p>
					</a>
				</div>
			</div>
			<div class="column">
				<div class="ui blue segment">
					<a class="content" href="#">
						<h4 class="deviceName">设备名03</h4>
						<p class="deviceId">设备ID：344</p>
						<p class="deviceDescription">这里是设备描述。</p>
						<p class="sensorStatus">传感器状态：
                            <span class="ui green ok label" ></span>
                            <span class="ui green ok label" ></span>
                            <span class="ui green ok label" ></span>
                        </p>
					</a>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="column">
				<div class="ui blue segment">
					<a class="content" href="./add.html">
						<h4 class="newDevice"><i class="huge add icon"></i>
						添加新设备</h4>
					</a>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
<!--footer begin-->
<footer>
	<div id="copyrights">
		<div class="inset">
			<div class="bigcontainer">
				<div class="fl">
					<div class="logo"></div>
					<p>&copy; 2020 浙江三只眼信息技术有限公司, 版权所有 <a href="http://www.baidu.com/" target="_blank">iyw</a><br />
<a href="http://www.miibeian.gov.cn" target="_blank">浙ICP备12022271号</a></p>
				</div>
			</div>
		</div>
	</div>
</footer>

<script type="text/javascript" src="${basePath}temp/resource/javascript/jquery.min.js"></script>
<script type="text/javascript" src="${basePath}temp/resource/javascript/framework.js"></script>
<script type="text/javascript" src="${basePath}temp/resource/javascript/jquery.zclip.min.js"></script>
<script type="text/javascript" src="${basePath}temp/resource/javascript/alert.js"></script>
<script>
	$(document).ready(function(){
		$('a#copy-apiKey').zclip({
			path:'/temp/resource/javascript/ZeroClipboard.swf',
			copy:function(){return $('input#apiKey').val();}
		});

		$('.ui.dropdown')
			.dropdown();
	});
</script>
  </body>
</html>
