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
        </tr>
        <#list groups as group>
            <tr>
                <td>${group.id}</td>
                <td>${group.name}</td>
            </tr>
        </#list>
    </table>
</div>

</body>
</html>