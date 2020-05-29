<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Log of changes of equipment list</h3>
<table class="table">
    <tr>
        <th>ID</th>
        <th>name</th>
        <th>description</th>
        <th>creationDate</th>
        <th>dateModified</th>

        <th>equipWhichChangeField</th>
        <th>department</th>
        <th>project</th>
        <th>date of change</th>
        <th>date of next change</th>

        <th>delete</th>
        <th>edit</th>
    </tr>
    <#list logOfChangesOfEquipments as logChangesOfEquipment>
        <tr>
            <td>${(logChangesOfEquipment.id)!"null"}</td>
            <td>${(logChangesOfEquipment.name)!"null"}</td>
            <td>${(logChangesOfEquipment.description)!"null"}</td>
            <td>${(logChangesOfEquipment.creationDate)!"null"}</td>
            <td>${(logChangesOfEquipment.dateModified)!"null"}</td>

            <td>${(logChangesOfEquipment.equipWhichChangeField.name)!"null"}</td>
            <td>${(logChangesOfEquipment.possibleNewDepartment.name)!"null"}</td>
            <td>${(logChangesOfEquipment.possibleNewProject.name)!"null"}</td>
            <td>${(logChangesOfEquipment.dateBegAfterChange)!"null"}</td>
            <td>${(logChangesOfEquipment.dateEndBeforeNewChange)!"null"}</td>

            <td><a href='/web/log_of_changes_of_equipment/delete/${logChangesOfEquipment.id}'><button>delete</button></a></td>
            <td><a href='/web/log_of_changes_of_equipment/edit/${logChangesOfEquipment.id}'><button>edit</button></a></td>
        </tr>
    </#list>
</table>
<td><a href='/web/log_of_changes_of_equipment/add'><button class="ui-button">create</button></a></td>
</body>
</html>