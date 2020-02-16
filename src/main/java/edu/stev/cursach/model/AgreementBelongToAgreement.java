package edu.stev.cursach.model;

import java.time.LocalDateTime;

public class AgreementBelongToAgreement extends NecessaryFields {
    private TypeOfAgreement firstAgreement;
    private TypeOfAgreement secAgreement;

    public TypeOfAgreement getFirstAgreement() {
        return firstAgreement;
    }

    public void setFirstAgreement(TypeOfAgreement firstAgreement) {
        this.firstAgreement = firstAgreement;
    }

    public TypeOfAgreement getSecAgreement() {
        return secAgreement;
    }

    public void setSecAgreement(TypeOfAgreement secAgreement) {
        this.secAgreement = secAgreement;
    }

    public AgreementBelongToAgreement(TypeOfAgreement firstAgreement, TypeOfAgreement secAgreement) {
        super("name", "description", LocalDateTime.now(), null);
        this.firstAgreement = firstAgreement;
        this.secAgreement = secAgreement;
    }
}
