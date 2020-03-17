package edu.stev.cursach.model.pojos;

import java.time.LocalDateTime;

public class Assistant extends Worker {
    private int rate;

    public Assistant() {
        super();
    }
    public Assistant(String id, String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                     Department departmentWhereWorks, TypeOfAgreement agreementWhereIsWorking,
                     int rate) {
        super(id, name, description, creationDate, dateModified, departmentWhereWorks, agreementWhereIsWorking);
        this.rate = rate; //< 100
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

}
