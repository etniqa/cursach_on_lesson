package edu.stev.cursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;
@Document
public class AgreementHasAgreement {
    static int maxInt;
    static String maxIntString;
    static {
        maxInt = 0;
    }
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime dateModified;

    private TypeOfAgreement headAgreement;
    private TypeOfAgreement otherAgreement;
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

    public static int getMaxIntAndIncrement() {
        return maxInt++;
    }

    public static String getMaxIntStringAndIncrement() {
        return Integer.toString(maxInt++);
    }

    public static int getMaxInt() {
        return maxInt;
    }

    public static String getMaxIntString() {
        return maxIntString;
    }

    public String getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgreementHasAgreement that = (AgreementHasAgreement) o;
        return getId().equals(that.getId());
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
