<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Enrollments By Student</title>
<link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
<link href="style.css" rel="stylesheet">
</head>
<body><div class="hero-image"><div class="hero-text">
<form action ="viewEnrollmentsByStudentServlet" method="post">
Student ID: <input type="text" name="studentID">
<input type="submit" value="View Enrollments By Student" class="button button1">
</form>
<a href ="index.html"> Back to start</a><br />
</div></div>
</body>
</html>