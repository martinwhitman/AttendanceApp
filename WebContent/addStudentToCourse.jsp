<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student To Course</title>
<link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
<link href="style.css" rel="stylesheet">
</head>
<body><div class="hero-image"><div class="hero-text">
<form action = "Add_Student_To_Course_Servlet" method="post">

Student ID: <input type = "text" name = "studentID">
Course ID:<input type ="text" name="courseID">

<input type = "submit" value="Add Student To Course" class="button button1">
</form>
<a href ="index.html"> Back to start</a><br />
<a href = "viewEnrollments.jsp">View All Enrollments</a>
</div></div>
</body>
</html>