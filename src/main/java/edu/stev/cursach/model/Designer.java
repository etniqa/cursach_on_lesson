package edu.stev.cursach.model;

import java.time.LocalDateTime;
import java.util.List;

public class Designer extends CanLead {
    private int numberOfLicences;

    public Designer(String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                    Department departmentWhereWorks, TypeOfAgreement agreementWhereIsWorking,
                    int numberOfLicences) {
        super(name, description, creationDate, dateModified, departmentWhereWorks, agreementWhereIsWorking);
        this.numberOfLicences = numberOfLicences;
    }
}
