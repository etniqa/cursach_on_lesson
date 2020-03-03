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
        <th>organization</th>
    </tr>
    <#list departments as department>
    <tr>
        <td>${(department.id)!"null"}</td>
        <td>${(department.name)!"null"}</td>
        <td>${(department.description)!"null"}</td>
        <td>${(department.creationDate)!"null"}</td>
        <td>${(department.dateModified)!"null"}</td>
        <td>${(department.organization.name)!"null"}</td>
    </tr>
    </#list>
</table>
</body>
</html>