<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"><title>Book Shop</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>


</head>
<body>
               <h1>Welcome to the Book Shop</h1>
               
               <form action="Login" method="post">
               <pre>
               
         Username:       <input type="text" name="uname" placeholder="User-Id or Email" required>
              
         Password:       <input type="password" name="pass" placeholder="Password" required><br>
                         <input type="Submit" value="Login">
               </pre>
               
               </form>
               <form action="New.jsp">
               <pre>
         New User:       <input type="submit" value="New User">
              </pre>
               </form>
               <a href="adminhome.jsp" >Click here for Admin Login</a>
</body>
</html>