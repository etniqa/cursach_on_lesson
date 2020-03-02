package edu.stev.cursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document
public class Equipment {
    static int maxInt;
    static String maxIntString;
    static {
        maxInt = 0;
    }
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime dateModified;
    private Department depWhichResponsible;
    private Project projectWhereIsNowEquip;

    public Equipment(String id, String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                     Department depWhichResponsible, Project projectWhereIsNowEquip) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.dateModified = dateModified;
        this.depWhichResponsible = depWhichResponsible;
        this.projectWhereIsNowEquip = projectWhereIsNowEquip;
    }

    public Department getDepWhichResponsible() {
        return depWhichResponsible;
    }

    public void setDepWhichResponsible(Department depWhichResponsible) {
        this.depWhichResponsible = depWhichResponsible;
    }

    public Project getProjectWhereIsNowEquip() {
        return projectWhereIsNowEquip;
    }

    public void setProjectWhereIsNowEquip(Project projectWhereIsNowEquip) {
        this.projectWhereIsNowEquip = projectWhereIsNowEquip;
    }

    public static int getMaxIntAndIncrement() {
        return maxInt++;
    }

    public static String getMaxIntStringAndIncrement() {
        return Integer.toString(maxInt++);
    }

    public static int getMaxInt() {
        return maxInt;
    }

    public static String getMaxIntString() {
        return maxIntString;
    }

    public String getId() {
        return id;
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
}
