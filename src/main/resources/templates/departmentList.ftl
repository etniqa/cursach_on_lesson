<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <style type="text/css">
        div.my-general-table {
            display: inline;
        }
    </style>
</head>
<body>
<h3>Department list</h3>
<#--<div class="my-general-table">-->
<table class="table">
        <tr>
            <th>ID</th>
            <th>name</th>
            <th>description</th>
            <th>creationDate</th>
            <th>dateModified</th>

            <th>organization</th>

            <th>head of department</th>

            <th>delete</th>
            <th>edit</th>
        </tr>
        <#list departmentsForListOnFTL as departmentForListOnFTL>
        <tr>
            <td>${(departmentForListOnFTL.department.id)!"null"}</td>
            <td>${(departmentForListOnFTL.department.name)!"null"}</td>
            <td>${(departmentForListOnFTL.department.description)!"null"}</td>
            <td>${(departmentForListOnFTL.department.creationDate)!"null"}</td>
            <td>${(departmentForListOnFTL.department.dateModified)!"null"}</td>

            <td>${(departmentForListOnFTL.department.organization.name)!"null"}</td>

            <td>${(departmentForListOnFTL.headOfDepartment.name)!"null"}</td>

            <td><a href='/web/department/delete/${departmentForListOnFTL.department.id}'><button>delete</button></a></td>
            <td><a href="/web/department/edit/${departmentForListOnFTL.department.id}"><button>edit</button></a></td>
        </tr>
        </#list>
    </table>
<#--<table class="table">
    <tr>
        <th>head of department</th>
    </tr>
    <#list headsOfDepartment as headOfDepartment>
        <tr>
            <td>${headOfDepartment.name}</td>
        </tr>
    </#list>
</table>-->
<a href="/web/department/add"><button>create</button></a>
</body>
</html>