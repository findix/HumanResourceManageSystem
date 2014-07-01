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

<title>查询界面</title>

</head>
<%
	DepartmentInformationDao dpdao = new DepartmentInformationDao();
	DepartmentInformation[] dps = dpdao.getAllDepartMentInformation();
	pageContext.setAttribute("dps", dps);
	PostInformationDao pdao = new PostInformationDao();
	PostInformation[] poss = pdao.getAllPost();
	pageContext.setAttribute("poss", poss);
%>
<body>
	<div class="container">
		<div class="jumbotron">
			<h2>
				<font face="微软雅黑">人力资源管理系统</font>
			</h2>
			<h3>
				<font face="微软雅黑">查询员工</font>
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
			<form action="admin/queryResult.jsp" method="post">
				<div id="normalSearch">
					<h5>职工ID</h5>
					<input type="text" id="text" name="empid" value="" />
				</div>

				<div id="highSearch">
					<h5>职工名</h5>
					<input type="text" id="text" name="empname" value="" />
					<h5>部门名</h5>
					<select name="department" id="depart">
						<option value="">任意</option>
						<c:forEach items="${dps}" var="dp">
							<option value="${dp.departmentName}">
								${dp.departmentName}</option>
						</c:forEach>
					</select>
					<h5>岗位名</h5>
					<select name="postname" id="post">
						<option value="">任意</option>
						<c:forEach items="${poss}" var="pos">
							<option value="${pos.postName}">${pos.postName}</option>
						</c:forEach>
					</select>
					<h5>薪水区间</h5>
					<input type="text" id="userName" name="salarystart" value="0" /> -
					<input type="text" id="userName" name="salaryend" value="0" />
					<h5>学历</h5>
					<select name="edubg" id="post">
						<option value="">任意</option>
						<option value="小学">小学</option>
						<option value="初中">初中</option>
						<option value="中专">中专</option>
						<option value="高中">高中</option>
						<option value="大专">大专</option>
						<option value="本科">本科</option>
						<option value="研究生">研究生</option>
						<option value="博士生">博士生</option>
					</select>
				</div>
				<input type="submit" value="确认" />
			</form>
		</center>
		<iframe name="content_frame" width="100%" marginwidth="0"
			marginheight="0" frameborder="0" scrolling="NO" src="./footer.html"></iframe>
	</div>
</body>
</html>
