<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>organization</title>
</head>
<body>
<fieldset>
    <form method="POST" name = "logHeadOfDepartment">
        name: <@spring.formInput "organizationForm.name" "" "text"/> <br>
        description: <@spring.formInput "organizationForm.description" "" "text"/> <br>
        head organization: <@spring.formSingleSelect "organizationForm.headOrganizationId" headOrganizationsMap ""/><br>
        <input type="submit"/>
    </form>
</fieldset>
</body>
</html>