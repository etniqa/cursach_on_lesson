package edu.stev.cursach.controller.api;

import edu.stev.cursach.model.LogHeadOfDepartment;
import edu.stev.cursach.service.classes.logHeadOfDepartment.impls.LogHeadOfDepartmentServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/log_head_of_department")
public class LogHeadOfDepartmentApiController implements ICommonApiController<LogHeadOfDepartment>{
    @Autowired
    LogHeadOfDepartmentServiceImpl logHeadOfDepartmentService;
    @Override
    public IService getService() {
        return this.logHeadOfDepartmentService;
    }
}
