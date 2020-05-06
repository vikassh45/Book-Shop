<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<%

String username="root";
String password="root";

String url="jdbc:mysql://localhost:3306/bookshop";
String sql="delete from cart ";
try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection(url,username,password);
	PreparedStatement st= con.prepareStatement(sql);
	st.executeUpdate();
} catch (Exception e) {
e.printStackTrace();
}

%>

<title>Thanks</title>
</head>
<body>
<h1>Thanks for Buying....</h1>
<a href="Buyer">Buy more</a>

<form action="Logout">
   <input type="submit" value="Logout"><br><br><br>
   
   </form>
   
</body>
</html>