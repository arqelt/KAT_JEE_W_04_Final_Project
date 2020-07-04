<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8">
    <title>Edit Report</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/style.css" type="text/css">
    <link href="https://fonts.googleapis.com/css2?family=Exo+2:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet">
    <script src="js/report.js" type="text/javascript"></script>
    <script src="js/jquery-3.4.1.min.js"></script>
</head>
<body>
<div class="page-header">
    <h1>Edytuj zgłoszenie</h1>
</div>
<form:form method="post" modelAttribute="report" name="addReportForm">
<div class="formContainer">
    <label>Nazwa obiektu</label>
    <br>
    <form:select itemValue="id" itemLabel="name" path="facility" items="${facilities}" class="inputForm"/>
    <br><br>
    <label>Data złoszenia</label>
    <br>
    <form:input path="reportDate"  class="inputForm"/>
    <br><br>
    <label>Planowany termin realizacji</label>
    <br>
    <form:input path="serviceDate" class="inputForm"/>
    <br><br>
    <label>Serwisant</label>
    <br>
    <form:select itemValue="id" itemLabel="lastName" path="serviceman" items="${servicemen}" class="inputForm"/>
    <br><br>
    <label>Opis zgłoszenia</label>
    <br>
    <form:input path="description" class="inputForm"/>
    <br><br>
    <p>
        <button class="btn-add" type="button" onclick='editReport(${report.id})'>Edytuj</button>
    </p>
</div>
</form:form>
</body>
</html>