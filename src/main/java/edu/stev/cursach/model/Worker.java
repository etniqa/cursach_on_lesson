package edu.stev.cursach.model;

import java.time.LocalDateTime;

public class Worker extends NecessaryFields {
    private Department departmentWhereWorks;
    private TypeOfAgreement agreementWhereIsWorking;

    public Worker(String name, String description, LocalDateTime creationDate, LocalDateTime dateModified, Department departmentWhereWorks, TypeOfAgreement agreementWhereIsWorking) {
        super(name, description, creationDate, dateModified);
        this.departmentWhereWorks = departmentWhereWorks;
        this.agreementWhereIsWorking = agreementWhereIsWorking;
    }

    public Worker(Department departmentWhereWorks, TypeOfAgreement agreementWhereIsWorking) {
        this.departmentWhereWorks = departmentWhereWorks;
        this.agreementWhereIsWorking = agreementWhereIsWorking;
    }

    public Department getDepartmentWhereWorks() {
        return departmentWhereWorks;
    }

    public void setDepartmentWhereWorks(Department departmentWhereWorks) {
        this.departmentWhereWorks = departmentWhereWorks;
    }

    public TypeOfAgreement getAgreementWhereIsWorking() {
        return agreementWhereIsWorking;
    }

    public void setAgreementWhereIsWorking(TypeOfAgreement agreementWhereIsWorking) {
        this.agreementWhereIsWorking = agreementWhereIsWorking;
    }
}
