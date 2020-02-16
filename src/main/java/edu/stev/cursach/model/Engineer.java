package edu.stev.cursach.model;

import java.time.LocalDateTime;
import java.util.List;

public class Engineer extends CanLead {
    public Engineer(String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                    Department departmentWhereWorks, TypeOfAgreement agreementWhereIsWorking) {
        super(name, description, creationDate, dateModified, departmentWhereWorks, agreementWhereIsWorking);
    }
}
