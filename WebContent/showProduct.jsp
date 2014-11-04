<%@page import="com.supinfo.sun.supcommerce.doa.SupProductDao"%>
<%@page import="com.supinfo.sun.supcommerce.bo.SupProduct"%>
<%@page import="com.supinfo.sun.supcommerce.exception.UnknownProductException" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product details</title>
</head>
<body>
<%@ include file="/header.jsp" %>
<% try {
	long id = Long.parseLong(request.getParameter("id"));
	SupProduct product = SupProductDao.findProductById(id); %>
	<h1><%= product.getName() %></h1>

	<p><%= product.getContent() %> <br />
	<%= product.getPrice() %></p>
	<%
} catch(UnknownProductException e) { %>
	Product not found
	<%
} catch(NumberFormatException e) { %>
	Format number exception
	<%
} %>
<%@ include file="/footer.jsp" %>
</body>
</html>