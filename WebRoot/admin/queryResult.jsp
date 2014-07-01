<%@ page language="java" import="java.util.*,dao.*,pojo.*,viewPojo.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<base href="<%=basePath%>">

<title>职员信息</title>

</head>
<%
	String empid = request.getParameter("empid");
	String empname = request.getParameter("empname");
	String department = request.getParameter("department");
	String postname = request.getParameter("postname");
	String salaryup = request.getParameter("salarystart");
	String salaryend = request.getParameter("salaryend");
	String edubg = request.getParameter("edubg");
	PersonDao dao = new PersonDao();
	PersonAllInformation[] ps = dao.searchPerson(empid, department,
			salaryup, salaryend, postname, empname, edubg, null);
	pageContext.setAttribute("ps", ps);
%>
<body>
	<div class="container">
		<div class="jumbotron">
			<h2>
				<font face="微软雅黑">人力资源管理系统</font>
			</h2>
			<h3>
				<font face="微软雅黑">管理员工</font>
			</h3>
			<div id="menu">
				<ul>
					<li><a href=""><font face="微软雅黑">退出系统</font></a></li>
				</ul>
				<ul>
					<li><a href="admin/index.jsp"><font face="微软雅黑">返回管理员首页</font></a></li>
				</ul>
			</div>
		</div>
		<center>
			<table class="table table-striped table-hover">
				<tr>
					<th>职员信息</th>
				</tr>
				<tr>
					<th>职工号</th>
					<th>职工姓名</th>
					<th>部门名</th>
					<th>办公室地址</th>
					<th>岗位</th>
					<th>基本工资</th>
					<th>岗位工资</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${ps}" var="pai">
					<tr>
						<td><a
							href="admin/manageAPersonAllInformation.jsp?empid=${pai.empid}">${pai.empid}</a></td>
						<td>${pai.empname }</td>
						<td>${pai.departmentName }</td>
						<td>${pai.officeAddress }</td>
						<td>${pai.postName }</td>
						<td>${pai.basicWage }</td>
						<td>${pai.postSalary }</td>
						<td><a href="admin/ManagePerson?type=del&empid=${pai.empid}">删除</a>
							<a
							href="admin/managePersonInformation.jsp?type=change&id=${pai.empid}">修改</a>
					</tr>
				</c:forEach>
			</table>
			<a href="admin/managePersonInformation.jsp?type=add">添加</a>
		</center>
		<!--footer starts here-->
		<iframe name="content_frame" width="100%" marginwidth="0"
			marginheight="0" frameborder="0" scrolling="NO" src="./footer.html"></iframe>
	</div>
</body>
</html>
