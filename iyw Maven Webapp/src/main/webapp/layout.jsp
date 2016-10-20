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
    
    <title>布局</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style type="text/css">
	
	  html{
	    overflow-y:hidden;
	  }
	
	  body{
	    margin:0;
	    height:100%;
	  }
	  
	  .container{
		width:100%;
		height:100%;
	  }
	  
	  .header{
		background:#19a97b; 
		width:100%;
		height:12%;
	  }
	  
	   .mainPage{
		width:100%;
		height:88%;
	  }
	  
	  .sidebar{
		background:#FFFFFF;
		width:16%;
		height:100%;
		float:left;
		overflow:auto;
	  }
	  
	  .content{
		background:#DBEAF9;
		width:84%;
		height:100%;
		float:right;
		overflow:auto;
	  }
	</style>
	
  </head>
  
  <body>
    <!-- 页面层容器 -->
    <div class="container">
      <!-- 页面头部 -->
      <div class="header">页面头部</div>
      <!-- 页面主体 -->
      <div class="mainPage">
        <!-- 侧边栏 -->
        <div class="sidebar">
          
        </div>
        <!-- 主体内容 -->
        <div class="content">内容</div>
      </div>	
    </div>
  </body>
</html>
