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
	<h1 class="login">ユーザ削除確認</h1>


		<div class="login">
	ログインID:id0001を本当に削除してよろしいですか <br>

    <button onclick="history.back()">キャンセル</button>
	<button onclick="history.back()">  ok   </button>
	</div>
	</body>
</html>