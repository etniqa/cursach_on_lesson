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
        <th>additional field</th>

        <th>delete</th>
        <th>edit</th>
    </tr>
    <#list workers as worker>
        <tr>
            <td>${(worker.id)!"null"}</td>
            <td>${(worker.shortClassnameWithName)!"null"}</td>
            <td>${(worker.description)!"null"}</td>
            <td>${(worker.creationDate)!"null"}</td>
            <td>${(worker.dateModified)!"null"}</td>

            <td>${(worker.departmentWhereWorks.name)!"null"}</td>
            <td>${(worker.agreementWhereIsWorking.name)!"null"}</td>

            <td>
                <#if Assistant.isInstance(worker)>
                    rate: ${(worker.rate)!"null"}
                <#elseif Designer.isInstance(worker)>
                    number of licenses: ${(worker.numberOfLicences)!"null"}
                <#elseif Engineer.isInstance(worker)>
                    year of experience: ${(worker.yearsOfExperience)!"null"}
                <#elseif Staff.isInstance(worker)>
                    rang: ${(worker.rang)!"null"}
                <#elseif Technician.isInstance(worker)>
                    years of experience: ${(worker.yearsOfExperience)!"null"}
                </#if>
            </td>

            <td><a href='/web/worker/delete/${worker.id}'><button>delete</button></a></td>
            <td><a href='/web/worker/edit/${worker.id}'><button>edit</button></a></td>
        </tr>
    </#list>
</table>
<a href='/web/worker/add/assistant'><button>create assistant</button></a>
<a href='/web/worker/add/designer'><button>create designer</button></a>
<a href='/web/worker/add/engineer'><button>create engineer</button></a>
<a href='/web/worker/add/staff'><button>create staff</button></a>
<a href='/web/worker/add/technician'><button>create technician</button></a>

</body>
</html>