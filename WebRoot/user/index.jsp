<%@ page language="java" import="java.util.*,dao.*,pojo.*,viewPojo.*"
	pageEncoding="utf-8"%>
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

<title>您的个人信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="icon" href="http://www.find1x.com/favicon.ico"
	type="image/x-icon">
<link rel="shortcut icon" href="http://www.find1x.com/favicon.ico"
	type="image/x-icon">
<script type="text/javascript" src="./js/jquery-1.8.3.js"></script>
<script src="./js/jquery-ui-1.9.2.custom.js"></script>
<script src="./js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./css/jquery-ui.css">
<link rel="stylesheet" href="./css/bootstrap.min.css">

<link rel="stylesheet" href="css/main.css">
</head>
<%
	String empid = (String) session.getAttribute("empid");
	PersonDao pd = new PersonDao();
	PersonAllInformation pai = pd.searchPerson(empid);
	pageContext.setAttribute("pai", pai);
%>

<body>
	<div class="row">
		<div class="container">
			<div class="jumbotron">
				<h2>
					<font face="微软雅黑">人力资源管理系统</font>
				</h2>
				<h3>
					<font face="微软雅黑">个人信息</font>
				</h3>
				<div id="menu">
					<ul>
						<li><a href=""><font face="微软雅黑">退出系统</font></a></li>
					</ul>
				</div>
			</div>
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<table class="table table-striped table-hover">
					<tr>
						<th>职工号</th>
						<td>${pai.empid }</td>
					</tr>
					<tr>
						<th>职工姓名</th>
						<td>${pai.empname }</td>
					</tr>
					<tr>
						<th>学历</th>
						<td>${pai.educationBackground}</td>
					</tr>
					<tr>
						<th>参加工作时间</th>
						<td>${pai.joinWorkTime }</td>
					</tr>
					<tr>
						<th>加入公司时间</th>
						<td>${pai.joinCompanyTime}</td>
					</tr>
					<tr>
						<th>政治面貌</th>
						<td>${pai.polistatus }</td>
					</tr>
					<tr>
						<th>部门号</th>
						<td>${pai.departmentID }</td>
					</tr>
					<tr>
						<th>部门名</th>
						<td>${pai.departmentName}</td>
					</tr>
					<tr>
						<th>部门办公室</th>
						<td>${pai.officeAddress}</td>
					</tr>
					<tr>
						<th>岗位</th>
						<td>${pai.postName}</td>
					</tr>
					<tr>
						<th>基本工资</th>
						<td>${pai.basicWage }</td>
					</tr>
					<tr>
						<th>岗位工资</th>
						<td>${pai.postSalary}</td>
					</tr>
					<tr>
						<th>岗位描述</th>
						<td>${pai.detail}</td>
					</tr>
				</table>
			</div>
			<div class="col-md-4"></div>
			<iframe name="content_frame" width="100%" marginwidth="0"
				marginheight="0" frameborder="0" scrolling="NO" src="./footer.html"></iframe>
		</div>
	</div>
</body>
</html>
