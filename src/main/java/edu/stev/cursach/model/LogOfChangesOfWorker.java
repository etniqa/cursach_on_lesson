package edu.stev.cursach.model;

import java.time.LocalDateTime;

public class LogOfChangesOfWorker extends LogParent {

    public LogOfChangesOfWorker(String id, String name, String description, LocalDateTime creationDate,
                                LocalDateTime dateModified, Equipment equipWhichChangeField,
                                Department possibleNewDepartment, Project possibleNewProject,
                                LocalDateTime dateTimeOfChange) {
        super(id, name, description, creationDate, dateModified, equipWhichChangeField, possibleNewDepartment,
                possibleNewProject, dateTimeOfChange);
    }
}
