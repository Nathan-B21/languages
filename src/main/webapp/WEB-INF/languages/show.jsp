<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
 
<h1><c:out value="${langauge.name}"/></h1>
<p>Description: <c:out value="${language.creator}"/></p>
<p>Language: <c:out value="${language.currentVersion}"/></p>

<a href="/languages/${language.id}/edit">Edit Book</a>
<form action="/languages/${language.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
    
    
    
</form>
</body>
</html>