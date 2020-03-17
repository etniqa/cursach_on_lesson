<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>type of agreement</title>
</head>
<body>
<fieldset>
    <form method="POST" name = "technicianHasEquipment">
        name: <@spring.formInput "workerForm.name" "" "text"/> <br>
        description: <@spring.formInput "workerForm.description" "" "text"/> <br>

        department where this worker is working now: <@spring.formSingleSelect "workerForm.departmentWhereWorksId" departmentsMap ""/><br>
        agreement where this worker is working now: <@spring.formSingleSelect "workerForm.agreementWhereIsWorkingId" agreementsMap ""/><br>

        <#switch typeOfWorker>
            <#case "assistant">
                rate:<@spring.formInput "workerForm.additionalField" "" "number"/> <br>
                <#break >
            <#case "designer">
                number of licenses:<@spring.formInput "workerForm.additionalField" "" "number"/> <br>
            <#break >
            <#case "engineer">
                years of experience:<@spring.formInput "workerForm.additionalField" "" "number"/> <br>
            <#break >
            <#case "staff">
                rang:<@spring.formInput "workerForm.additionalField" "" "number"/> <br>
            <#break >
            <#case "technician">
                years of experience:<@spring.formInput "workerForm.additionalField" "" "number"/> <br>
            <#break >
        </#switch>
        <input type="submit"/>
    </form>
</fieldset>
</body>
</html>