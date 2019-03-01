<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
</head>

<body>

	<h1 class="login">ログイン画面</h1>

	<c:if test="${errMsg != null}" >
	 <font color="red">${errMsg} </font><br>
	</c:if>
	<form action="loginServlet" method="post">
		<div class="login">
			ログインID<input class="input" type="text" name="loginId"><br>
			パスワード<input class="input" type="password" name="password"> <br>

			<input type="submit" value="ログイン">

		</div>
	</form>
</body>
</html>