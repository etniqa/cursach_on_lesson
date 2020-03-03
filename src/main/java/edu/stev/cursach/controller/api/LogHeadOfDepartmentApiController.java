package edu.stev.cursach.controller.api;

import edu.stev.cursach.model.LogHeadOfDepartment;
import edu.stev.cursach.service.classes.logHeadOfDepartment.impls.LogHeadOfDepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/log_head_of_department")
public class LogHeadOfDepartmentApiController {
    @Autowired
    LogHeadOfDepartmentServiceImpl logHeadOfDepartmentService;
    @RequestMapping("/get/list")
    List<LogHeadOfDepartment> getAll(){
        return this.logHeadOfDepartmentService.getAll();
    }
}
