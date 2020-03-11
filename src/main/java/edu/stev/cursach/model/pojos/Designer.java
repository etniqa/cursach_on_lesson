package edu.stev.cursach.model.pojos;

import java.time.LocalDateTime;

public class Designer extends CanLead {
    private int numberOfLicences;

    public Designer(String id, String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                    Department departmentWhereWorks, TypeOfAgreement agreementWhereIsWorking, int numberOfLicences) {
        super(id, name, description, creationDate, dateModified, departmentWhereWorks, agreementWhereIsWorking);
        this.numberOfLicences = numberOfLicences;
    }
}
