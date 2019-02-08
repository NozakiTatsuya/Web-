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
		<a  href="/cgi-bin/Logout">ログアウト</a>
	</div>
	<body>
	<h1 class="login">ログイン画面</h1>

	<div class="login">
	ログインID<input class="input" type="text" name="loginid"><br>
	パスワード<input class="input" type="password" name="password">

	<br>

	<input type="submit"value="ログイン">
	</div>
	</body>
</html>