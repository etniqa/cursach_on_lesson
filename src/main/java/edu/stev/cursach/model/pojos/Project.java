package edu.stev.cursach.model.pojos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Project extends TypeOfAgreement {
    public Project(String id, String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                   LocalDate dateBeg, LocalDate dateEnd, Organization organizationWhichSign, int cost) {
        super(id, name, description, creationDate, dateModified, dateBeg, dateEnd, organizationWhichSign, cost);
    }
}
