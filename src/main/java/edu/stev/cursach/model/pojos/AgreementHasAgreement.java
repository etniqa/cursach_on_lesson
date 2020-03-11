package edu.stev.cursach.model.pojos;

import edu.stev.cursach.model.cmnInterfaces.ICommonFields;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;
@Document
public class AgreementHasAgreement implements ICommonFields {

    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime dateModified;

    private TypeOfAgreement headAgreement;
    private TypeOfAgreement otherAgreement;

    public AgreementHasAgreement() {

    }

    public TypeOfAgreement getHeadAgreement() {
        return headAgreement;
    }
    public void setHeadAgreement(TypeOfAgreement headAgreement) {
        this.headAgreement = headAgreement;
    }
    public TypeOfAgreement getOtherAgreement() {
        return otherAgreement;
    }

    public void setOtherAgreement(TypeOfAgreement otherAgreement) {
        this.otherAgreement = otherAgreement;
    }

    public AgreementHasAgreement(String id, String name, String description, LocalDateTime creationDate,
                                 LocalDateTime dateModified, TypeOfAgreement headAgreement,
                                 TypeOfAgreement otherAgreement) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.dateModified = dateModified;
        this.headAgreement = headAgreement;
        this.otherAgreement = otherAgreement;
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

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getCreationDate(), getDateModified(), getHeadAgreement(), getOtherAgreement());
    }

    @Override
    public String toString() {
        return "AgreementBelongToAgreement{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", dateModified=" + dateModified +
                ", firstAgreement=" + headAgreement +
                ", secAgreement=" + otherAgreement +
                '}';
    }
}
