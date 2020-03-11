package edu.stev.cursach.model;

import java.time.LocalDateTime;

public class Assistant extends Worker {
    private int id;
    private int maxAmountOWorkerOnProject;

    public Assistant(String id, String name, String description, LocalDateTime creationDate, LocalDateTime dateModified,
                     Department departmentWhereWorks, TypeOfAgreement agreementWhereIsWorking,
                     int maxAmountOWorkerOnProject) {
        super(id, name, description, creationDate, dateModified, departmentWhereWorks, agreementWhereIsWorking);
        this.maxAmountOWorkerOnProject = maxAmountOWorkerOnProject;
    }
}
