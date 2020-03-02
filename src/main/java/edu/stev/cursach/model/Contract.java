package edu.stev.cursach.model;

import java.time.LocalDateTime;

public class Contract extends TypeOfAgreement {
    public Contract(String id, String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                    LocalDateTime dateBeg, LocalDateTime dateEnd, CanLead chief, Organization organizationWhichSign,
                    int cost) {
        super(id, name, description, creationDate, dateModified, dateBeg, dateEnd, chief, organizationWhichSign, cost);
    }
}