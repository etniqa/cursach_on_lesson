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
        name: <@spring.formInput "typeOfAgreementForm.name" "" "text"/> <br>
        description: <@spring.formInput "typeOfAgreementForm.description" "" "text"/> <br>
        date of beginning: <@spring.formInput "typeOfAgreementForm.dateBeg" "" "text"/><br>
        end date: <@spring.formInput "typeOfAgreementForm.dateEnd" "" "text"/><br>
        organization which have signed: <@spring.formSingleSelect "typeOfAgreementForm.organizationWhichSignId" organizationsMap ""/><br>
        cost (empty field = 0): <@spring.formInput "typeOfAgreementForm.cost" "" "number"/><br>
        <br>
        <#if isShowTwoTypes>
            type of agreement: <@spring.formSingleSelect "typeOfAgreementForm.type" twoTypesMap ""/><br>
        </#if>
        <input type="submit"/>
    </form>
</fieldset>
</body>
</html>