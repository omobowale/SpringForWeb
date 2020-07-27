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
 
<title>Insert title here</title>
</head>
<body>

This is a test page

<form>
	<textarea id="mytextarea" rows="10" cols="60">	
	</textarea>
	<button id="showbutton">show product</button>
</form>

<script>
	$(function(){
		
		alert("JQ");
		
		//make an ajax call
		$.ajax({
			url: "http://localhost:8083/SpringForWeb/showsomething",
			type: "GET",
			success: function(data){
				alert(data);
			},
			error: function(){
				alert("ERROR: Could not make ajax call")
			}
			
		});
		
		
	});
</script>

</body>
</html>

