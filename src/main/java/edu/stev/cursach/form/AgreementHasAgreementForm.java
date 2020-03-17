package edu.stev.cursach.form;

public class AgreementHasAgreementForm {
    private String name;
    private String description;

    private String headAgreementId;
    private String otherAgreementId;

    public AgreementHasAgreementForm(String name, String description, String headAgreementId, String otherAgreementId) {
        this.name = name;
        this.description = description;
        this.headAgreementId = headAgreementId;
        this.otherAgreementId = otherAgreementId;
    }

    public AgreementHasAgreementForm() {
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

    public String getHeadAgreementId() {
        return headAgreementId;
    }

    public void setHeadAgreementId(String headAgreementId) {
        this.headAgreementId = headAgreementId;
    }

    public String getOtherAgreementId() {
        return otherAgreementId;
    }

    public void setOtherAgreementId(String otherAgreementId) {
        this.otherAgreementId = otherAgreementId;
    }

    @Override
    public String toString() {
        return "AgreementHasAgreementForm{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
