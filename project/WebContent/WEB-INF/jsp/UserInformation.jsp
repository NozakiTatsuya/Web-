<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<span>ユーザ名</span> <a href="LogoutServlet">ログアウト</a>
	</div>
<body>
	<h1>ユーザ情報更新</h1>
	 <font color="red">${errMsg} </font><br>

	<form action="UserInformationServlet" method="post">

		ID<input type="hidden" name="Id" value="${user.loginId}">${user.loginId}${loginId}<br>
		パスワード<input class="input"type="password" name="password" > <br>
		パスワード（確認） <input class="input" type="password" name="password1"> <br>
		ユーザ名<input class="input" type="text" name="name" value="${user.name}${name}"> <br>
		生年月日<input class="input" type="date" name="birth_date" value="${user.birthDate}${birth_date}"> <br>


		<input type="submit" value="更新">

	</form>

	<a href="UserListServlet">戻る</a>


</body>
</html>