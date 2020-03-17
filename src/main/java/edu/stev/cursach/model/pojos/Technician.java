package edu.stev.cursach.model.pojos;
import java.time.LocalDateTime;

public class Technician extends Worker {
    private int yearsOfExperience;

    public Technician() {
        super();
    }

    public Technician(String id, String name, String description, LocalDateTime creationDate, LocalDateTime dateModified, Department departmentWhereWorks, TypeOfAgreement agreementWhereIsWorking, int yearsOfExperience) {
        super(id, name, description, creationDate, dateModified, departmentWhereWorks, agreementWhereIsWorking);
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
