package edu.stev.cursach.controller.web;

import edu.stev.cursach.service.classes.logChiefOfTypeOfProject.impls.LogChiefOfTypeOfProjectServiceImpl;
import edu.stev.cursach.service.classes.logHeadOfDepartment.impls.LogHeadOfDepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/log_chief_of_type_of_project")
public class LogChiefOfTypeOfProjectWebController {
    @Autowired
    LogChiefOfTypeOfProjectServiceImpl logChiefOfTypeOfProjectService;
    @RequestMapping("/get/list")
    String getAll(Model model){
        model.addAttribute("logChiefOfTypeOfProjects", logChiefOfTypeOfProjectService.getAll());
        return "logChiefOfTypeOfProjectList";
    }
    @RequestMapping("/delete/{id}")
    String delete(@PathVariable("id") String id) {
        logChiefOfTypeOfProjectService.delete(id);
        return "redirect:/web/log_chief_of_type_of_project/get/list";
    }
}
