<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>type_of_agreement list</h3>
<table class="table">
    <tr>
        <th>ID</th>
        <th>name</th>
        <th>description</th>
        <th>creationDate</th>
        <th>dateModified</th>

        <th>dateBeg</th>
        <th>dateEnd</th>
        <th>chief</th>
        <th>organizationWhichSign</th>

        <th>delete</th>
        <th>edit</th>
    </tr>
    <#list typeOfAgreements as typeOfAgreement>
        <tr>
            <td>${typeOfAgreement.id}</td>
            <td>${typeOfAgreement.fullName}</td>
            <td>${typeOfAgreement.description}</td>
            <td>${typeOfAgreement.creationDate}</td>
            <td>${(typeOfAgreement.dateModified)!"null"}</td>

            <td>${(typeOfAgreement.dateBeg)!"null"}</td>
            <td>${(typeOfAgreement.dateEnd)!"null"}</td>
            <td>${(typeOfAgreement.chief.name)!"null"}</td>
            <td>${(typeOfAgreement.organizationWhichSign.name)!"null"}</td>

            <td><a href='/web/type_of_agreement/delete/${typeOfAgreement.id}'><button>delete</button></a></td>
            <td><a href='/web/type_of_agreement/edit/${typeOfAgreement.id}'><button>edit</button></a></td>
        </tr>
    </#list>
</table>
<a href='/web/type_of_agreement/add'><button>create</button></a>
</body>
</html>