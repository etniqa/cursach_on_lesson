package edu.stev.cursach.model.classes;

import java.time.LocalDateTime;

public class Staff extends Worker {
    static int maxInt;
    static String maxIntString;
    static {
        maxInt = 0;
    }
    private int rang;

    public Staff(String id, String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                 Department departmentWhereWorks, TypeOfAgreement agreementWhereIsWorking, int rang) {
        super(id, name, description, creationDate, dateModified, departmentWhereWorks, agreementWhereIsWorking);
        this.rang = rang;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }
}
