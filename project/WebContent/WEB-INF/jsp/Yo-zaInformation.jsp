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
	<h1 class="login">ユーザ情報更新</h1>

	<div class="login">
	ログインID id0001<br>
	パスワード<input class="input" type="password" name="name"><br>
	パスワード（確認）<input class="input" type="password" name="name"><br>
	ユーザ名<input class="input" type="text" name="name"><br>
	生年月日<input class="input" type="text" name="name">
	<br>
	<button onclick="history.back()">更新</button>
	<a onclick="history.back()" href="#">戻る</a>

	</div>
	</body>
</html>