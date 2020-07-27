<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

<script type="text/javascript" src="${pageContext.request.contextPath}/myresources/jq/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/myresources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/myresources/css/bootstrap.min.css"/>
 

<title>Checking page</title>
</head>
<body>

<img src="${pageContext.request.contextPath}/myresources/images/me.jpg" />

<script>
	$(function (){
		$.ajax({
			type: "GET",
			url: "http://localhost:8083/SpringForWeb/showSomething",
			success: function (data){
				alert(data);
			}
			
		});
	})
</script>
</body>
</html>