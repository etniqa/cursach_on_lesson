package edu.stev.cursach.model.classes;

import java.time.LocalDateTime;

public class CanLead extends Worker {
    public CanLead(String id, String name, String description, LocalDateTime creationDate,
                   LocalDateTime dateModified, Department departmentWhereWorks,
                   TypeOfAgreement agreementWhereIsWorking) {
        super(id, name, description, creationDate, dateModified, departmentWhereWorks, agreementWhereIsWorking);
    }
}