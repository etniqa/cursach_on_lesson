<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Agreement has agreement</title>
</head>
<body>
<fieldset>
    <form method="POST" name = "logChiefOfTypeOfProjectAdd">
        name: <@spring.formInput "logChiefOfTypeOfAgreementForm.name" "" "text"/> <br>
        description: <@spring.formInput "logChiefOfTypeOfAgreementForm.description" "" "text"/> <br>
        begin date <@spring.formInput "logChiefOfTypeOfAgreementForm.begDate" "" "text"/> <br>
        end date <@spring.formInput "logChiefOfTypeOfAgreementForm.endDate" "" "text"/> <br>
        agreement: <@spring.formSingleSelect "logChiefOfTypeOfAgreementForm.agreementId" agreementsMap ""/><br>
        chief <@spring.formSingleSelect "logChiefOfTypeOfAgreementForm.chiefId" canLeadsMap ""/><br>
        <input type="submit"/>
    </form>
</fieldset>
</body>
</html>