package edu.stev.cursach.model;

import java.time.LocalDateTime;

public class Organization extends NecessaryFields{
    private Organization headOrganization;

    public Organization(String name, String description, LocalDateTime creationDate, LocalDateTime dateModified, Organization headOrganization) {
        super(name, description, creationDate, dateModified);
        this.headOrganization = headOrganization;
    }
}
