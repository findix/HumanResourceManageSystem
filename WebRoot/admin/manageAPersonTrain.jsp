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

<title>职员培训记录</title>

</head>
<%
	String type = request.getParameter("type");
	if (type == null || type.length() == 0) {
		type = "normal";
	}
	pageContext.setAttribute("type", type);
	pageContext.setAttribute("change", "change");
	pageContext.setAttribute("del", "del");
	pageContext.setAttribute("normal", "normal");
	String empid = request.getParameter("id");
	pageContext.setAttribute("empid", empid);
	TrainRecordDao trd = new TrainRecordDao();
	TrainInformation[] tis = trd.getAPersonAllTrainRecord(empid);
	pageContext.setAttribute("tis", tis);
	String id = request.getParameter("id");
	pageContext.setAttribute("id", id);
%>
<body>
	<div class="container">
		<div class="jumbotron">
			<h2>
				<font face="微软雅黑">人力资源管理系统</font>
			</h2>
			<h3>
				<font face="微软雅黑">管理职员培训记录</font>
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
			<h3>员工培训记录</h3>
			<table class="table table-striped table-hover">
				<tr>
					<th>职工号</th>
					<th>培训号</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>培训内容</th>
					<th>操作</th>
				</tr>
				<c:if test="${!empty tis}">
					<c:forEach items="${tis}" var="ti">
						<c:if test="${type==normal}">
							<tr>
								<td><a
									href="admin/manageAPersonAllInformation.jsp?empid=${empid }">${empid}</a></td>
								<td><a href="admin/manageTrain.jsp">${ti.trainID}</a></td>
								<td>${ti.startTime }</td>
								<td>${ti.endTime }</td>
								<td>${ti.content }</td>
								<td><a
									href="admin/ManageAPersonTrain?type=del&pid=${empid }&tid=${ti.trainID }">删除</a>
								</td>
							</tr>
						</c:if>
					</c:forEach>
				</c:if>
			</table>

			<h3>添加员工培训记录</h3>
			<form action="admin/ManageAPersonTrain" method="post">
				<table class="table table-striped table-hover">
					<tr>
						<th>名称</th>
						<th>培训内容</th>
					</tr>
					<tr>
						<td>培训号</td>
						<td><input type="text" name="tid" value="" /></td>
					</tr>
				</table>
				<input type="hidden" name="pid" value="${empid}" /> <input
					type="hidden" name="type" value="add" /> <input type="submit"
					value="确认" />
			</form>
		</center>
		<!--footer starts here-->
		<iframe name="content_frame" width="100%" marginwidth="0"
			marginheight="0" frameborder="0" scrolling="NO" src="./footer.html"></iframe>
	</div>
</body>
</html>
