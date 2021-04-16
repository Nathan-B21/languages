<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${language.name}</title>
</head>
<body>
 
<h1>Edit Language</h1>
<a href = #></a>
<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
<input type ="hidden" name = "_method" value= "put" />
    
    <p>
        <form:label path="name">Name ${language.name} </form:label>
        
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:textarea path="creator"/>
    </p>
    <p>
        <form:label path="currentVersion">Version</form:label>
        <form:errors path="currentVersion"/>
        <form:input path="currentVersion"/>
    </p>

    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>