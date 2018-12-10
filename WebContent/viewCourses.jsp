<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Courses</title>
<link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
<link href="style.css" rel="stylesheet">
</head>
<body>
<div class="hero-image"><div class="hero-text" id="display">
<c:forEach items="${requestScope.allCourses}" var="currentCourse">
<table>
<tr>
<td> Course ID: ${currentCourse.courseID}</td>
</tr>
<tr>
<td> Course Instructor: ${currentCourse.instructor}</td>
</tr>
<tr>
<td> Course Room: ${currentCourse.room}</td>
</tr>
</table>
<br />
</c:forEach>
</div></div>
</body>
</html>