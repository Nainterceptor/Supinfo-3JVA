<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Category</title>
</head>
<body>
<%@ include file="/header.jsp" %>
	<h1>New Category</h1>

	<form action="<%= application.getContextPath() %>/auth/addCategory" method="POST">
	<label for="name">Name : </label>
	<input type="text" id="name" name="name" /><br />
	<input type="submit" />
	</form>
<%@ include file="/footer.jsp" %>
</body>
</html>