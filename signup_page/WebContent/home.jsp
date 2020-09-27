<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1>Home Page</h1>
	<%String name=request.getParameter("uname"); %> 
	<%out.print("<h2>welcome "+name+"</h2>"); %> 
	<a href="change.html">Change Password</a>
</center>
</body>
</html>