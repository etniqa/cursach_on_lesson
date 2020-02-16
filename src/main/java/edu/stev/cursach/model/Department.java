package edu.stev.cursach.model;

import java.time.LocalDateTime;

public class Department extends NecessaryFields{
    private Organization organization;
    private Worker headOfDepartment;

    public Department(String name, String description, LocalDateTime creationDate, LocalDateTime dateModified, Organization organization, Worker headOfDepartment) {
        super(name, description, creationDate, dateModified);
        this.organization = organization;
        this.headOfDepartment = headOfDepartment;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Worker getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(Worker headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }
}
