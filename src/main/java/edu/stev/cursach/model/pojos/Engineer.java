package edu.stev.cursach.model.pojos;

import java.time.LocalDateTime;

public class Engineer extends CanLead {
    private int yearsOfExperience;

    public Engineer(String id, String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                    Department departmentWhereWorks, TypeOfAgreement agreementWhereIsWorking, int yearsOfExperience) {
        super(id, name, description, creationDate, dateModified, departmentWhereWorks, agreementWhereIsWorking);
        this.yearsOfExperience = yearsOfExperience;
    }

    public Engineer() {
        super();
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
