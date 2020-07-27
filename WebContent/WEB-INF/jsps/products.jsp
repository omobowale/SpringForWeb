<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>

<sql:query var="rs" dataSource="jdbc/inventorymgtdb">
	select id, name, price, quantity from products
</sql:query>

<p>This is the products page</p>
<c:out value="This is a text"></c:out>
<c:out value="${productsname}"></c:out>

<c:forEach var="row" items="${rs.rows}" varStatus="loop">
	<img src="" />
    ${loop.index} ${row.name} 
</c:forEach>

</body>
</html>