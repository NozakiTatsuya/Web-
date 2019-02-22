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
	<h1>ユーザ削除確認</h1>


	<form action="UserDeleteServlet" method="post">
		ログインID:id0001を本当に削除してよろしいですか <br>

		<input type="submit"value="OK">

		<a href="UserListServlet">キャンセル</a>

	</form>

</body>
</html>