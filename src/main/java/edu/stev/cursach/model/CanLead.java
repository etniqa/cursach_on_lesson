package edu.stev.cursach.model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class CanLead extends Worker{
    public CanLead(String id, String name, String description, LocalDateTime creationDate,
                   LocalDateTime dateModified, Department departmentWhereWorks,
                   TypeOfAgreement agreementWhereIsWorking) {
        super(id, name, description, creationDate, dateModified, departmentWhereWorks, agreementWhereIsWorking);
    }
}
