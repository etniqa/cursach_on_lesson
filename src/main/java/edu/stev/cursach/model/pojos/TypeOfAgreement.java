package edu.stev.cursach.model.pojos;

import edu.stev.cursach.model.cmnInterfaces.ICommonFields;

import java.time.LocalDateTime;

public class TypeOfAgreement implements ICommonFields {

    private String id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime dateModified;

    private LocalDateTime dateBeg;
    private LocalDateTime dateEnd;
    private Organization organizationWhichSign;
    private int cost; //counting at the end

    public TypeOfAgreement(String id, String name, String description, LocalDateTime creationDate,
                           LocalDateTime dateModified, LocalDateTime dateBeg, LocalDateTime dateEnd,
                           Organization organizationWhichSign, int cost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.dateModified = dateModified;
        this.dateBeg = dateBeg;
        this.dateEnd = dateEnd;
        this.organizationWhichSign = organizationWhichSign;
        this.cost = cost;
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
