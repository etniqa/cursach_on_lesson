package edu.stev.cursach.model;

import java.time.LocalDateTime;

public class Contract extends TypeOfAgreement {
    public Contract(String name, String description, LocalDateTime creationDate, LocalDateTime dateModified, LocalDateTime dateBeg, LocalDateTime dateEnd, CanLead leader) {
        super(name, description, creationDate, dateModified, dateBeg, dateEnd, leader);
    }
}
