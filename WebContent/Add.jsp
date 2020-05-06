<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>



<form action="Add" method="post" enctype="multipart/form-data">
<h1>Fill following details to add a book</h1><br><br><br>
<pre>
 Book Name        :   <input type="text" name="name">
 Book Price       :   <input type="number" name="price">
 Book Author      :   <input type="text" name="author" >
 Book Image       :   <input type="file" name="img">
 Book Description :  
                      <textarea rows="4" cols="50" name="description"></textarea>
 
                      <input type="submit" value="Save book">
</pre>

 </form>
    <form action="Logout">
   <input type="submit" value="Logout">
   </form>

</body>
</html>