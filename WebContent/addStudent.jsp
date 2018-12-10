<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
<link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
<link href="style.css" rel="stylesheet">
</head>
<body><div class="hero-image"><div class="hero-text">
<form action = "Add_Student_Servlet" method="post">

Name: <input type = "text" name = "name">
Date of Birth:<input type ="text" name="dob">

<input type = "submit" value="Add Student" class="button button1">
</form>
<a href ="index.html"> Back to start</a><br />
<a href = "viewAllStudentsServlet">View complete student list</a>
</div></div>
</body>
</html>