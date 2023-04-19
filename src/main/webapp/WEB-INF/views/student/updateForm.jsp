<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>student form</title>
</head>
<body>
<h1>Update Student Data</h1>


  <form action="updateStudent/${requestScope.id}" method="post">  
Name: <input type="text" name="name" /><br/>  <br/>    
<input type="submit" value="Update"/>  
</form>  

</body>
</html>