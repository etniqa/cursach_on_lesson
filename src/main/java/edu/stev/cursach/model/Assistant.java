package edu.stev.cursach.model;

import java.time.LocalDateTime;

public class
Assistant extends Worker {
    public Assistant(String id, String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                     Department departmentWhereWorks, TypeOfAgreement agreementWhereIsWorking) {
        super(id, name, description, creationDate, dateModified, departmentWhereWorks, agreementWhereIsWorking);
    }
}
