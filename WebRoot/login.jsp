<%@ page language="java" import="java.util.*,dao.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<base href="<%=basePath%>">
<title>人力资源管理系统登录界面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="icon" href="http://www.find1x.com/favicon.ico"
	type="image/x-icon">
<link rel="shortcut icon" href="http://www.find1x.com/favicon.ico"
	type="image/x-icon">
<script type="text/javascript" src="./js/jquery-1.8.3.js"></script>
<script src="./js/jquery-ui-1.9.2.custom.js"></script>
<script src="./js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./css/jquery-ui.css">
<link rel="stylesheet" href="./css/bootstrap.min.css">

<link rel="stylesheet" href="../css/main.css">

<script type="text/javascript">
	function censure() {
		var account, password;
		if (document.form1.user.value == "") {
			alert("请输入账号!"); //判断账号是否为空
			return false;
		}
		if (document.form1.password.value == "") {
			alert("请输入正确的密码!"); //判断密码是否为空
			return false;
		}
		return true;
	}
</script>
</head>

<body>
	<div class="container">
		<div class="jumbotron">
			<h1>
				<font face="微软雅黑">人力资源管理系统</font>
			</h1>
			<p class="text-warning">
				<font face="微软雅黑">职员权限：查看个人信息 <br>
					管理员权限：查看信息，修改信息，添加信息，删除信息
				</font>
			</p>
		</div>
		<center>
			<form action="Login" method="post" name="form1"
				onsubmit="return censure()">
				<div style="max-width: 300px;">
					<input type="radio" name="type" checked="checked" value="admin">
					管理员 <input type="radio" name="type" value="user"> 职员 <input
						class="form-control" placeholder="账号" type="text" name="name"><br />
					<input class="form-control" placeholder="用户名" type="password"
						name="password"> <br /> <input
						class="btn btn-lg btn-primary btn-block" type="submit" value="登录">
				</div>
			</form>
		</center>
		<iframe name="content_frame" width="100%" marginwidth="0"
			marginheight="0" frameborder="0" scrolling="NO" src="footer.html"></iframe>
	</div>
</body>
</html>