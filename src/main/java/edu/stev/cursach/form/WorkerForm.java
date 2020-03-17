package edu.stev.cursach.form;

import edu.stev.cursach.model.pojos.Department;
import edu.stev.cursach.model.pojos.TypeOfAgreement;


public class WorkerForm {

    private String name;
    private String description;

    private String departmentWhereWorksId;
    private String agreementWhereIsWorkingId;

    private int additionalField;

    public WorkerForm(String name, String description, String departmentWhereWorksId, String agreementWhereIsWorkingId, int additionalField) {
        this.name = name;
        this.description = description;
        this.departmentWhereWorksId = departmentWhereWorksId;
        this.agreementWhereIsWorkingId = agreementWhereIsWorkingId;
        this.additionalField = additionalField;
    }

    public WorkerForm() {
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

    public String getDepartmentWhereWorksId() {
        return departmentWhereWorksId;
    }

    public void setDepartmentWhereWorksId(String departmentWhereWorksId) {
        this.departmentWhereWorksId = departmentWhereWorksId;
    }

    public String getAgreementWhereIsWorkingId() {
        return agreementWhereIsWorkingId;
    }

    public void setAgreementWhereIsWorkingId(String agreementWhereIsWorkingId) {
        this.agreementWhereIsWorkingId = agreementWhereIsWorkingId;
    }

    public int getAdditionalField() {
        return additionalField;
    }

    public void setAdditionalField(int additionalField) {
        this.additionalField = additionalField;
    }
}
