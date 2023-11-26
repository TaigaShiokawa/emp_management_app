<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<header>
		<h1>人事情報管理アプリ</h1>
	</header>
	
	<h2>新規登録</h2>
	<% String success = (String)session.getAttribute("success"); %>
	<% String passError = (String)request.getAttribute("passError"); %>
	<% if(success != null) { %>
	<p><%=success %></p>
	<% session.removeAttribute("success"); %>
	<% } else if(passError != null) { %>
	<p><%=passError %></p>
	<% } %>
	<form action="<%=request.getContextPath()%>/register-servlet" method="post">
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
		<option value="1">一般社員</option>
		<option value="2">主任</option>
		<option value="3">係長</option> 
		<option value="4">課長</option> 
		</select><br>
	
	<button type="post">登録</button>
	</form>
	
	<section>
		<h2>ログインはこちら</h1>
		<a href="<%=request.getContextPath()%>/login-servlet">ログイン</a>
	</section>
</body>
</html>