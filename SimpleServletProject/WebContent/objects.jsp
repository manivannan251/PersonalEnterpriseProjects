<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String username = (String) request.getParameter("name");
if(username!=null) {
	session.setAttribute("sessionName", username);
	application.setAttribute("contextUsername", username);
	pageContext.setAttribute("pagecontextName", username);
}

%>

The username in request object is <%=username %>
<br>
The username in session object is <%=session.getAttribute("sessionName") %>
<br>

The username in context object is <%=application.getAttribute("contextUsername") %>
<br>
The username in page context object is <%=pageContext.getAttribute("pagecontextName") %>
</body>


</html>