<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  <title>登录页面</title>
  <meta content="IE=11.0000" http-equiv="X-UA-Compatible">
  <meta http-equiv="content-type" content="text/html;charset=utf-8">
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="DJM,IYW">
  <meta http-equiv="description" content="LOGIN">
  <!-- Bootstrap -->
  <link rel="stylesheet" type="text/css" href="${basePath}bootstrap/css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="${basePath}css/login/login.css">
  <script type="text/javascript" src="${basePath}js/jquery-1.11.1.min.js"></script>
  <script type="text/javascript" src="${basePath}bootstrap/js/bootstrap.js"></script>
  <script type="text/javascript" src="${basePath}js/login/login.js"></script>
</head>
<body>

  <div class="top_div"></div>
  <div class="big_div">
    <div class="anime_div">
      <div class="tou"></div>
      <div class="initial_left_hand" id="left_hand"></div>
      <div class="initial_right_hand" id="right_hand"></div>
    </div>
    <form class="form-inline" role="form" action="system/user_authentication.do" method="post">
  	  <div class="form-group" style="padding: 30px 0px 10px; position: relative;">
        <div class="input-group">
          <div class="input-group-addon">用户名:</div>
          <input name="userName" class="form-control" type="text" style="width:230px;" placeholder="请输入用户名或邮箱">
        </div>
      </div>
      <div class="form-group" style="position: relative;">
        <div class="input-group">
          <div class="input-group-addon">&nbsp;&nbsp;&nbsp;密码:</div>
          <input name="password" id="password" class="form-control" type="password" style="width:230px;" placeholder="请输入密码">
        </div>
      </div>
      <div class="bottom_div">
	    <p style="margin: 0px 35px 20px 45px;">
	      <span class="forget_span"><a class="forget_a" href="#">忘记密码?</a></span> 
          <span class="register_span">
          	<a class="register_a" href="#">注册</a>
          	<a href="<c:url value="/j_spring_security_logout" />"> Logout</a>
          	<button type="submit" class="btn btn-warning">登录</button>
          	<!-- <a class="login_a" href="#">登录</a> -->
          </span>         
        </p>
      </div>
    </form>
  </div>
</body>
</html>
