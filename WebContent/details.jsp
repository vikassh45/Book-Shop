
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<%
int bookid=Integer.parseInt(request.getParameter("bid"));
String username="root";
String password="root";
String url="jdbc:mysql://localhost:3306/bookshop";
String sql="select name,price,author,description from book where bookid=?";
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection(url,username,password);
PreparedStatement st=con.prepareStatement(sql);
st.setInt(1, bookid);
ResultSet rs=st.executeQuery();
rs.next();
String name=rs.getString(1);
int price=rs.getInt(2);
String author=rs.getString(3);
String description=rs.getString(4);
String u="ImageLoader?bid=" +bookid;
String b="Cart?bid=" +bookid;
String c="Cart2?bid=" +bookid;

%>

<title>Book Details</title>
</head>
<body>
<a href="Buyer">Back to complete list</a><br>
<form action="Logout">
   <input type="submit" value="Logout"><br><br><br>
   
   </form>
<pre align="center">
<h2>Book Name</h2>       : <%=name %>    
<h2>Book Price</h2>      : <%=price %>
<h2>Book Author</h2>     : <%=author %>
<h2>Book Description</h2>: <textarea rows="7" cols="50" name="description"><%=description %></textarea>
<img width=150 height=225   src=<%=u%>>

</pre>
<form action=<%=b %> align="center" method="post">
<input type="submit" value="Buy Now">
</form>

<form action=<%=c %> align="center" method="post">
<input type="submit" value="Add to Cart"><br>
</form>

</body>
</html>