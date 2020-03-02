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
        <th>delete</th>
    </tr>
    <#list agreementHasAgreements as agreementHasAgreement>
    <tr>
        <td>${(agreementHasAgreement.id)!"null"}</td>
        <td>${(agreementHasAgreement.name)!"null"}</td>
        <td>${(agreementHasAgreement.description)!"null"}</td>
        <td>${(agreementHasAgreement.creationDate)!"null"}</td>
        <td>${(agreementHasAgreement.dateModified)!"null"}</td>
        <td>${(agreementHasAgreement.headAgreement.name)!"null"}</td>
        <td>${(agreementHasAgreement.otherAgreement.name)!"null"}</td>
        <td><a href='/web/agreement_has_agreement/delete/${agreementHasAgreement.id}'><button>delete</button></a></td>
    </tr>
</#list>
</table>
</body>
</html>