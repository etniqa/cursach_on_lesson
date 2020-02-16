package edu.stev.cursach.model;

import java.time.LocalDateTime;

public class Engineer extends CanLead {
    public Engineer(String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                    Department departmentWhereWorks, TypeOfAgreement agreementWhereIsWorking,
                    TypeOfAgreement typeOfAgreementWhereLead) {
        super(name, description, creationDate, dateModified, departmentWhereWorks, agreementWhereIsWorking, typeOfAgreementWhereLead);
    }
}
