package edu.stev.cursach.controller.api.controllers;

import edu.stev.cursach.controller.api.cmnInterface.ICommonApiController;
import edu.stev.cursach.model.pojos.AgreementHasAgreement;
import edu.stev.cursach.model.pojos.Department;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import edu.stev.cursach.service.classes.department.impls.DepartmentServiceImpl;
import edu.stev.cursach.service.classes.equipment.impls.EquipmentServiceImpls;
import edu.stev.cursach.service.classes.logHeadOfDepartment.impls.LogHeadOfDepartmentServiceImpl;
import edu.stev.cursach.service.classes.organization.impls.OrganizationServiceImpl;
import edu.stev.cursach.service.classes.typeOfAgreement.impls.TypeOfAgreementServiceImpl;
import edu.stev.cursach.service.classes.worker.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/department")
@CrossOrigin("*")
public class DepartmentApiController implements ICommonApiController<Department> {
    @Autowired
    AgreementHasAgreementServiceImpl agreementHasAgreementService;
    @Autowired
    DepartmentServiceImpl departmentService;
    @Autowired
    EquipmentServiceImpls equipmentService;
    @Autowired
    OrganizationServiceImpl organizationService;
    @Autowired
    TypeOfAgreementServiceImpl typeOfAgreementService;
    @Autowired
    WorkerServiceImpl workerService;
    @Autowired
    LogHeadOfDepartmentServiceImpl logHeadOfDepartmentService;

    private Logger logger = Logger.getLogger(Department.class.getName());

    @PostConstruct
    void initialize() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        System.out.println(consoleHandler.getLevel());
        consoleHandler.setLevel(Level.ALL);
        System.out.println(consoleHandler.getLevel());
        this.logger.addHandler(consoleHandler);
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public DepartmentServiceImpl getService() {
        return this.departmentService;
    }

    @RequestMapping(value = "/get/department_and_amount_of_workers", method = RequestMethod.GET)
    public List<Pair<Department, Long>> getDepartmentAndAmountOfWorkers() {
        return this.departmentService.getDepartmentAndAmountOfWorkers();
    }
}