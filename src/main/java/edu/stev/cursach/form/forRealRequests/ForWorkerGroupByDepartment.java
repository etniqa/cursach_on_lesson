package edu.stev.cursach.form.forRealRequests;

import edu.stev.cursach.model.pojos.Department;

public class ForWorkerGroupByDepartment {
    public Department department;
    public Long amountOfWorkers;

    public ForWorkerGroupByDepartment(Department department, Long amountOfWorkers) {
        this.department = department;
        this.amountOfWorkers = amountOfWorkers;
    }
}
