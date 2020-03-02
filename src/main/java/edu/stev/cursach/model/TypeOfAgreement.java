package edu.stev.cursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document
public class TypeOfAgreement {
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
    private LocalDateTime dateBeg;
    private LocalDateTime dateEnd;
    private CanLead chief;
    private Organization organizationWhichSign;
    private int cost; //counting at the end

    public TypeOfAgreement(String id, String name, String description, LocalDateTime creationDate,
                           LocalDateTime dateModified, LocalDateTime dateBeg, LocalDateTime dateEnd,
                           CanLead chief, Organization organizationWhichSign, int cost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.dateModified = dateModified;
        this.dateBeg = dateBeg;
        this.dateEnd = dateEnd;
        this.chief = chief;
        this.organizationWhichSign = organizationWhichSign;
        this.cost = cost;
    }

    public static int getMaxIntAndIncrement() {
        return maxInt++;
    }

    public static String getMaxIntStringAndIncrement() {
        return Integer.toString(maxInt++);
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
