package edu.stev.cursach.model.pojos;

import edu.stev.cursach.model.cmnInterfaces.ICommonFields;

import java.time.LocalDateTime;

public class Organization implements ICommonFields {

    private String id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime dateModified;
    private Organization headOrganization;

    public Organization(String id, String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                        Organization headOrganization) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.dateModified = dateModified;
        this.headOrganization = headOrganization;
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

    public Organization getHeadOrganization() {
        return headOrganization;
    }

    public void setHeadOrganization(Organization headOrganization) {
        this.headOrganization = headOrganization;
    }
}
