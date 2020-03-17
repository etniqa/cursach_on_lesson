package edu.stev.cursach.form;

import edu.stev.cursach.model.pojos.Organization;

import java.time.LocalDateTime;

public class OrganizationForm {
    private String name;
    private String description;

    private String headOrganizationId;

    public OrganizationForm() {
    }

    public OrganizationForm(String name, String description, String headOrganizationId) {
        this.name = name;
        this.description = description;

        this.headOrganizationId = headOrganizationId;
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

    public String getHeadOrganizationId() {
        return headOrganizationId;
    }

    public void setHeadOrganizationId(String headOrganizationId) {
        this.headOrganizationId = headOrganizationId;
    }
}
