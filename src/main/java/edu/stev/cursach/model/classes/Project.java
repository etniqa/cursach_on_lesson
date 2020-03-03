package edu.stev.cursach.model.classes;

import java.time.LocalDateTime;

public class Project extends TypeOfAgreement {
    public Project(String id, String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                   LocalDateTime dateBeg, LocalDateTime dateEnd, Organization organizationWhichSign, int cost) {
        super(id, name, description, creationDate, dateModified, dateBeg, dateEnd, organizationWhichSign, cost);
    }
}
