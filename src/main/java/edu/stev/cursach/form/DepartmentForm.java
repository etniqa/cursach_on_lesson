package edu.stev.cursach.form;

public class DepartmentForm {
    private String name;
    private String description;

    private String organizationId;

    public DepartmentForm() {
    }

    public DepartmentForm(String name, String description, String organizationId) {
        this.name = name;
        this.description = description;
        this.organizationId = organizationId;
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

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }
}
