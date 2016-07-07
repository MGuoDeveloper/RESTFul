<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.studentservice.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Service</title>
</head>
<body>
	<jsp:useBean id="service" class="com.studentservice.RestServiceClient" />
	<jsp:useBean id="obj" class="com.studentservice.Student" />
	<jsp:setProperty name="obj" property="*" />
	<%
		String output = service.getRESTResponse(obj);
	%>
	<%= output %>
</body>
</html>