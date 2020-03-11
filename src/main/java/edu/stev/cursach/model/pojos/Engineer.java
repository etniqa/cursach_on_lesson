package edu.stev.cursach.model.classes;

import java.time.LocalDateTime;

public class Engineer extends CanLead {
    private int yearsOfExpert;

    public Engineer(String id, String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                    Department departmentWhereWorks, TypeOfAgreement agreementWhereIsWorking, int yearsOfExpert) {
        super(id, name, description, creationDate, dateModified, departmentWhereWorks, agreementWhereIsWorking);
        this.yearsOfExpert = yearsOfExpert;
    }

    public int getYearsOfExpert() {
        return yearsOfExpert;
    }

    public void setYearsOfExpert(int yearsOfExpert) {
        this.yearsOfExpert = yearsOfExpert;
    }
}
