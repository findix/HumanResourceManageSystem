<%@ page language="java" import="java.util.*,dao.*,pojo.*,viewPojo.*"
	pageEncoding="UTF-8"%>
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
<base href="<%=basePath%>">

<title>职员信息表</title>

</head>
<%
	String empid = request.getParameter("empid");
	PersonDao pd = new PersonDao();
	PersonAllInformation pai = pd.searchPerson(empid);
	pageContext.setAttribute("pai", pai);
	Wagetab wt = pd.getAPersonSalaryInformation(empid);
	pageContext.setAttribute("wt", wt);
%>
<body>
	<div class="container">
		<div class="jumbotron">
			<h2>
				<font face="微软雅黑">人力资源管理系统</font>
			</h2>
			<h3>
				<font face="微软雅黑">职员信息表</font>
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
			<h3>${pai.empname }的个人信息</h3>
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
				<tr>
					<td></td>
				</tr>
			</table>
			<h3>详细的工资详细</h3>
			<table class="table table-striped table-hover">
				<tr>
					<th>基本工资</th>
					<th>岗位工资</th>
					<th>应发工资</th>
					<th>实发工资</th>
				</tr>
				<tr>
					<td>￥${wt.basicWage }</td>
					<td>￥${wt.postWage }</td>
					<td>￥${wt.shouldWage }</td>
					<td>￥${wt.takehopay }</td>
				</tr>
			</table>
			<h4>扣除情况</h4>
			<table class="table table-striped table-hover">
				<tr>
					<th>公积金</th>
					<th>养老金</th>
					<th>医疗保险</th>
					<th>失业保险</th>
					<th>合计扣除</th>
				</tr>
				<tr>
					<td>￥${wt.reserveFunds }</td>
					<td>￥${wt.pension }</td>
					<td>￥${wt.medicare }</td>
					<td>￥${wt.unempinsure }</td>
					<td>￥${wt.delWage }</td>
				</tr>
			</table>
			<br> <a href="admin/index.jsp">返回</a>
		</center>
		<a href="admin/manageAPersonTrain.jsp?id=${pai.empid}">培训记录</a> <a
			href="admin/showAPersonWorkRecord.jsp?empid=${pai.empid}">历史工作记录</a>
		<!--footer starts here-->
		<iframe name="content_frame" width="100%" marginwidth="0"
			marginheight="0" frameborder="0" scrolling="NO" src="./footer.html"></iframe>
	</div>
</body>
</html>
