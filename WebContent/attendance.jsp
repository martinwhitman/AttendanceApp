<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Take Attendance</title>
<link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
<link href="style.css" rel="stylesheet">
</head>
<body><div class="hero-image"><div class="hero-text">
<form action="takeAttendanceServlet" method="post">
Class Date: <input type="text" name="sessionDate">
Course ID: <input type="text" name="courseID">
Student ID: <input type="text" name="studentID">
Present:<input type="checkbox" name="present">
<input type="submit" value = "Take Student Attendance" class="button button1">



</form>

<a href="index.html">Back to start</a><br />
<a href="viewAttendance.jsp">View Attendance</a>
</div></div>
</body>
</html>