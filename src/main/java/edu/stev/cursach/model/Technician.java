package edu.stev.cursach.model;

import java.time.LocalDateTime;

public class Technician extends Worker {
    private Equipment[] whatKnowHowToUse;

    public Technician(String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                      Department departmentWhereWorks, TypeOfAgreement agreementWhereIsWorking,
                      Equipment ... whatKnowHowToUse) {
        super(name, description, creationDate, dateModified, departmentWhereWorks, agreementWhereIsWorking);
        this.whatKnowHowToUse = whatKnowHowToUse;
    }
}
