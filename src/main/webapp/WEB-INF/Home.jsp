<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.akashah.ninjagold.models.NinjaEarnings" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Insert title here</title>
</head>
<body>
	<h3>Total Gold: ${sessionScope.totalgold}</h3>
	<div id = "wrapper">
		<fieldset>
			<form action = '/Farm' method = 'POST'>
				<h2> Farm </h2>
				<p>(earns 10-20 Gold)</p>
				<input type = "submit" value = "Find Gold!">
			</form>
		</fieldset>
	
		<fieldset>
			<form action = '/Cave' method = 'POST'>
				<h2> Cave </h2>
				<p>(earns 5-10 Gold)</p>
				<input type = "submit" value = "Find Gold!">
			</form>
		</fieldset>
		
		<fieldset>
			<form action = '/House' method = 'POST'>
				<h2> House </h2>
				<p>(earns 2-5 Gold)</p>
				<input type = "submit" value = "Find Gold!">
			</form>
		</fieldset>
		
		<fieldset>
			<form action = '/Casino' method = 'POST'>
				<h2> Casino </h2>
				<p>(earns/take 0-50 Gold)</p>
				<input type = "submit" value = "Find Gold!">
			</form>
		</fieldset>
		<form action = '/Reset' method = 'POST'>
				<input type = "submit" value = "Reset">
		</form>
	</div>
	<div id ="activities">
		<h2>Activities</h2>
		<% ArrayList <NinjaEarnings> earnings = (ArrayList<NinjaEarnings>) session.getAttribute("earnings");%>
		<% int length = 0; %>
		<% if (earnings != null) { %>
		<% length = earnings.size(); %>
		<% } %>
		<% for (int i = 0; i < length; i++) { %>
			<p class ="<%= earnings.get(i).getColor()%>"><%= earnings.get(i).getPhrase() %> </p>
		<% } %> 
	</div>
</body>
</html>