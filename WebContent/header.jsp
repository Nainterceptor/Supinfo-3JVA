<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<p>
<a href="<%= application.getContextPath() %>/listProduct.jsp">Product List</a> |

<% if(session.getAttribute("username") != null) { %>
<a href="<%= application.getContextPath() %>/auth/addProduct.jsp">New product</a> |
<a href="<%= application.getContextPath() %>/logout">Logout</a>
<% } else { %>
<a href="<%= application.getContextPath() %>/login.jsp">Login</a>
<% } %>
</p>