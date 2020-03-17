<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Agreement has agreement</title>
</head>
<body>
<fieldset>
    <form method="POST" name = "departmentAdd">
        name: <@spring.formInput "departmentForm.name" "" "text"/>
        <br>
        description: <@spring.formInput "departmentForm.description" "" "text"/>
        <br>
        organization: <@spring.formSingleSelect "departmentForm.organizationId" organizationsMap ""/>
        <br>
        <input type="submit"/>
    </form>
</fieldset>
</body>
</html>