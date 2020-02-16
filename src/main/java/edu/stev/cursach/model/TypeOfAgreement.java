package edu.stev.cursach.model;

import java.time.LocalDateTime;

public class TypeOfAgreement extends NecessaryFields {
    private LocalDateTime dateBeg;
    private LocalDateTime dateEnd;
    private CanLead chief;
    private Organization organizationWhichSign;
    private int cost; //counting at the end

    public TypeOfAgreement(String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                           LocalDateTime dateBeg, LocalDateTime dateEnd, CanLead chief,
                           Organization organizationWhichSign) {
        super(name, description, creationDate, dateModified);
        this.dateBeg = dateBeg;
        this.dateEnd = dateEnd;
        this.chief = chief;
        this.organizationWhichSign = organizationWhichSign;
    }

    public LocalDateTime getDateBeg() {
        return dateBeg;
    }

    public void setDateBeg(LocalDateTime dateBeg) {
        this.dateBeg = dateBeg;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public CanLead getChief() {
        return chief;
    }

    public void setChief(CanLead chief) {
        this.chief = chief;
    }

    public Organization getOrganizationWhichSign() {
        return organizationWhichSign;
    }

    public void setOrganizationWhichSign(Organization organizationWhichSign) {
        this.organizationWhichSign = organizationWhichSign;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
