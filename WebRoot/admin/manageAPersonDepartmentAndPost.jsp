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

<title>员工任职界面</title>

</head>
<%
	String empid = request.getParameter("empid");
	WorkRecordDao wrd = new WorkRecordDao();
	WorkRecord wr = wrd.getAPersonNowWorkRecord(empid);
	pageContext.setAttribute("wr", wr);
	String type = request.getParameter("type");
	String id;
	if (type == null || type.length() == 0)
		type = "normal";
	else {
		id = request.getParameter("id");
	}
	pageContext.setAttribute("type", type);
	pageContext.setAttribute("change", "change");
	pageContext.setAttribute("normal", "normal");
%>
<body>
	<div class="container">
		<div class="jumbotron">
			<h2>
				<font face="微软雅黑">人力资源管理系统</font>
			</h2>
			<h3>
				<font face="微软雅黑">管理员工任职信息</font>
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
			<h3>员工任职表</h3>
			<table class="table table-striped table-hover">
				<tr>
					<th>部门号</th>
					<th>职工号</th>
					<th>岗位名</th>
					<th>任该岗位开始时间</th>
					<th>操作</th>
				</tr>
				<c:if test="${!empty wr}">
					<c:if test="${type==normal}">
						<tr>
							<td>${wr.departmentID }</td>
							<td>${wr.employeID}</td>
							<td>${wr.postName }</td>
							<td>${wr.startTime }</td>
							<td><a
								href="manageAPersonDepartmentAndPost.jsp?type=change&id=${wr.employeID }">修改</a>
							</td>
						</tr>
					</c:if>
					<c:if test="${type==change}">
						<c:if test="${id==wr.employeID}">
							<form action="admin/ChangePersonDepartmentAndPost" method="post">
								<tr>
									<td><input type="text" name="departID"
										value="${wr.departmentID}" /></td>
									<td><input type="text" name="empid"
										value="${wr.employeID}" /></td>
									<td><input type="text" name="post" value="${wr.postName }" /></td>
									<td><input type="text" name="start_time"
										value="${wr.startTime }" /></td>
									<td><input type="submit" value="确认" /></td>
								</tr>
								<input type="hidden" name="id" value="${dp.departmentID}" /> <input
									type="hidden" name="type" value="change" />
							</form>
						</c:if>
					</c:if>
				</c:if>
			</table>
		</center>
		<!--footer starts here-->
		<iframe name="content_frame" width="100%" marginwidth="0"
			marginheight="0" frameborder="0" scrolling="NO" src="./footer.html"></iframe>
	</div>
</body>
</html>
