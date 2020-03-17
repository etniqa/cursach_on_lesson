<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Agreement has agreement</title>
</head>
<body>
<fieldset>
    <legend>Add student</legend>
    <form name="agreementHasAgreement" method="POST">
        name:<@spring.formInput "agreementHasAgreementForm.name", "", "text"/>
        <br>
        description:<@spring.formInput "agreementHasAgreementForm.description", "", "text"/>
        <br>
        head agreement:<@spring.formSingleSelect "agreementHasAgreementForm.headAgreementId", mapHeadAgreement, ""/>
        <br>
        other agreement:<@spring.formSingleSelect "agreementHasAgreementForm.otherAgreementId", mapOtherAgreement, ""/>
        <br>
        <input type="submit" value="Create"/>
    </form>
</fieldset>
</body>
</html>