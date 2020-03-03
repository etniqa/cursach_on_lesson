<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Worker list</h3>
<table class="table">
    <tr>
        <th>ID</th>
        <th>name</th>
        <th>description</th>
        <th>creationDate</th>
        <th>dateModified</th>
        <th>department where works</th>
        <th>agreement where is working</th>
    </tr>
    <#list workers as worker>
        <tr>
            <td>${(worker.id)!"null"}</td>
            <td>${(worker.name)!"null"}</td>
            <td>${(worker.description)!"null"}</td>
            <td>${(worker.creationDate)!"null"}</td>
            <td>${(worker.dateModified)!"null"}</td>

            <td>${(worker.departmentWhereWorks.name)!"null"}</td>
            <td>${(worker.agreementWhereIsWorking.name)!"null"}</td>

            <td><a href='/web/worker/delete/${worker.id}'><button>delete</button></a></td>
        </tr>
    </#list>
</table>
</body>
</html>