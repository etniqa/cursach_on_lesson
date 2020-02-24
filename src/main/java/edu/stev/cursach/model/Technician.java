package edu.stev.cursach.model;

import java.time.LocalDateTime;

public class Technician extends Worker {
    static int maxInt;
    static String maxIntString;
    static {
        maxInt = 0;
    }

    private Equipment[] whatKnowHowToUse;

    public Technician(String id, String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                      Department departmentWhereWorks, TypeOfAgreement agreementWhereIsWorking, Equipment... whatKnowHowToUse) {
        super(id, name, description, creationDate, dateModified, departmentWhereWorks, agreementWhereIsWorking);
        this.whatKnowHowToUse = whatKnowHowToUse;
    }

    public static int getMaxIntAndIncrement() {
        return maxInt++;
    }

    public static String getMaxIntStringAndIncrement() {
        return Integer.toString(maxInt++);
    }
}
