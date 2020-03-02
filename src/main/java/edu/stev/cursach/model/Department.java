package edu.stev.cursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document
public class Department {
    static int maxInt;
    static String maxIntString;
    static {
        maxInt = 0;
    }
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime dateModified;
    private Organization organization;
    private Worker headOfDepartment;

    public Department(String id, String name, String description, LocalDateTime creationDate,
                      LocalDateTime dateModified, Organization organization, Worker headOfDepartment) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.dateModified = dateModified;
        this.organization = organization;
        this.headOfDepartment = headOfDepartment;
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

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", dateModified=" + dateModified +
                ", organization=" + organization +
                ", headOfDepartment=" + headOfDepartment +
                '}';
    }
}
