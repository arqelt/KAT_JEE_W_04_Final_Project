<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8">
    <title>Add facility</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/style.css" type="text/css">
    <link href="https://fonts.googleapis.com/css2?family=Exo+2:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet">
    <script src="js/facility.js" type="text/javascript"></script>
    <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
</head>
<body><!--
<div class="page-header">
    <h1>Dodaj nowy objekt</h1>
</div>-->
<sec:authorize access="isAuthenticated()">
<form:form method="post" modelAttribute="facility">
    <div class="formContainer">
        <label>Nazwa obiektu</label>
        <br>
        <form:input path="name" class="inputForm"/>
        <br><br>
        <label>Właściciel</label>
        <br>
        <form:select itemValue="id" itemLabel="name" path="owner" items="${owners}" class="inputForm"/>
        <br><br>
        <label>Miasto</label>
        <br>
        <form:input path="cityAddress" class="inputForm"/>
        <br><br>
        <label>Ulica</label>
        <br>
        <form:input path="streetAddress" class="inputForm"/>
        <br><br>
        <label>Numer</label>
        <br>
        <form:input path="numberAddress" class="inputForm"/>
        <br><br>
        <label>Numer telefonu</label>
        <br>
        <form:input path="phone" class="inputForm"/>
        <br><br>
        <label>Adres email</label>
        <br>
        <form:input path="email" class="inputForm"/>
        <br><br>
        <label>Opis systemu</label>
        <br>
        <form:input path="description" class="inputForm"/>
        <br><br>
        <p>
            <button class="btn-add" type="button" onclick='addFacility()'>Dodaj</button>
        </p>
    </div>
</form:form>
</sec:authorize>
</body>
</html>