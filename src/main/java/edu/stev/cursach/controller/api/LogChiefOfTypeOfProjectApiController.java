package edu.stev.cursach.controller.api;

import edu.stev.cursach.model.classes.LogChiefOfTypeOfProject;
import edu.stev.cursach.service.classes.logChiefOfTypeOfProject.impls.LogChiefOfTypeOfProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/log_chief_of_type_of_project")
public class LogChiefOfTypeOfProjectApiController {
    @Autowired
    LogChiefOfTypeOfProjectServiceImpl logChiefOfTypeOfProjectService;
    @RequestMapping("/get/list")
    List<LogChiefOfTypeOfProject> getAll(){
        return this.logChiefOfTypeOfProjectService.getAll();
    }
}
