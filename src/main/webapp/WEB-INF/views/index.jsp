<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
    <title>ServiceApp</title>
    <link rel="stylesheet" href="../css/style.css" type="text/css">
    <link rel="stylesheet" href="../css/tables.css" type="text/css">
    <script src="js/menu.js"></script>
    <script src="js/facility.js"></script>
    <script src="js/report.js"></script>
    <script src="js/jquery-3.4.1.min.js"></script>

</head>
<body>
<div>
    <h1>ServiceApp</h1>
</div>
<div id="mainContainer">
  <div id="menuContainer">
  <ul class="circle">
    <li>
        Dodaj zgłoszenie
        <button class="btn-menu" id="btn-addReport">Dodaj zgłoszenie</button>
    </li>
    <li>

        <button class="btn-menu" id="btn-reports" type="button">Historia Zgłoszeń</button>
    </li>
    <li>

        <button class="btn-menu" id="btn-addFacility" type="button">Dodaj obiekt</button>
    </li>
    <li>

        <button class="btn-menu" id="btn-facilities" type="button">Obiekty</button>
    </li>
    <li>

        <button class="btn-menu" id="btn-calendar" type="button">Terminarz</button>
    </li>
  </ul>
  </div>
  <div id="viewContainer"></div>
  <div style="clear: both;" ></div>

</div>
</body>
</html>
