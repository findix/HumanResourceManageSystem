<%@ page language="java" import="java.util.*,dao.*,viewPojo.*,pojo.*"
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

<title>部门岗位需求信息</title>

</head>
<%
	String dpID = request.getParameter("departId");
	String postName = request.getParameter("postName");
	pageContext.setAttribute("postName", postName);
	DepartmentInformationDao did = new DepartmentInformationDao();
	DepartmentInformation di = did.getDepartMentInformation(dpID);
	pageContext.setAttribute("di", di);
%>
<body>
	<div class="container">
		<div class="jumbotron">
			<h2>
				<font face="微软雅黑">人力资源管理系统</font>
			</h2>
			<h3>
				<font face="微软雅黑">管理部门岗位需求</font>
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
			<h3>部门基本信息</h3>
			<table class="table table-striped table-hover">
				<tr>
					<th>部门号</th>
					<th>部门名</th>
					<th>部门办公室</th>
					<th>部门总人数</th>
				</tr>
				<tr>
					<td>${di.departmentID }</td>
					<td>${di.departmentName }</td>
					<td>${di.officeAddress }</td>
					<td><%=new StatisticsDao().getDepartmentNum(dpID)%></td>
				</tr>
			</table>
			<%
				String type = request.getParameter("type");
				if (type == null || type.length() == 0) {
					type = "normal";
				}
				pageContext.setAttribute("type", type);
				pageContext.setAttribute("change", "change");
				pageContext.setAttribute("del", "del");
				pageContext.setAttribute("normal", "normal");
				DepartmentPostRequmentDao dprd = new DepartmentPostRequmentDao();
				DepartmentPostInformation[] dpis = dprd
						.getADepartmentAllWorkRequirement(dpID);
				pageContext.setAttribute("dpis", dpis);
			%>
			<h3>部门岗位信息</h3>
			<table class="table table-striped table-hover">
				<tr>
					<th>岗位名</th>
					<th>岗位应需人数</th>
					<th>岗位实际人数</th>
					<th>岗位薪水</th>
					<th>岗位信息</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${dpis}" var="dpi">
					<tr>
						<td>${dpi.postName }</td>
						<c:if test="${type==normal}">
							<td>${dpi.needPerson}</td>
						</c:if>
						<c:if test="${type==change}">
							<c:if test="${postName==dpi.postName}">
								<td>
									<form name="changeform" method="post"
										action="admin/ManageADepartmentPost">
										<input type="hidden" name="dpID" value="${di.departmentID}" />
										<input type="hidden" name="postName" value="${dpi.postName}" />
										<input type="hidden" name="type" value="change" /> <input
											type="text" name="actualNum" value="${dpi.needPerson }" />
									</form>
								</td>
							</c:if>
							<c:if test="${postName!=dpi.postName}">
								<td>${dpi.needPerson}</td>
							</c:if>
						</c:if>
						<td>${dpi.actualPerson}</td>
						<td>${dpi.postSalary }</td>
						<td>${dpi.postDetial }</td>
						<td>
							<form name="delform" method="post"
								action="admin/ManageADepartmentPost">
								<input type="hidden" name="departId" value="${di.departmentID}" />
								<input type="hidden" name="postName" value="${dpi.postName}" />
								<input type="hidden" name="type" value="del" />
							</form>
							<form name="changeaction" method="post"
								action="admin/manageADepartment.jsp">
								<input type="hidden" name="departId" value="${di.departmentID}" />
								<input type="hidden" name="postName" value="${dpi.postName}" />
								<input type="hidden" name="type" value="change" />
							</form> <c:if test="${type==change}">
								<a href="javascript:changeform.submit();">确认</a>
							</c:if> <c:if test="${type!=change}">
								<a href="javascript:changeaction.submit();">修改</a>
								<a href="javascript:delform.submit();">删除</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>

			<h3>添加岗位需求</h3>
			<form action="admin/ManageADepartmentPost?type=add" method="post">
				<input type="hidden" name="dpID" value="${di.departmentID}">
				<table class="table table-striped table-hover">
					<tr>
						<th>岗位名</th>
						<th>岗位应需人数</th>
					</tr>
					<tr>
						<td>
							<%
								PostInformationDao pid = new PostInformationDao();
								PostInformation[] pis = pid.getAllPost();
								pageContext.setAttribute("pis", pis);
							%> <select name="postName" id="post">
								<c:forEach items="${pis}" var="pos">
									<option value="${pos.postName}">${pos.postName}</option>
								</c:forEach>
						</select>
						</td>
						<td><input type="text" name="reqNum" value="0" /></td>
					</tr>

				</table>
				<input type="hidden" name="type" value="add" /> <input
					type="submit" value="确认" />
			</form>
		</center>
		<!--footer starts here-->
		<iframe name="content_frame" width="100%" marginwidth="0"
			marginheight="0" frameborder="0" scrolling="NO" src="./footer.html"></iframe>
	</div>
</body>
</html>
