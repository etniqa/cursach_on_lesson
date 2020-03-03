package edu.stev.cursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Document
public class LogOfChangesOfWorker {
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime dateModified;
    private Equipment equipWhichChangeField;
    private Department possibleNewDepartment;
    private Project possibleNewProject;
    private LocalDateTime dateTimeOfChange;

    public LogOfChangesOfWorker(String id, String name, String description, LocalDateTime creationDate,
                                LocalDateTime dateModified, Equipment equipWhichChangeField, Department possibleNewDepartment,
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
