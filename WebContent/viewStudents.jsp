<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Students</title>
<link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
<link href="style.css" rel="stylesheet">
</head>
<body>
<div class="hero-image"><div class="hero-text" id="display">
<c:forEach items="${requestScope.allStudents}" var="currentStudent">
<table>
<tr>
<td> Student ID: ${currentStudent.studentID}</td>
</tr>
<tr>
<td> Student Name: ${currentStudent.name}</td>
</tr>
<tr>
<td> Date Of Birth: ${currentStudent.dob}</td>
</tr>
</table>
<br />
</c:forEach>
</div></div>
</body>
</html>