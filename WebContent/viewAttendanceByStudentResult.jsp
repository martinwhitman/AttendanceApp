<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Attendance By Student</title>
<link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
<link href="style.css" rel="stylesheet">
</head>
<body><div class="hero-image"><div class="hero-text" id="display">
<c:forEach items="${requestScope.attendance}" var = "attendance">
<table>
<tr><td>Date: ${attendance.sessionDate}</td>
<td>Course: ${attendance.course}</td>
<td>Present: ${attendance.present}</td>
</tr>
</table>
</c:forEach>
</div></div>
</body>
</html>