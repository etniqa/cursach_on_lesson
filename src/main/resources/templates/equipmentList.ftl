<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Department list</h3>
<table class="table">
    <tr>
        <th>ID</th>
        <th>name</th>
        <th>description</th>
        <th>creationDate</th>
        <th>dateModified</th>
        <th>depWhichResponsible</th>
        <th>projectWhereIsNowEquip</th>
    </tr>
    <#list equipments as equipment>
    <tr>
        <td>${(equipment.id)!"null"}</td>
        <td>${(equipment.name)!"null"}</td>
        <td>${(equipment.description)!"null"}</td>
        <td>${(equipment.creationDate)!"null"}</td>
        <td>${(equipment.dateModified)!"null"}</td>
        <td>${(equipment.depWhichResponsible)!"null"}</td>
        <td>${(equipment.projectWhereIsNowEquip.name)!"null"}</td>
        <td><a href='/web/equipment/delete/${equipment.id}'><button>delete</button></a></td>

    </tr>
</#list>
</table>
</body>
</html>