
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.AdminDAO"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>administrator page</title>
</head>

<body>
	<% 
	User user3 = (User)session.getAttribute("ovdeJeUserObjekat");
	%>
	
	<h1>DOBRO DOSLI NA ADMINNISTRATOROVU STRANU</h1>
	<p>Ovo je administratorova strana. Ovde cu ubaciti stvari koje se ticu administratorskih poslova</p>>
	
	ZDRAVO <%= user3.getUserName() %>
	
	
	<%
		List<User> listaUsera =new ArrayList<User>();
		listaUsera = AdminDAO.vratiSveUsere();
	%>
	
	<table border="1">
		<tr>
			<th> ID </th>
			<th> USERNAME </th>
			<th> PASSWORD </th>
			<th> NOVCANIK </th>
		</tr>
		<% for (User u:listaUsera){
			
		%>	
			<tr>
				<td> <%= u.getIdUser() %> </td>
				<td> <%= u.getUserName() %></td>
				<td> <%= u.getPassword() %> </td>
				<td> <%= u.getNovcanik() %> </td>
			</tr>
		<%
			}
		%>
		
	
	</table>
	
	
	
	
	<%
	int a = 1;
	int b = 5;
	int rez = a + b;
	String tekst = "Ovo je tekst!";
	%>
	
	Adminov omiljeni broj je: <%=rez %>
	A tekst je <%= tekst %>
	
	<% for (int i =1; i<=5; i++){ %>
		
	broj: <%=i %>	<br>
		
	<%} %>
	
</body>
</html>