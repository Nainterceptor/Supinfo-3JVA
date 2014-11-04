<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<%@ include file="/header.jsp" %>
	<form method="post" action="login">
		<label for="username">Username : </label>
		<input id="username" name="username" /><br />
		<input type="submit" />
	</form>
	<%@ include file="/footer.jsp" %>
</body>
</html>