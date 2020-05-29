package edu.stev.cursach.controller.api.controllers;

import edu.stev.cursach.controller.api.cmnInterface.ICommonApiController;
import edu.stev.cursach.form.forRealRequests.ForWorkerGroupByDepartment;
import edu.stev.cursach.model.pojos.CanLead;
import edu.stev.cursach.model.pojos.LogHeadOfDepartment;
import edu.stev.cursach.model.pojos.Technician;
import edu.stev.cursach.model.pojos.Worker;
import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import edu.stev.cursach.service.classes.department.impls.DepartmentServiceImpl;
import edu.stev.cursach.service.classes.equipment.impls.EquipmentServiceImpls;
import edu.stev.cursach.service.classes.logHeadOfDepartment.impls.LogHeadOfDepartmentServiceImpl;
import edu.stev.cursach.service.classes.organization.impls.OrganizationServiceImpl;
import edu.stev.cursach.service.classes.typeOfAgreement.impls.TypeOfAgreementServiceImpl;
import edu.stev.cursach.service.classes.worker.impls.WorkerServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/worker")
@CrossOrigin("*")
public class WorkerApiController implements ICommonApiController<Worker> {
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

    @Override
    public IService getService() {
        return this.workerService;
    }
    private Logger logger = Logger.getLogger(WorkerApiController.class.getName());

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

    @RequestMapping(value = "/get/technician/list", method = RequestMethod.GET)
    public List<Technician> getTechnicians(){
        return this.workerService.getTechnicians();
    }

    @RequestMapping(value = "/groupByDepartment", method = RequestMethod.GET)
    public List<ForWorkerGroupByDepartment> groupByDepartment(){
        return this.workerService.groupByDepartment();
    }

    @RequestMapping(value = "/get/map_with_canlead_and_amount", method = RequestMethod.GET)
    public List<Pair<CanLead, Integer>> getMapWithCanLeadAndAmount(){
        return this.workerService.getMapWithCanLeadAndAmount();
    }

    @RequestMapping(value = "/get/actual_heads", method = RequestMethod.GET)
    public List<LogHeadOfDepartment> getActualHeads() {
        return this.workerService.getActualHeads();
    }

    @RequestMapping(value = "/get/canleads", method = RequestMethod.GET)
    public List<CanLead> getCanLeads() {
        return this.workerService.getCanLeads();
    }
}
