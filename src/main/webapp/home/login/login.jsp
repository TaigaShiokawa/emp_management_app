<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/home.css">
</head>
<body>

	<header>
		<h1>人事情報管理アプリ</h1>
	</header>
	
	<section class="emp-list">
	<h2>ログイン</h2>
	</section>
	<% String loginError = (String)session.getAttribute("loginError"); %>
	<% if(loginError != null) { %>
	<p><%=loginError %></p>
	<% session.removeAttribute("loginError"); %>
	<% } %>
	<form action="<%=request.getContextPath()%>/login-servlet" method="post">
	<label for="name">
	名前：<input type="text" name="name" id="name" placeholder="山田　太郎" required><br>
	</label>
	<label for="password">
	パスワード：<input type="password" name="password" id="password" placeholder="パスワード"><br>
	</label>
	役職：
		<select name="post">
		<option value="1">一般社員</option>
		<option value="2">主任</option>
		<option value="3">係長</option> 
		<option value="4">課長</option> 
		</select><br>
	
	<button type="post">ログイン</button>
	</form>
	
	<section>
		<h2>登録がまだな方はこちら</h1>
		<a href="<%=request.getContextPath()%>/register-servlet">新規登録</a>
	</section>
</body>
</html>