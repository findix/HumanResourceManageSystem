<%@page import="dao.StatisticsDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<!-- <link rel="stylesheet" href="images/CoolWater.css" type="text/css" /> -->
<link rel="icon" href="http://www.find1x.com/favicon.ico"
	type="image/x-icon">
<link rel="shortcut icon" href="http://www.find1x.com/favicon.ico"
	type="image/x-icon">
<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
<script src="../js/jquery-ui-1.9.2.custom.js"></script>
<script src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/jquery-ui.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">

<link rel="stylesheet" href="../css/main.css">
<title>管理员登录界面</title>
</head>

<body>
	<div class="container">
		<div class="jumbotron">
			<h2>
				<font face="微软雅黑">人力资源管理系统</font>
			</h2>
			<h3>
				<font face="微软雅黑">管理员首页</font>
			</h3>
			<div id="menu">
				<ul>
					<li id="current"><a href="../login.jsp"><font face="微软雅黑">退出系统</font></a></li>
				</ul>
			</div>
			<div id="content-wrap">
				<div id="main">
					<table border="0" width="100%">
						<tr>
							<th align="center"><font face="黑体" size="4"><a
									href="manageDepartments.jsp">管理部门</a></font></th>
							<th align="center"><font face="黑体" size="4"><a
									href="managePost.jsp">管理岗位</a></font></th>
							<th align="center"><font face="黑体" size="4"><a
									href="manageTrain.jsp">管理培训</a></font></th>
							<th align="center"><font face="黑体" size="4"><a
									href="queryResult.jsp">管理员工</a></font></th>
							<th align="center"><font face="黑体" size="4"><a
									href="query.jsp">查询员工</a></font></th>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!--footer starts here-->
		<iframe name="content_frame" width="100%" marginwidth="0"
			marginheight="0" frameborder="0" scrolling="NO" src="../footer.html"></iframe>
	</div>
</body>
</html>
