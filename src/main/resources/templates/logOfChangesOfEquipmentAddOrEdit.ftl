<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Log head of department</title>
</head>
<body>
<fieldset>
    <form method="POST" name="logOfChangesOfEquipmentAddOrEdit">
        name: <@spring.formInput "logOfChangesOfEquipmentForm.name" "" "text"/> <br>
        description: <@spring.formInput "logOfChangesOfEquipmentForm.description" "" "text"/> <br>
        equipment which somehow is
        changing: <@spring.formSingleSelect "logOfChangesOfEquipmentForm.equipWhichChangeFieldId" equipmentsMap ""/><br>
        possible new department where is moving
        equipment <@spring.formSingleSelect "logOfChangesOfEquipmentForm.possibleNewDepartmentId" departmentsMap ""/>
        possible new project where is moving
        equipment <@spring.formSingleSelect "logOfChangesOfEquipmentForm.possibleNewProjectId" projectsMap ""/>
        <br>
        <input type="submit"/>
    </form>
</fieldset>
</body>
</html>