package edu.stev.cursach.model.classes;

import edu.stev.cursach.model.cmnInterfaces.ICommonFields;

import java.time.LocalDateTime;

public class LogOfChangesOfEquipment implements ICommonFields {

    private String id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime dateModified;
    private Equipment equipWhichChangeField;
    private Department possibleNewDepartment;
    private Project possibleNewProject;
    private LocalDateTime dateTimeOfChange;

    public LogOfChangesOfEquipment(String id, String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                     Equipment equipWhichChangeField, Department possibleNewDepartment,
                     Project possibleNewProject, LocalDateTime dateTimeOfChange) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.dateModified = dateModified;
        this.equipWhichChangeField = equipWhichChangeField;
        this.possibleNewDepartment = possibleNewDepartment;
        this.possibleNewProject = possibleNewProject;
        this.dateTimeOfChange = dateTimeOfChange;
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

    @Override
    public void setDateModified(LocalDateTime dateModified) {
        this.dateModified = dateModified;
    }

    public Equipment getEquipWhichChangeField() {
        return equipWhichChangeField;
    }

    public void setEquipWhichChangeField(Equipment equipWhichChangeField) {
        this.equipWhichChangeField = equipWhichChangeField;
    }

    public Department getPossibleNewDepartment() {
        return possibleNewDepartment;
    }

    public void setPossibleNewDepartment(Department possibleNewDepartment) {
        this.possibleNewDepartment = possibleNewDepartment;
    }

    public Project getPossibleNewProject() {
        return possibleNewProject;
    }

    public void setPossibleNewProject(Project possibleNewProject) {
        this.possibleNewProject = possibleNewProject;
    }

    public LocalDateTime getDateTimeOfChange() {
        return dateTimeOfChange;
    }

    public void setDateTimeOfChange(LocalDateTime dateTimeOfChange) {
        this.dateTimeOfChange = dateTimeOfChange;
    }
}

