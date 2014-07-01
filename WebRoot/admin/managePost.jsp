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

<title>岗位信息界面</title>

</head>
<%
	PostInformationDao pid = new PostInformationDao();
	PostInformation[] pis = pid.getAllPost();
	pageContext.setAttribute("pis", pis);
	String type = request.getParameter("type");
	String changeid = "";
	if (type == null || type.length() == 0) {
		type = "normal";
	} else {
		changeid = request.getParameter("id");
		changeid = new String(changeid.getBytes("iso-8859-1"), "UTF-8");
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
				<font face="微软雅黑">管理岗位</font>
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
					<th>岗位信息</th>
				</tr>
				<tr>
					<th>岗位名</th>
					<th>岗位薪水</th>
					<th>描述</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${pis}" var="pi">
					<c:if test="${type==normal}">
						<tr>
							<td>${pi.postName}</td>
							<td>${pi.postSalary}</td>
							<td>${pi.detail}</td>
							<td><a
								href="admin/ManageBasePost?type=del&id=${pi.postName}">删除</a> <a
								href="admin/managePost.jsp?type=change&id=${pi.postName}">修改</a>
						</tr>
					</c:if>
					<c:if test="${type==change}">
						<c:if test="${id!=pi.postName}">
							<tr>
								<td>${pi.postName}</td>
								<td>${pi.postSalary}</td>
								<td>${pi.detail}</td>
								<td><a
									href="admin/ManageBasePost?type=del&id=${pi.postName}">删除</a> <a
									href="admin/managePost.jsp?type=change&id=${pi.postName}">修改</a>
							</tr>
						</c:if>
						<c:if test="${id==pi.postName}">
							<form name="form1" action="admin/ManageBasePost" method="post">
								<tr>
									<td><input type="text" value="${pi.postName}"
										name="postName"></td>
									<td><input type="text" value="${pi.postSalary}"
										name="postSalary"></td>
									<td><input type="text" value="${pi.detail}" name="detail">
									</td>
									<td><a href="javascript:form1.submit();">确定</a> <input
										type="hidden" name="id" value="${pi.postName}" /> <input
										type="hidden" name="type" value="change" /></td>
								</tr>
							</form>
						</c:if>
					</c:if>
				</c:forEach>
			</table>

			<form action="admin/ManageBasePost?type=add" method="post">
				<table class="table table-striped table-hover">
					<tr>
						<th>添加岗位</th>
					</tr>
					<tr>
						<th>名称</th>
						<th>内容</th>
					</tr>
					<tr>
						<td>岗位名</td>
						<td><input type="text" name="postname" value="" /></td>
					</tr>
					<tr>
						<td>岗位薪水</td>
						<td><input type="text" name="postsalary" value="" /></td>
					</tr>
					<tr>
						<td>描述</td>
						<td><textarea name="detail" cols="18" rows="6"
								value="对于这个岗位的描述"></textarea></td>
					</tr>
					<tr>
						<td><input class="btn btn-primary" type="submit" value="确定"></td>
					</tr>
				</table>
			</form>
		</center>
		<!--footer starts here-->
		<iframe name="content_frame" width="100%" marginwidth="0"
			marginheight="0" frameborder="0" scrolling="NO" src="./footer.html"></iframe>
	</div>
</body>
</html>
