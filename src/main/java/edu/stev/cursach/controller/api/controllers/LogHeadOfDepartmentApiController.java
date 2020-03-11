package edu.stev.cursach.controller.api.controllers;

import edu.stev.cursach.controller.api.cmnInterface.ICommonApiController;
import edu.stev.cursach.model.pojos.LogHeadOfDepartment;
import edu.stev.cursach.service.classes.logHeadOfDepartment.impls.LogHeadOfDepartmentServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/log_head_of_department")
public class LogHeadOfDepartmentApiController implements ICommonApiController<LogHeadOfDepartment> {
    @Autowired
    LogHeadOfDepartmentServiceImpl logHeadOfDepartmentService;
    @Override
    public IService getService() {
        return this.logHeadOfDepartmentService;
    }
}
