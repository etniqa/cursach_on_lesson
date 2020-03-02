<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Technician know how to use equipments</h3>
<table class="table">
    <tr>
        <th>ID</th>
        <th>description</th>
        <th>creationDate</th>
        <th>technician</th>
        <th>equipment</th>
    </tr>
    <#list technicianHasEquipments as technicianHasEquipment>
    <tr>
        <td>${(technicianHasEquipment.id)!"null"}</td>
        <td>${(technicianHasEquipment.description)!"null"}</td>
        <td>${(technicianHasEquipment.creationDate)!"null"}</td>
        <td>${(technicianHasEquipment.technician.name)!"null"}</td>
        <td>${(technicianHasEquipment.equipment.name)!"null"}</td>
    </tr>
</#list>
</table>
</body>
</html>