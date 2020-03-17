package edu.stev.cursach.form;

import edu.stev.cursach.model.pojos.Organization;

import java.time.LocalDate;


public class TypeOfAgreementForm {
    private String name;
    private String description;

    private String dateBeg;
    private String dateEnd;
    private String organizationWhichSignId;
    private int cost; //counting at the end

    private String type; //contract or project

    public TypeOfAgreementForm(String name, String description, String dateBeg, String dateEnd, String organizationWhichSignId,
                               int cost) {
        this.name = name;
        this.description = description;
        this.dateBeg = dateBeg;
        this.dateEnd = dateEnd;
        this.organizationWhichSignId = organizationWhichSignId;
        this.cost = cost;
    }

    public TypeOfAgreementForm() {
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

    public String getDateBeg() {
        return dateBeg;
    }

    public void setDateBeg(String dateBeg) {
        this.dateBeg = dateBeg;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getOrganizationWhichSignId() {
        return organizationWhichSignId;
    }

    public void setOrganizationWhichSignId(String organizationWhichSignId) {
        this.organizationWhichSignId = organizationWhichSignId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getBegDateParsed() {
        LocalDate begDateParsed;
        try {
            begDateParsed = LocalDate.parse(this.dateBeg);
        } catch (Exception e){
            begDateParsed = null;
        }
        return begDateParsed;
    }

    public LocalDate getEndDateParsed() {
        LocalDate endDateParsed;
        try {
            endDateParsed = LocalDate.parse(this.dateEnd);
        } catch (Exception e){
            endDateParsed = null;
        }
        return endDateParsed;
    }
}
