<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./home/css/home.css">
</head>
<body>

	<header>
		<h1>追加</h1>
		<p><a href="<%=request.getContextPath()%>/emp-list-servlet">一覧へ</a>
	</header>
	
	<% String add = (String)session.getAttribute("success"); %>
	<% if(add != null) { %>
	<p><%=add %></p>
	<% session.removeAttribute("success"); %>
	<% } %>
	<form action="<%=request.getContextPath()%>/emp-add-servlet" method="post">
	<label for="name">
	名前：<input type="text" name="name" id="name" placeholder="山田　太郎" required><br>
	</label>
	<label for="password">
	パスワード：<input type="password" name="password" id="password" placeholder="8文字以上"><br>
	</label>
	所属：
		<select name="department">
		<option value="1">企画課</option>
		<option value="2">情報システム課</option>
		<option value="3">財務課</option> 
		</select>
	役職：
		<select name="post">
		<option value="3">係長</option> 
		<option value="4">課長</option> 
		</select><br>
	
	<button type="submit">追加</button>
	</form>
	
	<section class="list-section">
	<h2>一覧へ戻る</h2>
	<a href="<%=request.getContextPath()%>/emp-list-servlet">一覧へ</a>
	</section>
	
	
</body>
</html>