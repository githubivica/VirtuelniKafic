<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.User" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User page</title>
</head>
<body>
	
	<% 
	User user2 = (User)session.getAttribute("ovdeJeUserObjekat");
	%>
		
	
	<h1>DOBRO DOSLI KOD USERA</h1>
	
	<p>Ovo je userova strana. Ovde cu ubaciti stvari koje se ticu userrskih poslova</p>

	ZDRAVO <%= user2.getUserName() %>

</body>
</html>