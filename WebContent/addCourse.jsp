<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Course</title>
<link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
<link href="style.css" rel="stylesheet">
</head>
<body><div class="hero-image"><div class="hero-text">
<form action = "Add_Course_Servlet" method="post">

Instructor: <input type = "text" name = "instructor">
Room: <input type ="text" name="room">

<input class="button button1" type = "submit" value="Add Course">
</form>
<a href ="index.html"> Back to start</a><br />
<a href = "viewAllCoursesServlet">Complete course list</a></div></div>

</body>
</html>