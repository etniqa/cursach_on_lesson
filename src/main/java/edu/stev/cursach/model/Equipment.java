package edu.stev.cursach.model;

import java.time.LocalDateTime;

public class Equipment extends NecessaryFields {
    private Department depWhichResponsible;
    private Project projectWhereIsNowEquip;

    public Equipment(String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                     Department depWhichResponsible, Project projectWhereIsNowEquip) {
        super(name, description, creationDate, dateModified);
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
}
