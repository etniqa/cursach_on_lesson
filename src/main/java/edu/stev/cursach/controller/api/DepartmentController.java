package edu.stev.cursach.controller.api;

import edu.stev.cursach.model.AgreementBelongToAgreement;
import edu.stev.cursach.model.Department;
import edu.stev.cursach.service.agreementBelongToAgreement.impls.AgreementBelongToAgreementServiceImpl;
import edu.stev.cursach.service.department.impls.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    DepartmentServiceImpl departmentService;
    @RequestMapping("/list")
    List<Department> getAll(){
        return this.departmentService.getAll();
    }
}

