<html lang="pl-PL">
<head>
    <meta charset="UTF-8">
    <title>Delete facility</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/style.css" type="text/css">
    <link href="https://fonts.googleapis.com/css2?family=Exo+2:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet">
    <script src="js/facility.js"></script>
    <script src="js/jquery-3.4.1.min.js"></script>
</head>
<body>
<div class="page-header">
    <h1>Czy na pewno chcesz usunąć ten obiekt?</h1>
</div>

<div>
    <td><button class="btn-delete" id="btn-viewAll"  type="button" onclick='viewAll()'>Anuluj</button></td>
</div>
<div>
    <td><button class="btn-delete" id="btn-delete"  type="button" onclick='deleteFacility(${facility.id})'>Usuń</button></td>
</div>

</body>
</html>