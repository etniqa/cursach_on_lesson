package edu.stev.cursach.form;

public class AgreementHasAgreementForForm implements IForForm {
    private String name;
    private String description;

//    private TypeOfAgreement headAgreement;
//    private TypeOfAgreement otherAgreement;


    public AgreementHasAgreementForForm(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public AgreementHasAgreementForForm() {

    }

    @Override
    public IForForm constructor() {
        return new AgreementHasAgreementForForm();
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
    public String toString() {
        return "AgreementHasAgreementForm{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
