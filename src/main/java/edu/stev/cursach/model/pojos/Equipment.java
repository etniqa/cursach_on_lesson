package edu.stev.cursach.model.pojos;

import edu.stev.cursach.model.cmnInterfaces.ICommonFields;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document
public class Equipment implements ICommonFields {
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

    @Override
    public String toString() {
        return "Equipment{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", dateModified=" + dateModified +
                ", depWhichResponsible=" + depWhichResponsible +
                ", projectWhereIsNowEquip=" + projectWhereIsNowEquip +
                '}';
    }
}
