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
        <th>headOfDepartment</th>
        <th>department</th>

        <th>delete</th>
        <th>edit</th>
    </tr>
    <#list logHeadOfDepartments as logHeadOfDepartment>
        <tr>
            <td>${(logHeadOfDepartment.id)!"null"}</td>
            <td>${(logHeadOfDepartment.name)!"null"}</td>
            <td>${(logHeadOfDepartment.description)!"null"}</td>
            <td>${(logHeadOfDepartment.creationDate)!"null"}</td>
            <td>${(logHeadOfDepartment.dateModified)!"null"}</td>

            <td>${(logHeadOfDepartment.begDate)!"null"}</td>
            <td>${(logHeadOfDepartment.endDate)!"null"}</td>
            <td>${(logHeadOfDepartment.headOfDepartment.name)!"null"}</td>
            <td>${(logHeadOfDepartment.department.name)!"null"}</td>

            <td><a href='/web/log_head_of_department/delete/${logHeadOfDepartment.id}'><button>delete</button></a></td>
            <td><a href='/web/log_head_of_department/edit/${logHeadOfDepartment.id}'><button>edit</button></a></td>
        </tr>
    </#list>
</table>
<td><a href='/web/log_head_of_department/add'><button>create</button></a></td>

</body>
</html>