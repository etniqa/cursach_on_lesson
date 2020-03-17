<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Log head of department</title>
</head>
<body>
<fieldset>
    <form method="POST" name = "organizationAddOrEdit">
        name: <@spring.formInput "logHeadOfDepartmentForm.name" "" "text"/> <br>
        description: <@spring.formInput "logHeadOfDepartmentForm.description" "" "text"/> <br>
        agreement: <@spring.formSingleSelect "logHeadOfDepartmentForm.headOfDepartmentId" headsOfDepartmentMap ""/><br>
        chief <@spring.formSingleSelect "logHeadOfDepartmentForm.departmentId" departmentsMap ""/><br>
        <input type="submit"/>
    </form>
</fieldset>
</body>
</html>