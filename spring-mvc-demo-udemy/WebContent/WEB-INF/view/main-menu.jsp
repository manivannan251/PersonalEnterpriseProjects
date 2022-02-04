<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC Demo</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/simple-test.js"></script>
</head>
<body>
<h2>Spring MVC Demo Home Page</h2>
<br>
<a href="hello/showForm">Hello World Form</a>
<br><br>
<a href="student/showForm">Student Form</a>
<br><br>
<input type="button" value="Click Me" onclick="doSomeWork()">
</body>
</html>