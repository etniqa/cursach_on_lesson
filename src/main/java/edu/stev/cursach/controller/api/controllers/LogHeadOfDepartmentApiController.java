package edu.stev.cursach.controller.api.controllers;

import edu.stev.cursach.controller.api.cmnInterface.ICommonApiController;
import edu.stev.cursach.model.pojos.Department;
import edu.stev.cursach.model.pojos.LogHeadOfDepartment;
import edu.stev.cursach.model.pojos.LogOfChangesOfEquipment;
import edu.stev.cursach.service.classes.logHeadOfDepartment.impls.LogHeadOfDepartmentServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/log_head_of_department")
@CrossOrigin("*")
public class LogHeadOfDepartmentApiController implements ICommonApiController<LogHeadOfDepartment> {
    @Autowired
    LogHeadOfDepartmentServiceImpl logHeadOfDepartmentService;

    private Logger logger = Logger.getLogger(LogHeadOfDepartmentApiController.class.getName());

    @PostConstruct
    void initialize() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        this.logger.addHandler(consoleHandler);
    }
    @Override
    public Logger getLogger() {
        return this.logger;
    }
    @Override
    public IService getService() {
        return this.logHeadOfDepartmentService;
    }
    @RequestMapping(value = "/get/last_log_for_this_department/{departmentId}", method = RequestMethod.GET)
    public LogHeadOfDepartment getLastForThisDepartment(@PathVariable("departmentId") String depId){
        return this.logHeadOfDepartmentService.getLastForThisDepartment(depId);
    }
}
