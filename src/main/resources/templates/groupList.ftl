<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<h3>Group list</h3>
<div>
    <table class="table table-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>description</th>
            <th>description</th>
            <th>delete</th>
            <th>description</th>
        </tr>
        <#list groups as group>
            <tr>
                <td>${(group.id)!"null"}</td>
                <td>${(group.name)!"null"}</td>
                <td>${(group.description)!"null"}</td>
                <td><a href='/web/group/delete/${group.id}'><button>delete</button></a></td>
            </tr>
        </#list>
    </table>
</div>

</body>
</html>