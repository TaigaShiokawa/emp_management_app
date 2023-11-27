<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, java.util.ArrayList, model.dto.EmployeeDTO, model.map.DepartmentMap, model.map.PostMap"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./home/css/home.css">
</head>
<body>

	<header>
	<h1>マイページ</h1>
	</header>
	
	<div class="mypage">
	<% EmployeeDTO emp = (EmployeeDTO)request.getAttribute("my"); %>
	<h3><%=emp.getName()%> : <%=DepartmentMap.getDepartment(emp.getDepartment())%> : <%=PostMap.getpost(emp.getPost())%></h3>
	</div>
	<hr>
	
	<section>
	<h2>ログアウト</h2>
	<a href="<%=request.getContextPath()%>/logout-servlet">ログアウト</a>
	</section>
</body>
</html>