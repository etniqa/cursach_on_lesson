package edu.stev.cursach.form;

import edu.stev.cursach.model.pojos.CanLead;
import edu.stev.cursach.model.pojos.Department;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LogHeadOfDepartmentForm {
    private String name;
    private String description;

    private String begDate;
    private String endDate;

    private String headOfDepartmentId;
    private String departmentId;

    public LogHeadOfDepartmentForm() {
    }

    public LogHeadOfDepartmentForm(String name, String description, String begDate, String endDate, String headOfDepartmentId, String departmentId) {
        this.name = name;
        this.description = description;
        this.begDate = begDate;
        this.endDate = endDate;
        this.headOfDepartmentId = headOfDepartmentId;
        this.departmentId = departmentId;
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

    public String getHeadOfDepartmentId() {
        return headOfDepartmentId;
    }

    public void setHeadOfDepartmentId(String headOfDepartmentId) {
        this.headOfDepartmentId = headOfDepartmentId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
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
