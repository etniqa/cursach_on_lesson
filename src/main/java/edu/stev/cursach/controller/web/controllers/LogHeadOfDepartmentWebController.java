package edu.stev.cursach.controller.web.controllers;

import edu.stev.cursach.service.classes.agreementHasAgreement.impls.AgreementHasAgreementServiceImpl;
import edu.stev.cursach.service.classes.logHeadOfDepartment.impls.LogHeadOfDepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/web/log_head_of_department")
public class LogHeadOfDepartmentWebController {
    @Autowired
    LogHeadOfDepartmentServiceImpl logHeadOfDepartmentService;
    @RequestMapping("/get/list")
    String getAll(Model model){
        model.addAttribute("logHeadOfDepartments", logHeadOfDepartmentService.getAll());
        return "logHeadOfDepartmentList";
    }
    @RequestMapping("/delete/{id}")
    String delete(@PathVariable("id") String id) {
        logHeadOfDepartmentService.delete(id);
        return "redirect:/web/log_head_of_department/get/list";
    }
}
