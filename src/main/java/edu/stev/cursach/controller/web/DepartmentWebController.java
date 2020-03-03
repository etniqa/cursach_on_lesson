package edu.stev.cursach.controller.web;

import edu.stev.cursach.service.classes.department.impls.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/department")
public class DepartmentWebController {
    @Autowired
    DepartmentServiceImpl departmentService;
    @RequestMapping("/get/list")
    String getAll(Model model){
        model.addAttribute("departments", departmentService.getAll());
        return "departmentList";
    }
    @RequestMapping("/delete/{id}")
    String delete(@PathVariable("id") String id) {
        departmentService.delete(id);
        return "redirect:/web/department/get/list";
    }
}

