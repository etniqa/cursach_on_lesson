package edu.stev.cursach.model.pojos;

import edu.stev.cursach.model.cmnInterfaces.ICommonFields;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LogOfChangesOfWorker implements ICommonFields {
    private String id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime dateModified;

    private Worker workerWhoChangeSmth;
    private Department possibleNewDepartment;
    private Project possibleNewProj;
    private LocalDate dateTimeOfChange;
    private LocalDate dateTimeBeforeNewChange;

    public LogOfChangesOfWorker() {
    }

    public LogOfChangesOfWorker(String id, String description, LocalDateTime creationDate, LocalDateTime dateModified, Worker workerWhoChangeSmth, Department possibleNewDepartment, Project possibleNewProj, LocalDate dateTimeOfChange, LocalDate dateTimeBeforeNewChange) {
        this.id = id;
        this.description = description;
        this.creationDate = creationDate;
        this.dateModified = dateModified;
        this.workerWhoChangeSmth = workerWhoChangeSmth;
        this.possibleNewDepartment = possibleNewDepartment;
        this.possibleNewProj = possibleNewProj;
        this.dateTimeOfChange = dateTimeOfChange;
        this.dateTimeBeforeNewChange = dateTimeBeforeNewChange;
    }

    public LogOfChangesOfWorker(String id, String name, String description, LocalDateTime creationDate, LocalDateTime dateModified, Worker workerWhoChangeSmth, Department possibleNewDepartment, Project possibleNewProj, LocalDate dateTimeOfChange) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.dateModified = dateModified;
        this.workerWhoChangeSmth = workerWhoChangeSmth;
        this.possibleNewDepartment = possibleNewDepartment;
        this.possibleNewProj = possibleNewProj;
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

    public Worker getWorkerWhoChangeSmth() {
        return workerWhoChangeSmth;
    }

    public void setWorkerWhoChangeSmth(Worker workerWhoChangeSmth) {
        this.workerWhoChangeSmth = workerWhoChangeSmth;
    }

    public Department getPossibleNewDepartment() {
        return possibleNewDepartment;
    }

    public void setPossibleNewDepartment(Department possibleNewDepartment) {
        this.possibleNewDepartment = possibleNewDepartment;
    }

    public TypeOfAgreement getPossibleNewProj() {
        return possibleNewProj;
    }

    public void setPossibleNewProj(Project possibleNewProj) {
        this.possibleNewProj = possibleNewProj;
    }

    public LocalDate getDateTimeOfChange() {
        return dateTimeOfChange;
    }

    public void setDateTimeOfChange(LocalDate dateTimeOfChange) {
        this.dateTimeOfChange = dateTimeOfChange;
    }

    public LocalDate getDateTimeBeforeNewChange() {
        return dateTimeBeforeNewChange;
    }

    public void setDateTimeBeforeNewChange(LocalDate dateTimeBeforeNewChange) {
        this.dateTimeBeforeNewChange = dateTimeBeforeNewChange;
    }
}
