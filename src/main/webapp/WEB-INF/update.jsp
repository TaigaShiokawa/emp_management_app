<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.dto.EmployeeDTO, content.Parameters, model.map.DepartmentMap, model.map.PostMap"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<% EmployeeDTO emp = (EmployeeDTO)request.getAttribute("emp"); %>
<body>

	<header>
		<h1>更新</h1>
	</header>
	
	<form action="<%=request.getContextPath()%>/update-servlet" method="post">
	<label for="name">
	名前：<input type="text" name="name" id="name" value="<%=emp.getName()%>" required><br>
	</label>
	所属：
		<select name="department">
		<option value="0"><%=DepartmentMap.getDepartment(emp.getDepartment())%></option> 
		<option value="1">企画課</option>
		<option value="2">情報システム課</option>
		<option value="3">財務課</option> 
		</select>
	役職：
		<select name="post">
		<option value="0"><%=PostMap.getpost(emp.getPost())%></option>
		<option value="3">係長</option> 
		<option value="4">課長</option> 
		</select><br>
	
	<input type="hidden" name="<%=Parameters.EMP_ID%>" value="<%=emp.getId()%>">
	<button type="submit">更新</button>
	</form>
	
	</section>
	<h2>一覧へ戻る</h2>
	<a href="<%=request.getContextPath()%>/emp-list-servlet">一覧へ</a>
	</section>
</body>
</html>