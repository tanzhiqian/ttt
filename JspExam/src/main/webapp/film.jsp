<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"%>
    <%@page import="com.hand.dao.impl.*"%>
    <%@page import="com.hand.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>删除操作</title>
</head>
<body>
	<%
		FilmDaoImpl fd=new FilmDaoImpl();
		ArrayList a = fd.selectallFilm();
	%>
	<table border="1">
		<tr>
			<td>film_id</td>
			<td>title</td>
			<td>description</td>
			<td>language</td>
			<td></td>
		</tr>
		<%
			for(int i = 0;i<a.size();i++) {
		%>
		<tr>
			<td>
				<%
					Film f = (Film)a.get(i);
					out.print(f.getFilm_id());
				%>
			</td>
			<td>
				<%
					out.print(f.getTitle());
				%>
			</td>
			<td>
				<%
					out.print(f.getDescription());
				%>
			</td>
			<td>
				<%
					out.print(f.getName());
				%>
			</td>
			<td><a href="">删除</a></td>
		</tr>

		<%
			}
			
		%>
	
</body>
</html>