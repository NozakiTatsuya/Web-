<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="NewFile.css">
	<title>title</title>
</head>
	<body>

	<div class="header">
		<span >ユーザ名</span>
		<a  href="LogoutServlet">ログアウト</a>
	</div>
	<h1>ユーザ新規登録</h1>

	<c:if test="${errMsg != null}" >
		 <span style="color: #F00;">${errMsg}</span>
	</c:if>
	<form action="UserNewServlet" method="post">

	ログインID<input class="input" type="text" name="loginId"><br>
	パスワード<input class="input" type="password" name="password"><br>
	パスワード(確認)<input class="input" type="password" name="password1"><br>
	ユーザー名<input class="input" type="text" name="username"><br>
	生年月日<input class="input" type="date" name="birthday">
	<br><br><br>


	<input type="submit"value="登録">

	</form>
	<a  href="UserListServlet">戻る</a>
	</body>
</html>