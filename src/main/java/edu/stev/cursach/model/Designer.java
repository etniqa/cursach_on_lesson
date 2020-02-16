package edu.stev.cursach.model;

import java.time.LocalDateTime;

public class Designer extends CanLead {
    private int numberOfLicences;

    public Designer(String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                    Department departmentWhereWorks, TypeOfAgreement agreementWhereIsWorking,
                    TypeOfAgreement typeOfAgreementWhereLead, int numberOfLicences) {
        super(name, description, creationDate, dateModified, departmentWhereWorks, agreementWhereIsWorking, typeOfAgreementWhereLead);
        this.numberOfLicences = numberOfLicences;
    }
}
