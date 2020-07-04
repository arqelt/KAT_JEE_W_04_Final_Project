<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8">
    <title>ServiceApp</title>
    <link rel="stylesheet" href="../css/tables.css" type="text/css">
    <link href="https://fonts.googleapis.com/css2?family=Exo+2:ital,wght@0,400;0,700;1,400;1,700&display=swap"
          rel="stylesheet">
    <head>
        <title>All reports</title>
    </head>
<body>
<div class="reports">
    <table>
        <thead>
        <tr>
            <th>Data zgłoszenia</th>
            <th>Nazwa obiektu</th>
            <th>Planowana data serwisu</th>
            <th>Serwisant</th>
            <th>Opis</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${reports}" var="report">
            <tr>
                <td><c:out value="${report.reportDate}"/></td>
                <td><c:out value="${report.facility.name}"/></td>
                <td><c:out value="${report.serviceDate}"/></td>
                <td><c:out value="${report.serviceman.lastName}"/></td>
                <td><c:out value="${report.description}"/></td>
                <td>
                    <button class="btn-form" id="btn-editReport" type="button"
                            onclick='editReportRedirect(${report.id})'>Edytuj
                    </button>
                </td>
                <td>
                    <button class="btn-form" id="btn-deleteReport" type="button"
                            onclick='deleteReportRedirect(${report.id})'>Usuń
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>