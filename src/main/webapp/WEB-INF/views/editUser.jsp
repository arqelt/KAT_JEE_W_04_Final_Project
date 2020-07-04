<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8">
    <title>Edit user</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/style.css" type="text/css">
    <link href="https://fonts.googleapis.com/css2?family=Exo+2:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet">
</head>
<body>
<div class="page-header">
    <h1>Edytuj użytkownika</h1>
</div>
<form:form method="post" modelAttribute="user">
    <label>Imię</label>
    <br>
    <form:input path="firstName"/>
    <br><br>
    <label>Nazwisko</label>
    <br>
    <form:input path="lastName"/>
    <br><br>
    <p>
        <button class="btn btn-primary">Dodaj</button>
    </p>
</form:form>
</body>
</html>
