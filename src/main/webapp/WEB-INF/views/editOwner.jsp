<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8">
    <title>Edit owner</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/style.css" type="text/css">
    <link href="https://fonts.googleapis.com/css2?family=Exo+2:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet">
</head>
<body>
<div class="page-header">
    <h1>Edytuj właściciela</h1>
</div>
<form:form method="post" modelAttribute="owner">
    <div class="formContainer">
        <label>Nazwa</label>
        <br>
        <form:input path="name"/>
        <br><br>
        <label>Miasto</label>
        <br>
        <form:input path="cityAddress"/>
        <br><br>
        <label>Ulica</label>
        <br>
        <form:input path="streetAddress"/>
        <br><br>
        <label>Numer</label>
        <br>
        <form:input path="numberAddress"/>
        <br><br>
        <label>Telefon</label>
        <br>
        <form:input path="phone"/>
        <br><br>
        <label>Email</label>
        <br>
        <form:input path="email"/>
        <br><br>
        <label>Opis</label>
        <br>
        <form:input path="description"/>
        <br><br>
        <p>
            <button class="btn btn-primary">Dodaj</button>
        </p>
    </div>
</form:form>
</body>
</html>
