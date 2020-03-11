package edu.stev.cursach.model.pojos;

import java.time.LocalDateTime;

public class Contract extends TypeOfAgreement {
    public Contract(String id, String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                    LocalDateTime dateBeg, LocalDateTime dateEnd, Organization organizationWhichSign, int cost) {
        super(id, name, description, creationDate, dateModified, dateBeg, dateEnd, organizationWhichSign, cost);
    }
}
