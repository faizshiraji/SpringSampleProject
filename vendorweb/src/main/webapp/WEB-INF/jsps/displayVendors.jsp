<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All Vendors</title>
</head>
<body>

<h2>Vendors:</h2>

<table>
<tr>
	<th>ID</th>
	<th>CODE</th>
	<th>VENDOR NAME</th>
	<th>TYPE</th>
	<th>EMAIL</th>
	<th>PHONE</th>
	<th>ADDRESS</th>
</tr>
<c:forEach items="${vendors}" var="vendor">
<tr>
	<td>${vendor.id}</td>
	<td>${vendor.code}</td>
	<td>${vendor.name}</td>
	<td>${vendor.type}</td>
	<td>${vendor.email}</td>
	<td>${vendor.phone}</td>
	<td>${vendor.address}</td>	
	<td><a href="deleteVendor?id=${vendor.id}">delete</a></td>
	<td><a href="showUpdate?id=${vendor.id}">edit</a></td>
</tr>
</c:forEach>

</table>
<a href="showCreate">Add Vendor</a>
</body>
</html>