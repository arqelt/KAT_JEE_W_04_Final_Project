<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8">
    <title>ServiceApp</title>
    <link rel="stylesheet" href="../css/tables.css" type="text/css">
    <link href="https://fonts.googleapis.com/css2?family=Exo+2:ital,wght@0,400;0,700;1,400;1,700&display=swap"
          rel="stylesheet">
    <head>
        <title>All facilities</title>
    </head>
<body>
<sec:authorize access="isAuthenticated()">
<div class="facilities">
    <table>
        <thead>
        <tr>
            <th>Nazwa</th>
            <th>Właściciel</th>
            <th>Miasto</th>
            <th>Ulica</th>
            <th>Numer</th>
            <th>Telefon</th>
            <th>Email</th>
            <th>Opis</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${facilities}" var="facility">
            <tr>
                <td><c:out value="${facility.name}"/></td>
                <td><c:out value="${facility.owner.name}"/></td>
                <td><c:out value="${facility.cityAddress}"/></td>
                <td><c:out value="${facility.streetAddress}"/></td>
                <td><c:out value="${facility.numberAddress}"/></td>
                <td><c:out value="${facility.phone}"/></td>
                <td><c:out value="${facility.email}"/></td>
                <td><c:out value="${facility.description}"/></td>
                <td>
                    <button class="btn-form" id="btn-editFacility" type="button"
                            onclick='editFacilityRedirect(${facility.id})'>Edytuj
                    </button>
                </td>
                <td>
                    <button class="btn-form" id="btn-deleteFacility" type="button"
                            onclick='deleteFacilityRedirect(${facility.id})'>Usuń
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</sec:authorize>
</body>
</html>