<%@ page language="java" import="java.util.*,dao.*,pojo.*"
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
<title>部门信息模板</title>
</head>
<%
	DepartmentInformationDao dpdao = new DepartmentInformationDao();
	DepartmentInformation[] dps = dpdao.getAllDepartMentInformation();
	pageContext.setAttribute("dps", dps);
	String type = request.getParameter("type");
	String changeid;
	if (type == null || type.length() == 0)
		type = "normal";
	else {
		changeid = request.getParameter("id");
		pageContext.setAttribute("id", changeid);
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
				<font face="微软雅黑">管理部门</font>
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
					<th>部门信息</th>
				</tr>
				<tr>
					<th>部门号</th>
					<th>部门名</th>
					<c:if test="${type!=change}">
						<th>部门人数</th>
					</c:if>
					<th>地址</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${dps}" var="dp">
					<c:if test="${type==normal}">
						<tr>
							<td><a
								href="admin/manageADepartment.jsp?departId=${dp.departmentID}">${dp.departmentID}</a></td>
							<td>${dp.departmentName}</td>
							<td><%=new StatisticsDao()
							.getDepartmentNum(((DepartmentInformation) pageContext
									.getAttribute("dp")).getDepartmentID())%></td>
							<td>${dp.officeAddress }</td>
							<td><a
								href="admin/ManageDepartment?type=del&id=${dp.departmentID}">删除</a>
								<a
								href="admin/manageDepartments.jsp?type=change&id=${dp.departmentID}">修改</a>
							</td>
						</tr>
					</c:if>
					<c:if test="${type==change}">
						<c:if test="${id==dp.departmentID}">
							<form action="admin/ManageDepartment" method="post">
								<tr>
									<td><input type="text" name="departID"
										value="${dp.departmentID}" /></td>
									<td><input type="text" name="departName"
										value="${dp.departmentName}" /></td>
									<td><input type="text" name="officeAddress"
										value="${dp.officeAddress }" /></td>
									<td><input type="submit" value="确认" /></td>
								</tr>
								<input type="hidden" name="id" value="${dp.departmentID}" /> <input
									type="hidden" name="type" value="change" />
							</form>
						</c:if>
					</c:if>
				</c:forEach>

			</table>
			<form action="admin/ManageDepartment?type=add" method="post">
				<table class="table table-striped table-hover">
					<tr>
						<th>添加部门</th>
					</tr>
					<tr>
						<th>名称</th>
						<th>内容</th>
					</tr>
					<tr>
						<td>部门号</td>
						<td><input type="text" name="departID" value="" /></td>
					</tr>
					<tr>
						<td>部门名称</td>
						<td><input type="text" name="departName" value="" /></td>
					</tr>
					<tr>
						<td>办公室地址</td>
						<td><input type="text" name="address" value="" /></td>
					</tr>
				</table>
				<input type="hidden" name="type" value="add" />
				<input class ="btn btn-primary" 
					type="submit" value="确认" />
			</form>
		</center>
		<!--footer starts here-->
		<iframe name="content_frame" width="100%" marginwidth="0"
			marginheight="0" frameborder="0" scrolling="NO" src="./footer.html"></iframe>
	</div>
</body>
</html>
