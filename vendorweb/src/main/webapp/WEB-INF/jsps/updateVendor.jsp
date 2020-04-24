<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Vendor</title>
</head>
<body>
		
<form action="updateVen" method="post">
<pre>
Id: <input type="text" name="id" value="${vendor.id}" readonly/>
Code: <input type="text" name="code" value="${vendor.code}"/>
Name: <input type="text" name="name" value="${vendor.name}"/>
Type: <select name="type">
		<option value="Regular" ${vendor.type == 'Regular' ? 'selected' : ''}>Regular</option>
		<option value="Contract" ${vendor.type == 'Contract' ? 'selected' : ''}>Contract</option>
</select>
Email: <input type="text" name="email" value="${vendor.email}"/>
Phone: <input type="text" name="phone" value="${vendor.phone}"/>
Address: <textarea rows="4" cols="50" name="address">${vendor.address}</textarea>
<input type="submit" value="save"/>
</pre>

</form>
</body>
</html>