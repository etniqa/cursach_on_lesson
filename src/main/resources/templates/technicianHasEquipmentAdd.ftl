<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>technician has equipment</title>
</head>
<body>
<fieldset>
    <form method="POST" name = "technicianHasEquipment">
        name: <@spring.formInput "technicianHasEquipmentForm.name" "" "text"/> <br>
        description: <@spring.formInput "technicianHasEquipmentForm.description" "" "text"/> <br>
        technician: <@spring.formSingleSelect "technicianHasEquipmentForm.technicianId" techniciansMap ""/><br>
        equipment: <@spring.formSingleSelect "technicianHasEquipmentForm.equipmentId" equipmentsMap ""/><br>
        <input type="submit"/>
    </form>
</fieldset>
</body>
</html>