<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
import="java.util.List, java.util.ArrayList, model.dto.EmployeeDTO, content.Parameters, model.map.DepartmentMap, model.map.PostMap"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./home/css/home.css">
</head>
<body>

	<header>
	<h1>一覧</h1>
	</header>
	
	<% List<EmployeeDTO> empList = (List)request.getAttribute("empList"); %>
	<% for(EmployeeDTO emp : empList) { %>
	<section class="emp-list">
	<h3><%=emp.getName()%> : <%=DepartmentMap.getDepartment(emp.getDepartment())%> : <%=PostMap.getpost(emp.getPost())%></h3>
	<p class="emp-actions">
		<a href="<%=request.getContextPath()%>/delete-servlet?<%=Parameters.EMP_ID%>=<%=emp.getId()%>">削除</a>
		<a href="<%=request.getContextPath()%>/update-servlet?<%=Parameters.EMP_ID%>=<%=emp.getId()%>">更新</a>
	</p>
	<hr>
	</section>
	<% } %>
	
	<section class="list-section">
	<h2>追加はこちらから</h2>
	<a href="<%=request.getContextPath()%>/emp-add-servlet">追加</a>
	<h2>マイページ</h2>
	<a href="<%=request.getContextPath()%>/top-post-mypage-servlet">マイページへ</a>
	<h2>ログアウト</h2>
	<a href="<%=request.getContextPath()%>/logout-servlet">ログアウト</a>
	</section>

</body>
</html>