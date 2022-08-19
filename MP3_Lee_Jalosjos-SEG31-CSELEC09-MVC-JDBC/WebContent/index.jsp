<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homepage</title>
</head>
<body>

<fieldset>
		<legend>Plate Number Coding Checker</legend>
		<form action='coding.action' method='post'>
			<p>Enter bus name: 
				<input type='text' name='busName' maxlength = "30"
					 required>	
			</p>
			<p>Plate No: 
				<input type='text' name='plateNumber' maxlength="6"
					 required>	
			</p>
			<p>Driver Assigned: 
				<input type='text' name='driverName' 
					maxlength="20"  required>	
			</p>

			<p>
				<input type='submit'> 
				<input type='reset'>	
			</p>
		</form>
	</fieldset>
	
</body>
</html>