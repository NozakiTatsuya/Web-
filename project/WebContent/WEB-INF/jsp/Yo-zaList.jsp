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
		<span>ユーザ名</span> <a href="/cgi-bin/Logout">ログアウト</a>
	</div>
<body>
	<h1 class="login">ユーザ一覧</h1>
	<div class="right">
		<a onclick="history.back()" href="#">新規登録</a><br>
	</div>
	<div class="login">
		ログインID <input class="input" type="password" name="name"><br>
		ユーザ名 <input class="input" type="text" name="name"><br>
		生年月日 <input type="date" id="start" name="trip-start" min="2019-01-01"
			max="2019-12-31"> <span>〜 <input type="date"
			id="start" name="trip-start" min="2019-01-01" max="2019-12-31">
		</span>
	</div>
	<br>
	<div class="right">
		<button onclick="history.back()">検索</button>
	</div>
	<br>
	<br>
	<table border="1">
		<thead>

			<tr>
				<th>ログインID</th>
				<th>ユーザ名</th>
				<th>生年月日</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>id0001</td>
				<td>田中太郎</td>
				<td>1989年04月26日</td>
				<td>
					<button onclick="history.back()">詳細</button>
					<button onclick="history.back()">更新</button>
					<button onclick="history.back()">消去</button>
				</td>
			</tr>
			<tr>
				<td>id0002</td>
				<td>佐藤二朗</td>
				<td>2001年11月12日</td>
				<td>
					<button onclick="history.back()">詳細</button>
					<button onclick="history.back()">更新</button>
					<button onclick="history.back()">消去</button>
				</td>
			</tr>
			<tr>
				<td>id0003</td>
				<td>佐川真司</td>
				<td>2000年01月01日</td>
				<td>
					<button onclick="history.back()">詳細</button>
					<button onclick="history.back()">更新</button>
					<button onclick="history.back()">消去</button>
				</td>
			</tr>
		</tbody>

	</table>

</body>
</html>