<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
</head>
<body>
<form action="New" method="post">
<pre>
First Name:         <input type="text" name="fname" placeholder="Tom" required><br>
Last Name:          <input type="text" name="lname" placeholder="Cruise" required><br>
User-name:          <input type="text" name="uname" placeholder="tom55" required><br>
Password:           <input type="password" placeholder="Password" id="password" name="pass" required><br>
Confirm Password:   <input type="password" placeholder="Confirm Password" id="confirm_password" name="repass" required><br>
Email:              <input type="email" name="mail" placeholder="John@gmail.com" required> <br>
                    <button type="submit" class="pure-button pure-button-primary">Add User</button>
   
   
</pre>
</form>

<script>

var password = document.getElementById("password")
, confirm_password = document.getElementById("confirm_password");

function validatePassword(){
if(password.value != confirm_password.value) {
  confirm_password.setCustomValidity("Passwords Don't Match");
} else {
  confirm_password.setCustomValidity('');
}
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;
</script>
</body>
</html>