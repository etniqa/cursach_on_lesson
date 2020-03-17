package edu.stev.cursach.form;

public class EquipmentForm {
    private String name;
    private String description;

    private String depWhichResponsibleId;
    private String projectWhereIsNowEquipId;

    public EquipmentForm() {
    }

    public EquipmentForm(String name, String description, String depWhichResponsibleId, String projectWhereIsNowEquipId) {
        this.name = name;
        this.description = description;
        this.depWhichResponsibleId = depWhichResponsibleId;
        this.projectWhereIsNowEquipId = projectWhereIsNowEquipId;
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

    public String getDepWhichResponsibleId() {
        return depWhichResponsibleId;
    }

    public void setDepWhichResponsibleId(String depWhichResponsibleId) {
        this.depWhichResponsibleId = depWhichResponsibleId;
    }

    public String getProjectWhereIsNowEquipId() {
        return projectWhereIsNowEquipId;
    }

    public void setProjectWhereIsNowEquipId(String projectWhereIsNowEquipId) {
        this.projectWhereIsNowEquipId = projectWhereIsNowEquipId;
    }
}
