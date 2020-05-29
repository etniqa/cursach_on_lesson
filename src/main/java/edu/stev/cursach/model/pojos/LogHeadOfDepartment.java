package edu.stev.cursach.model.pojos;

import edu.stev.cursach.model.cmnInterfaces.ICommonFields;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Document
public class LogHeadOfDepartment implements ICommonFields {
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime dateModified;

    private LocalDate begDate;
    private LocalDate endDate;
    private CanLead headOfDepartment;
    private Department department;

    public LogHeadOfDepartment(String id, String name, String description, LocalDateTime creationDate,
                               LocalDateTime dateModified, LocalDate begDate, LocalDate endDate, CanLead headOfDepartment, Department department) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.dateModified = dateModified;
        this.begDate = begDate;
        this.endDate = endDate;
        this.headOfDepartment = headOfDepartment;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDate getBegDate() {
        return begDate;
    }

    public void setBegDate(LocalDate begDate) {
        this.begDate = begDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public CanLead getHeadOfDepartment() {
        return headOfDepartment;
    }
    public String getHeadOfDepartmentId() {
        return headOfDepartment.getId();
    }

    public void setHeadOfDepartment(CanLead headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
