package edu.stev.cursach.model;

import java.time.LocalDateTime;

public class Project extends TypeOfAgreement {
    public Project(String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                   LocalDateTime dateBeg, LocalDateTime dateEnd, CanLead leader,
                   Organization organizationWhichSign) {
        super(name, description, creationDate, dateModified, dateBeg, dateEnd, leader, organizationWhichSign);
    }
}
