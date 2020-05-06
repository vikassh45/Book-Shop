<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
   
   <% 
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
response.setHeader("Expires","0");
if(session.getAttribute("username")==null)
{
   	response.sendRedirect("login.jsp");
}
            String s=(String)session.getAttribute("username");
%>

<h1>All the details are available here Dear <%= s %></h1>
   <h3></h3>
   <a href="Welcome" >Click here for total number of Books</a><br>
   <a href="Show2">Click here for details of Books</a><br>
   <a href="Add.jsp">Click here to add a Book</a><br>
   <a href="User">Click here for details of user</a><br>
   
   <form action="Logout">
   <input type="submit" value="Logout"><br><br><br>
   
   </form>
   

</body>
</html>