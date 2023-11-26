<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, java.util.ArrayList, model.dto.EmployeeDTO, model.map.DepartmentMap, model.map.PostMap"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<header>
	<h1>マイページ</h1>
	<hr>
	</header>
	
	<% EmployeeDTO emp = (EmployeeDTO)request.getAttribute("my"); %>
	<h3><%=emp.getName()%> : <%=DepartmentMap.getDepartment(emp.getDepartment())%> : <%=PostMap.getpost(emp.getPost())%></h3>
	<hr>
	
	<section>
	<h2>ログアウト</h2>
	<a href="<%=request.getContextPath()%>/logout-servlet">ログアウト</a>
	</section>
</body>
</html>