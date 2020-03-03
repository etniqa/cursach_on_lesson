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

        <th>begDate</th>
        <th>endDate</th>
        <th>agreement</th>
        <th>chief</th>
    </tr>
    <#list logChiefOfTypeOfProjects as logChiefOfTypeOfProject>
        <tr>
            <td>${(logChiefOfTypeOfProject.id)!"null"}</td>
            <td>${(logChiefOfTypeOfProject.name)!"null"}</td>
            <td>${(logChiefOfTypeOfProject.description)!"null"}</td>
            <td>${(logChiefOfTypeOfProject.creationDate)!"null"}</td>
            <td>${(logChiefOfTypeOfProject.dateModified)!"null"}</td>
            <td>${(logChiefOfTypeOfProject.begDate)!"null"}</td>
            <td>${(logChiefOfTypeOfProject.endDate)!"null"}</td>

            <td>${(logChiefOfTypeOfProject.agreement.name)!"null"}</td>
            <td>${(logChiefOfTypeOfProject.chief.name)!"null"}</td>
        </tr>
    </#list>
</table>
</body>
</html>