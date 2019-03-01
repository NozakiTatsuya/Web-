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
	<body>
	<h1 class="login">ユーザ情報参照</h1>
	<div class="login">
	ログインID ${user.loginId}<br>
	ユーザー名 ${user.name}<br>
	生年月日${user.birthDate}<br>
	登録日 ${user.createDate}<br>
	更新日 ${user.updateDate}<br>
	<br>

	</div>

	<a onclick="history.back()" href="UserListServlet">戻る</a>

	</body>
</html>