package edu.stev.cursach.form;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class LogChiefOfTypeOfAgreementForm {
    private String name;
    private String description;

    private String begDate;
    private String endDate;
    private String agreementId;
    private String chiefId;

    public LogChiefOfTypeOfAgreementForm() {
    }

    public LogChiefOfTypeOfAgreementForm(String name, String description, String begDate, String endDate, String agreementId, String chiefId) {
        this.name = name;
        this.description = description;
        this.begDate = begDate;
        this.endDate = endDate;
        this.agreementId = agreementId;
        this.chiefId = chiefId;
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

    public String getBegDate() {
        return begDate;
    }

    public void setBegDate(String begDate) {
        this.begDate = begDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public String getChiefId() {
        return chiefId;
    }

    public void setChiefId(String chiefId) {
        this.chiefId = chiefId;
    }

    public LocalDate getBegDateParsed() {
        LocalDate begDateParsed;
        try {
            begDateParsed = LocalDate.parse(this.begDate);
        } catch (Exception e){
            begDateParsed = null;
        }
        return begDateParsed;
    }

    public LocalDate getEndDateParsed() {
        LocalDate endDateParsed;
        try {
            endDateParsed = LocalDate.parse(this.endDate);
        } catch (Exception e){
            endDateParsed = null;
        }
        return endDateParsed;
    }
}
