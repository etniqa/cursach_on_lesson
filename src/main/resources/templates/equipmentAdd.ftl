<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Agreement has agreement</title>
</head>
<body>
<fieldset>
    <form method="POST" name = "equipmentAdd">
        name: <@spring.formInput "equipmentForm.name" "" "text"/> <br>
        description: <@spring.formInput "equipmentForm.description" "" "text"/> <br>
        department which responsible <@spring.formSingleSelect "equipmentForm.depWhichResponsibleId" departmentsMap ""/><br>
        project where is now equipment: <@spring.formSingleSelect "equipmentForm.projectWhereIsNowEquipId" projectsMap ""/><br>
        <input type="submit"/>
    </form>
</fieldset>
</body>
</html>