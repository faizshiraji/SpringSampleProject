<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Vendor</title>
</head>
<body>

<form action="saveVen" method="post">
<pre>
Id: <input type="text" name="id"/>
Code: <input type="text" name="code"/>
Name: <input type="text" name="name"/>
Type: <select name="type">
		<option value="Regular">Regular</option>
		<option value="Contract">Contract</option>
</select>
Email: <input type="text" name="email"/>
Phone: <input type="text" name="phone"/>
Address: <textarea rows="4" cols="50" name="address"></textarea>
<input type="submit" value="save"/>
</pre>

</form>
${msg}

<a href="displayVendors">View All</a>
</body>
</html>