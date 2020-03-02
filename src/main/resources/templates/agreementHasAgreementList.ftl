<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Connections between agreements list</h3>
<table class="table">
    <tr>
        <th>ID</th>
        <th>name</th>
        <th>description</th>
        <th>creationDate</th>
        <th>dateModified</th>
        <th>Header agreement</th>
        <th>other agreement</th>
    </tr>
    <#list agreementBelongToAgreements as agreementBelongToAgreement>
    <tr>
        <td>${(agreementBelongToAgreement.id)!"null"}</td>
        <td>${(agreementBelongToAgreement.name)!"null"}</td>
        <td>${(agreementBelongToAgreement.description)!"null"}</td>
        <td>${(agreementBelongToAgreement.creationDate)!"null"}</td>
        <td>${(agreementBelongToAgreement.dateModified)!"null"}</td>
        <td>${(agreementBelongToAgreement.headAgreement.name)!"null"}</td>
        <td>${(agreementBelongToAgreement.otherAgreement.name)!"null"}</td>
    </tr>
</#list>
</table>
</body>
</html>