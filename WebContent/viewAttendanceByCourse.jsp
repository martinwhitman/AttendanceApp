<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Attendance By Course</title>
<link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
<link href="style.css" rel="stylesheet">
</head>
<body><div class="hero-image"><div class="hero-text">
<form action ="viewAttendanceByCourseServlet" method="get">
Course ID: <input type="text" name="courseID">
<input type="submit" value="View Attendance By Course" class="button button1">
</form>
<a href ="index.html"> Back to start</a><br />
</div></div>
</body>
</html>