<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<%
String name=(String)session.getAttribute("name");
String price=(String)session.getAttribute("price");
int bookid=(Integer)session.getAttribute("bookid");

String u="ImageLoader?bid=" +bookid;
%>

<title>Cart</title>
</head>
<body>
<h2>Final Checkout page</h2><br><hr>


<pre>
Book Name :  <%=name %>
Book Price:  <%=price%>
<img width=100 height=120   src=<%=u%>>
</pre>
<form action="done.jsp">
             <input type="submit" value="Buy Now"><br>
            
</form>
<br>
<a href="Buyer">Back to all books</a>

<form action="Logout"><br>
            <input type="submit" value="Logout"><br><br><br>
   
   </form>
   <%
   
   %>


</body>
</html>