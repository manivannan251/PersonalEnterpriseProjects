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
java.util.Properties systemProps = System.getProperties();
java.util.Set<Object> keySet = systemProps.keySet();
for(Object obj : keySet){
    String key = (String) obj;
    out.println("{"+obj+"="+systemProps.getProperty(key)+"}");
} %>
</body>
</html>