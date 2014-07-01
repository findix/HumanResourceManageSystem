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

<title>添加员工界面</title>

</head>

<%
	String type = request.getParameter("type");
	if (type == null || type.length() == 0)
		type = "normal";
	pageContext.setAttribute("type", type);
	pageContext.setAttribute("change", "change");
	pageContext.setAttribute("normal", "normal");
	pageContext.setAttribute("add", "add");
%>

<body>
	<div class="container">
		<div class="jumbotron">
			<h2>
				<font face="微软雅黑">人力资源管理系统</font>
			</h2>
			<h3>
				<font face="微软雅黑">添加员工界面</font>
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
			<h3>添加或修改一名员工信息</h3>
			<c:if test="${type=='add'}">
				<form action="admin/ManagePerson?type=add" method="post">
					<table class="table table-striped table-hover">
						<tr>
							<th>名称</th>
							<th>内容</th>
						</tr>
						<tr>
							<td>职工号</td>
							<td><input type="text" name="empid" value=""></td>
						</tr>
						<tr>
							<td>职工姓名</td>
							<td><input type="text" name="empname" value=""></td>
						</tr>
						<tr>
							<td>性别</td>
							<td><SELECT name="sex">
									<OPTION value="男">男</OPTION>
									<OPTION value="女">女</OPTION>
							</SELECT></td>
						</tr>
						<tr>
							<td>出生年月</td>
							<td><input type="text" name="birth" value=""></td>
						</tr>
						<tr>
							<td>籍贯</td>
							<td><input type="text" name="naplace" value=""></td>
						</tr>
						<tr>
							<td>学历</td>
							<td><SELECT name="edubg">
									<OPTION value="小学">小学</OPTION>
									<OPTION value="初中">初中</OPTION>
									<OPTION value="中专">中专</OPTION>
									<OPTION value="高中">高中</OPTION>
									<OPTION value="本科">本科</OPTION>
									<OPTION value="研究生">研究生</OPTION>
									<OPTION value="博士生">博士生</OPTION>
							</SELECT></td>
						</tr>
						<tr>
							<td>参加工作时间</td>
							<td><input type="text" name="joworktime" value=""></td>
						</tr>
						<tr>
							<td>加入公司时间</td>
							<td><input type="text" name="jocomptime" value=""></td>
						</tr>
						<tr>
							<td>政治面貌</td>
							<td><SELECT name="polistatus">
									<OPTION value="群众">群众</OPTION>
									<OPTION value="团员">团员</OPTION>
									<OPTION value="党员">党员</OPTION>
							</SELECT></td>
						</tr>
						<tr>
							<td>基本工资</td>
							<td><input type="text" name="basicwage" value=""></td>
						</tr>
						<tr>
							<td><input class="btn btn-primary" type="submit" value="确定"></td>
						</tr>
					</table>
				</form>
			</c:if>
			<c:if test="${type=='change'}">
				<%
					String empid = request.getParameter("id");
						PersonDao pd = new PersonDao();
						Person p = pd.searchPersonBasicInformation(empid);
						pageContext.setAttribute("p", p);
				%>
				<form action="admin/ManagePerson?type=change" method="post">
					<table class="table table-striped table-hover">
						<tr>
							<th>名称</th>
							<th>内容</th>
						</tr>
						<tr>
							<td>职工号</td>
							<td><input type="text" name="empid" value="${p.empid} "></td>
						</tr>
						<tr>
							<td>职工姓名</td>
							<td><input type="text" name="empname" value="${p.empname }"></td>
						</tr>
						<tr>
							<td>性别</td>
							<td><SELECT name="sex">
									<OPTION value="男" selected="${p.sex == '男' ? 'selected' : '' }">男</OPTION>
									<OPTION value="女" selected="${p.sex == '女' ? 'selected' : '' }">女</OPTION>
							</SELECT></td>
						</tr>
						<tr>
							<td>出生年月</td>
							<td><input type="text" name="birth" value="${p.birthday }"></td>
						</tr>
						<tr>
							<td>籍贯</td>
							<td><input type="text" name="naplace"
								value="${p.nativePlace }"></td>
						</tr>
						<tr>
							<td>学历</td>
							<td><SELECT name="edubg">
									<OPTION value="小学"
										selected="${p.sex == '小学' ? 'selected' : '' }">小学</OPTION>
									<OPTION value="初中"
										selected="${p.sex == '初中' ? 'selected' : '' }">初中</OPTION>
									<OPTION value="中专"
										selected="${p.sex == '中专' ? 'selected' : '' }">中专</OPTION>
									<OPTION value="高中"
										selected="${p.sex == '高中' ? 'selected' : '' }">高中</OPTION>
									<OPTION value="本科"
										selected="${p.sex == '本科' ? 'selected' : '' }">本科</OPTION>
									<OPTION value="研究生"
										selected="${p.sex == '研究生' ? 'selected' : '' }">研究生</OPTION>
									<OPTION value="博士生"
										selected="${p.sex == '博士生' ? 'selected' : '' }">博士生</OPTION>
							</SELECT></td>
						</tr>
						<tr>
							<td>参加工作时间</td>
							<td><input type="text" name="joworktime"
								value="${p.joinWorkTime }"></td>
						</tr>
						<tr>
							<td>加入公司时间</td>
							<td><input type="text" name="jocomptime"
								value="${p.joinCompanyTime }"></td>
						</tr>
						<tr>
							<td>政治面貌</td>
							<td><SELECT name="polistatus">
									<OPTION value="群众"
										selected="${p.polistatus == '群众' ? 'selected' : '' }">群众</OPTION>
									<OPTION value="团员"
										selected="${p.polistatus == '团员' ? 'selected' : '' }">团员</OPTION>
									<OPTION value="党员"
										selected="${p.polistatus == '党员' ? 'selected' : '' }">党员</OPTION>
							</SELECT></td>
						</tr>
						<tr>
							<td>基本工资</td>
							<td><input type="text" name="basicwage"
								value="${p.basicWage }"></td>
						</tr>
						<tr>
							<td><input class="btn btn-primary" type="submit" value="确定"></td>
						</tr>
					</table>
				</form>
			</c:if>
		</center>
		<!--footer starts here-->
		<iframe name="content_frame" width="100%" marginwidth="0"
			marginheight="0" frameborder="0" scrolling="NO" src="./footer.html"></iframe>
	</div>
</body>
</html>
