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
<script language="javascript">
	$(document).ready(
			function() {
				var yearFrom = new Date().getYear() - 60 + 1900;
				var yearTo = new Date().getYear() - 18 + 1900;
				$('#dateinput').datepicker(
						{
							dateFormat : 'yy-mm-dd',
							yearRange : yearFrom + ':' + yearTo,
							clearText : '清除',
							closeText : '关闭',
							prevText : '前一月',
							nextText : '后一月',
							currentText : ' ',
							monthNames : [ '1月', '2月', '3月', '4月', '5月', '6月',
									'7月', '8月', '9月', '10月', '11月', '12月' ]
						});
			});
</script>
<title>培训信息界面</title>

</head>
<%
	TrainInformationDao tid = new TrainInformationDao();
	TrainInformation[] tis = tid.getAllTrainInformation();
	String type = request.getParameter("type");
	String changeid = "";
	if (type == null || type.length() == 0) {
		type = "normal";
	} else {
		changeid = request.getParameter("id");
	}
	pageContext.setAttribute("id", changeid);
	pageContext.setAttribute("type", type);
	pageContext.setAttribute("tis", tis);
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
					<th>培训信息表</th>
				</tr>
				<tr>
					<th>培训号</th>
					<th>培训开始时间</th>
					<th>培训结束时间</th>
					<th>培训内容</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${tis}" var="ti">
					<c:if test="${type==normal}">
						<tr>
							<td>${ti.trainID}</td>
							<td>${ti.startTime }</td>
							<td>${ti.endTime }</td>
							<td>${ti.content }</td>
							<td><a href="admin/ManageTrain?type=del&id=${ti.trainID}">删除</a>
								<a href="admin/manageTrain.jsp?type=change&id=${ti.trainID}">修改</a>
							</td>
						</tr>
					</c:if>
					<c:if test="${type==change}">
						<c:if test="${id!=ti.trainID}">
							<tr>
								<td>${ti.trainID}</td>
								<td>${ti.startTime }</td>
								<td>${ti.endTime }</td>
								<td>${ti.content }</td>
								<td><a href="admin/ManageTrain?type=del&id=${ti.trainID}">删除</a>
									<a href="admin/manageTrain.jsp?type=change&id=${ti.trainID}">修改</a>
								</td>
							</tr>
						</c:if>
						<c:if test="${id==ti.trainID}">
							<form name="form1" action="admin/ManageTrain?type=change"
								method="post">
								<tr>
									<td><input type="text" name="trainID"
										value="${ti.trainID}" /></td>
									<td><input type="text" name="startTime"
										value="${ti.startTime}" /></td>
									<td><input type="text" id="datepicker" name="endTime"
										value="${ti.endTime}" /></td>
									<td><input type="text" id="datepicker" name="content"
										value="${ti.content}" /></td>
									<td><a href="javascript:form1.submit();">确定</a></td>
								</tr>
							</form>
						</c:if>
					</c:if>
				</c:forEach>
			</table>
			<form action="admin/ManageTrain?type=add" method="post">
				<table class="table table-striped table-hover">
					<tr>
						<th>添加培训</th>
					</tr>
					<tr>
						<th>名称</th>
						<th>内容</th>
					</tr>
					<tr>
						<td>培训号</td>
						<td><input type="text" name="trainID" value="" /></td>
					</tr>
					<tr>
						<td>培训开始时间</td>
						<td><input id="dateinput" type="text" name="startTime"
							value="" /></td>
					</tr>
					<tr>
						<td>培训结束时间</td>
						<td><input id="dateinput" type="text" name="overTime"
							value="" /></td>
					</tr>
					<tr>
						<td>培训内容</td>
						<td><input type="text" name="content" value="" /></td>
					</tr>
				</table>
				<input type="submit" value="确认" />
			</form>
		</center>
		<!--footer starts here-->
		<iframe name="content_frame" width="100%" marginwidth="0"
			marginheight="0" frameborder="0" scrolling="NO" src="./footer.html"></iframe>
	</div>
</body>
</html>
