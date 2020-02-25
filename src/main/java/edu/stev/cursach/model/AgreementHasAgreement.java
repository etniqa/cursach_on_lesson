package edu.stev.cursach.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class AgreementHasAgreement {
    static int maxInt;
    static String maxIntString;
    static {
        maxInt = 0;
    }
    private String id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime dateModified;
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

    public AgreementHasAgreement(String id, String name, String description, LocalDateTime creationDate,
                                 LocalDateTime dateModified, TypeOfAgreement firstAgreement,
                                 TypeOfAgreement secAgreement) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.dateModified = dateModified;
        this.firstAgreement = firstAgreement;
        this.secAgreement = secAgreement;
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
        return Objects.hash(getName(), getDescription(), getCreationDate(), getDateModified(), getFirstAgreement(), getSecAgreement());
    }

    @Override
    public String toString() {
        return "AgreementBelongToAgreement{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", dateModified=" + dateModified +
                ", firstAgreement=" + firstAgreement +
                ", secAgreement=" + secAgreement +
                '}';
    }
}
