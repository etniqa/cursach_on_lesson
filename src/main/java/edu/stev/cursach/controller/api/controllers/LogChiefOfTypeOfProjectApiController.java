package edu.stev.cursach.controller.api.controllers;

import edu.stev.cursach.controller.api.cmnInterface.ICommonApiController;
import edu.stev.cursach.model.pojos.LogChiefOfTypeOfProject;
import edu.stev.cursach.service.classes.logChiefOfTypeOfProject.impls.LogChiefOfTypeOfProjectServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/log_chief_of_type_of_project")
public class LogChiefOfTypeOfProjectApiController implements ICommonApiController<LogChiefOfTypeOfProject> {
    @Autowired
    LogChiefOfTypeOfProjectServiceImpl logChiefOfTypeOfProjectService;
    @Override
    public IService getService() {
        return this.logChiefOfTypeOfProjectService;
    }
}
