package edu.stev.cursach.model.pojos;

import edu.stev.cursach.model.cmnInterfaces.ICommonFields;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Document
public class TypeOfAgreement implements ICommonFields {
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime dateModified;

    private LocalDate dateBeg;
    private LocalDate dateEnd;
    private Organization organizationWhichSign;
    private String fullName;
    private int cost; //counting at the end

    public TypeOfAgreement(String id, String name, String description, LocalDateTime creationDate,
                           LocalDateTime dateModified, LocalDate dateBeg, LocalDate dateEnd,
                           Organization organizationWhichSign, int cost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.dateModified = dateModified;
        this.dateBeg = dateBeg;
        this.dateEnd = dateEnd;
        this.organizationWhichSign = organizationWhichSign;
        int indexOfLastDot = this.getClass().toString().lastIndexOf(".");
        this.fullName = "(" + this.getClass().toString().substring(indexOfLastDot + 1) + ") " + this.name;
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

    public String getFullName() {return this.fullName;}

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

    public LocalDate getDateBeg() {
        return dateBeg;
    }

    public void setDateBeg(LocalDate dateBeg) {
        this.dateBeg = dateBeg;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
