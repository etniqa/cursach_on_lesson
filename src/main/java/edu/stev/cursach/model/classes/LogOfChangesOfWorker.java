package edu.stev.cursach.model.classes;

import edu.stev.cursach.model.cmnInterfaces.ICommonFields;

import java.time.LocalDateTime;

public class LogOfChangesOfWorker implements ICommonFields {
    private String id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime dateModified;
    private Equipment equipWhichChangeField;
    private Department possibleNewDepartment;
    private Project possibleNewProject;
    private LocalDateTime dateTimeOfChange;

    public LogOfChangesOfWorker(String id, String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
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
    public void setId(String id) {

    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setDescription(String description) {

    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public LocalDateTime getCreationDate() {
        return null;
    }

    @Override
    public void setCreationDate(LocalDateTime creationDate) {

    }

    @Override
    public LocalDateTime getDateModified() {
        return null;
    }

    @Override
    public void setDateModified(LocalDateTime dateModified) {

    }
}
