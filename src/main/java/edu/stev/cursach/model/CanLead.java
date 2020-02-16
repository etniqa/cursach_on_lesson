package edu.stev.cursach.model;

import java.time.LocalDateTime;

public class CanLead extends Worker{
    private TypeOfAgreement typeOfAgreementWhereLead;

    public CanLead(String name, String description, LocalDateTime creationDate, LocalDateTime dateModified, Department departmentWhereWorks, TypeOfAgreement agreementWhereIsWorking, TypeOfAgreement typeOfAgreementWhereLead) {
        super(name, description, creationDate, dateModified, departmentWhereWorks, agreementWhereIsWorking);
        this.typeOfAgreementWhereLead = typeOfAgreementWhereLead;
    }
}
