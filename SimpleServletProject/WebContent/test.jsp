<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checking Jsp</title>
</head>
<body>
<h3>Hello Everybody</h3>

<%!
public int add(int a, int b) {
	return a+b;
}
%>
<%	
int i=1;
int j=2;
int k=i+j;
//out.print("The value of k is "+k);
%>

The value of k is: <%=k %>

<%
int sum = add(4,5);
%>
<br>
The value of sum of 2 numbers is: <%=sum %>
<%
for(int m=0;m<5;m++) {
%>
<br>
The value of i using for loop is <%=m%>
<%} %>
</body>
</html>