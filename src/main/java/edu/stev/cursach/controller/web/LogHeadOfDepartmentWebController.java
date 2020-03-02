package edu.stev.cursach.controller.web;

import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import edu.stev.cursach.service.classes.logHeadOfDepartment.impls.LogHeadOfDepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/web/log_head_of_department")
public class LogHeadOfDepartmentWebController {
    @Autowired
    LogHeadOfDepartmentServiceImpl logHeadOfDepartmentService;
    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("logHeadOfDepartments", logHeadOfDepartmentService.getAll());
        return "logHeadOfDepartmentList";
    }
}
