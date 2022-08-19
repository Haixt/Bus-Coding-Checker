<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Coding Checker Results</title>
</head>
<body>

<hr>
	<h2>Coding Scheme for <b>${busDetails.busName}</b> Company </h2>
	<p>Bus Name: <b>${busDetails.busName}</b></p>
	<p>Plate Number: <b style="text-transform:uppercase">${busDetails.plateNumber}</b></p>
	<p>Day of Coding: <b>${busDetails.codingDay}</b></p>
	<p>Last Plate Number: <b>${busDetails.lastDigit}</b></p>
	
	<p>The <u><b>${busDetails.busName}</b></u> with plate number  <u><b style="text-transform:uppercase">${busDetails.plateNumber}</b></u>
	 belongs to <u><b>${busDetails.codingDay}</b></u> coding. 
	 Assigned driver is <u><b>${busDetails.driverName}</b></u> .</p>
	
	
	
	<form action='index.jsp'>
		<input type="submit" value="<< GO BACK >>" />
	</form>
</body>
</html>