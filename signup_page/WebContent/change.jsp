<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String currentPassword=request.getParameter("opwd");
String Newpass=request.getParameter("npwd");
String conpass=request.getParameter("cpwd");
Connection con=null;
String pass="";
String id="";
try{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");  
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from login where password='"+currentPassword+"'");
while(rs.next()){
id=rs.getString(1);
pass=rs.getString(2);
} System.out.println(id+ " "+pass);
if(pass.equals(currentPassword)){
Statement st1=con.createStatement();
int i=st1.executeUpdate("update login set password='"+Newpass+"' where username='"+id+"'");
out.println("Password changed successfully");
st1.close();
con.close();
}
else{
out.println("Invalid Current Password");
}
}
catch(Exception e){
out.println(e);
}
%>
</body>
</html>