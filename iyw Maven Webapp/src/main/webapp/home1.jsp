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
    
    <title>后台管理系统</title>
    <meta content="IE=11.0000" http-equiv="X-UA-Compatible">
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="${basePath}hybrid/css/reset.css">
	<link rel="stylesheet" href="${basePath}hybrid/css/public.css">
	<link rel="stylesheet" href="${basePath}hybrid/css/style.css">
	<link rel="stylesheet" href="${basePath}hybrid/css/css.css">
	<script type="text/javascript" src="${basePath}js/jquery-1.11.1.min.js"></script>
	
	<script type="text/javascript" src="${basePath}hybrid/js/sdmenu.js"></script>
	
  </head>
  
  <body>
  	<!-- 顶部 --> 
    <header>
	  <h1><img src="${basePath}images/home/admin_logo.png"/></h1>
	    <ul class="rt_nav">
	    <li><a href="${basePath}login/login.jsp" target="_blank" class="website_icon">站点首页</a></li>
	    <li><a href="${basePath}login/login.jsp" class="set_icon">账号设置</a></li>
	    <li><a href="${basePath}login/login.jsp" class="quit_icon">安全退出</a></li>
	  </ul>
	</header>
	<!-- 顶部 --> 
	
	<!-- 内容展示 -->
	<div class="public-ifame mt20">
	  <div class="content">
	    <!-- 内容模块头 -->
		<div class="clearfix"></div>
		<!-- 左侧导航栏 -->
		<div class="public-ifame-leftnav">
			<ul class="left-nav-list">
				<li class="public-ifame-item">
					<a href="javascript:;">系统管理</a>
					<div class="ifame-item-sub">
						<ul>
							<li class="active"><a href="/login/login.jsp" target="content">用户管理</a></li>
							<li><a href="/login/login.jsp" target="content">角色管理</a></li>
							<li><a href="/login/login.jsp" target="content">权限管理</a></li>
							<li><a href="/login/login.jsp" target="content">菜单配置</a></li>
						</ul>
					</div>
				</li>
				<li class="public-ifame-item">
					<a href="javascript:;">入驻商</a>
				</li>
			</ul>
		</div>
		<!-- 右侧内容展示部分 -->
		<div class="public-ifame-content">
		<iframe name="content" src="/login/login.jsp" frameborder="0" id="mainframe" scrolling="yes" marginheight="0" marginwidth="0" width="100%" style="height: 700px;"></iframe>
		</div>
	</div>
</div>
<script>
$().ready(function(){
	var item = $(".public-ifame-item");

	for(var i=0; i < item.length; i++){
		$(item[i]).on('click',function(){
			$(".ifame-item-sub").hide();
			if($(this.lastElementChild).css('display') == 'block'){
				$(this.lastElementChild).hide()
				$(".ifame-item-sub li").removeClass("active");
			}else{
				$(this.lastElementChild).show();
				$(".ifame-item-sub li").on('click',function(){
					$(".ifame-item-sub li").removeClass("active");
					$(this).addClass("active");
				});
			}
		});
	}
});
</script>
	
  </body>
</html>
