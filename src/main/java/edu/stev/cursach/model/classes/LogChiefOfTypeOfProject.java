package edu.stev.cursach.model;

import edu.stev.cursach.model.cmnInterfaces.ICommonFields;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document
public class LogChiefOfTypeOfProject implements ICommonFields {
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime dateModified;

    private LocalDateTime begDate;
    private LocalDateTime endDate;
    private TypeOfAgreement agreement;
    private CanLead chief;

    public LogChiefOfTypeOfProject(String id, String name, String description, LocalDateTime creationDate,
                                   LocalDateTime dateModified, LocalDateTime begDate, LocalDateTime endDate,
                                   TypeOfAgreement agreement, CanLead chief) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.dateModified = dateModified;
        this.begDate = begDate;
        this.endDate = endDate;
        this.agreement = agreement;
        this.chief = chief;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDateTime getBegDate() {
        return begDate;
    }

    public void setBegDate(LocalDateTime begDate) {
        this.begDate = begDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public TypeOfAgreement getAgreement() {
        return agreement;
    }

    public void setAgreement(TypeOfAgreement agreement) {
        this.agreement = agreement;
    }

    public CanLead getChief() {
        return chief;
    }

    public void setChief(CanLead chief) {
        this.chief = chief;
    }
}
