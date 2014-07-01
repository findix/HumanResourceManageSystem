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

<title>人事变动界面</title>

</head>
<%
	String empid = request.getParameter("empid");
	WorkRecordDao wrd = new WorkRecordDao();
	WorkPostRecord[] wprs = wrd.getAPersonPastWorkRecord(empid);
	pageContext.setAttribute("wprs", wprs);
%>
<body>
	<div class="container">
		<div class="jumbotron">
			<h2>
				<font face="微软雅黑">人力资源管理系统</font>
			</h2>
			<h3>
				<font face="微软雅黑">人事变动界面</font>
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
			<h3>${empid}号员工的工作记录</h3>
			<table class="table table-striped table-hover">
				<tr>
					<th>曾任部门号</th>
					<th>曾任部门名称</th>
					<th>曾任岗位名</th>
					<th>任职开始时间</th>
				</tr>
				<c:if test="${empty wprs}">
       	该员工没有人事变动
    </c:if>
				<c:forEach items="${wprs}" var="wpr">
					<tr>
						<td>${wpr.departmentID }</td>
						<td>${wpr.departmentName }</td>
						<td>${wpr.postName }</td>
						<td>${wpr.startTime }</td>
					</tr>
				</c:forEach>
			</table>
		</center>
		<iframe name="content_frame" width="100%" marginwidth="0"
			marginheight="0" frameborder="0" scrolling="NO" src="./footer.html"></iframe>
	</div>
</body>
</html>
