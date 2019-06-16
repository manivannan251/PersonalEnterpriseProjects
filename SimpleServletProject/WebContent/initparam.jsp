<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%!
public void jspInit() {
	String defuser = getServletConfig().getInitParameter("defuser");
	ServletContext context = getServletContext();
	context.setAttribute("uname", defuser+"test");
}
%>
<body>
The def username from init param is <%=getServletConfig().getInitParameter("defuser") %>

<br>
The def username from servlet conext is <%=getServletContext().getAttribute("uname") %>
</body>
</html>