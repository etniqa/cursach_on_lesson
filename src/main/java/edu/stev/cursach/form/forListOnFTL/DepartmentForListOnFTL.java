package edu.stev.cursach.form.forListOnFTL;

import edu.stev.cursach.model.pojos.CanLead;
import edu.stev.cursach.model.pojos.Department;

public class DepartmentForListOnFTL {
    private Department department;
    private CanLead headOfDepartment;

    public DepartmentForListOnFTL() {
    }

    public DepartmentForListOnFTL(Department department, CanLead headOfDepartment) {
        this.department = department;
        this.headOfDepartment = headOfDepartment;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public CanLead getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(CanLead headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }
}
