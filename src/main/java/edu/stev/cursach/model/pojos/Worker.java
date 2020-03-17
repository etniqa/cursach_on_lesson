package edu.stev.cursach.model.pojos;

import edu.stev.cursach.model.cmnInterfaces.ICommonFields;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document
public class Worker implements ICommonFields {

    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime dateModified;
    private Department departmentWhereWorks;
    private TypeOfAgreement agreementWhereIsWorking;

    private String shortClassName;
    private String shortClassnameWithName;
    public Worker() {
        int indexOfLastDot = this.getClass().toString().lastIndexOf(".");
        this.shortClassName = this.getClass().toString().substring(indexOfLastDot + 1);
        this.shortClassnameWithName = "(" + this.shortClassName + ") " + this.name;
    }

    public Worker(String id, String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                  Department departmentWhereWorks, TypeOfAgreement agreementWhereIsWorking) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.dateModified = dateModified;
        this.departmentWhereWorks = departmentWhereWorks;
        this.agreementWhereIsWorking = agreementWhereIsWorking;
        this.resetShortClassnameWithName();
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

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
        this.resetShortClassnameWithName();
    }

    private void resetShortClassnameWithName() {
        int indexOfLastDot = this.getClass().toString().lastIndexOf(".");
        this.shortClassName = this.getClass().toString().substring(indexOfLastDot + 1);
        this.shortClassnameWithName = "(" + this.shortClassName + ") " + this.name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public LocalDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDateTime dateModified) {
        this.dateModified = dateModified;
    }

    public String getShortClassName() {
        return shortClassName;
    }

    public String getShortClassnameWithName() {
        return shortClassnameWithName;
    }
}
