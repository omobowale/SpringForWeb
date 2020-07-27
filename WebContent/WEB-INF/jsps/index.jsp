<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/myresources/jq/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/myresources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/myresources/css/bootstrap.min.css"/>
 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<p>Hi there! We are about to learn Spring for the web</p>
<p>Another one</p>

<c:forEach var="product" items="${products}" varStatus="loop">
    ${loop.index} ${product.name}  ${product.quantity} <br>
</c:forEach>

<a href="${pageContext.request.contextPath}/home">Home</a>
<a href="${pageContext.request.contextPath}/products">Products</a>

</body>
</html>