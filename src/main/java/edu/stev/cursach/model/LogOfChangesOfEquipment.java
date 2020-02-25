package edu.stev.cursach.model;

import java.time.LocalDateTime;

public class LogOfChangesOfEquipment {
    static int maxId;
    static String maxIdStr;
    static {
        maxId = 0;
    }

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

    public static int getMaxIdAndIncrement() {
        return maxId++;
    }

    public static String getMaxIdStrAndIncrement() {
        return Integer.toString(maxId++);
    }

    public static int getMaxId() {
        return maxId;
    }

    public static String getMaxIdStr() {
        return maxIdStr;
    }
}

