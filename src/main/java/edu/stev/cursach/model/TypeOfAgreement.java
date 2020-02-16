package edu.stev.cursach.model;

import java.time.LocalDateTime;

public class TypeOfAgreement extends NecessaryFields {
    private LocalDateTime dateBeg;
    private LocalDateTime dateEnd;
    private CanLead leader;
    private int cost; //counting at the end

    public TypeOfAgreement(String name, String description, LocalDateTime creationDate, LocalDateTime dateModified, LocalDateTime dateBeg, LocalDateTime dateEnd, CanLead leader) {
        super(name, description, creationDate, dateModified);
        this.dateBeg = dateBeg;
        this.dateEnd = dateEnd;
        this.leader = leader;
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

    public CanLead getLeader() {
        return leader;
    }

    public void setLeader(CanLead leader) {
        this.leader = leader;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
