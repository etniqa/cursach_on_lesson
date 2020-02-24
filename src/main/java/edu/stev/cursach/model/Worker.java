package edu.stev.cursach.model;

import java.time.LocalDateTime;

public class Worker {
    static int maxInt;
    static String maxIntString;
    static {
        maxInt = 0;
    }
    private String id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime dateModified;
    private Department departmentWhereWorks;
    private TypeOfAgreement agreementWhereIsWorking;

    public Worker(String id, String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                  Department departmentWhereWorks, TypeOfAgreement agreementWhereIsWorking) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.dateModified = dateModified;
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

    public static int getMaxIntAndIncrement() {
        return maxInt++;
    }

    public static String getMaxIntStringAndIncrement() {
        return Integer.toString(maxInt++);
    }

    public static int getMaxInt() {
        return maxInt;
    }

    public static String getMaxIntString() {
        return maxIntString;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDateTime dateModified) {
        this.dateModified = dateModified;
    }
}
