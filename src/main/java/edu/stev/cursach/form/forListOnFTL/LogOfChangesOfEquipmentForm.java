package edu.stev.cursach.form.forListOnFTL;

import java.time.LocalDate;

public class LogOfChangesOfEquipmentForm {
    private String name;
    private String description;

    private String equipWhichChangeFieldId;
    private String possibleNewDepartmentId;
    private String possibleNewProjectId;
    private LocalDate dateBegAfterChange;
    private LocalDate dateEndBeforeNewChange;   // if null, then new change wasn`t and this is final shoot

    public LogOfChangesOfEquipmentForm() {
    }

    public LogOfChangesOfEquipmentForm(String name, String description, String equipWhichChangeFieldId, String possibleNewDepartmentId, String possibleNewProjectId, LocalDate dateBegAfterChange, LocalDate dateEndBeforeNewChange) {
        this.name = name;
        this.description = description;
        this.equipWhichChangeFieldId = equipWhichChangeFieldId;
        this.possibleNewDepartmentId = possibleNewDepartmentId;
        this.possibleNewProjectId = possibleNewProjectId;
        this.dateBegAfterChange = dateBegAfterChange;
        this.dateEndBeforeNewChange = dateEndBeforeNewChange;
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

    public String getEquipWhichChangeFieldId() {
        return equipWhichChangeFieldId;
    }

    public void setEquipWhichChangeFieldId(String equipWhichChangeFieldId) {
        this.equipWhichChangeFieldId = equipWhichChangeFieldId;
    }

    public String getPossibleNewDepartmentId() {
        return possibleNewDepartmentId;
    }

    public void setPossibleNewDepartmentId(String possibleNewDepartmentId) {
        this.possibleNewDepartmentId = possibleNewDepartmentId;
    }

    public String getPossibleNewProjectId() {
        return possibleNewProjectId;
    }

    public void setPossibleNewProjectId(String possibleNewProjectId) {
        this.possibleNewProjectId = possibleNewProjectId;
    }

    public LocalDate getDateBegAfterChange() {
        return dateBegAfterChange;
    }

    public void setDateBegAfterChange(LocalDate dateBegAfterChange) {
        this.dateBegAfterChange = dateBegAfterChange;
    }

    public LocalDate getDateEndBeforeNewChange() {
        return dateEndBeforeNewChange;
    }

    public void setDateEndBeforeNewChange(LocalDate dateEndBeforeNewChange) {
        this.dateEndBeforeNewChange = dateEndBeforeNewChange;
    }
}
