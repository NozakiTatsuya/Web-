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
	<h1 class="login">ユーザ情報参照</h1>

	<div class="login">
	ログインID id0001<br>
	ユーザー名 田中太郎<br>
	生年月日 1989年04月26日<br>
	登録日 2017年01月01日 10:50<br>
	更新日 2017年02月01日 01:05<br>
	<br>
	<input type="submit"value="登録">
	<a onclick="history.back()" href="#">戻る</a>

	</div>
	</body>
</html>