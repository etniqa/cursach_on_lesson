package edu.stev.cursach.controller.api;

import edu.stev.cursach.model.LogChiefOfTypeOfProject;
import edu.stev.cursach.model.LogHeadOfDepartment;
import edu.stev.cursach.service.classes.logChiefOfTypeOfProject.impls.LogChiefOfTypeOfProjectServiceImpl;
import edu.stev.cursach.service.classes.logHeadOfDepartment.impls.LogHeadOfDepartmentServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/log_chief_of_type_of_project")
public class LogChiefOfTypeOfProjectApiController implements ICommonApiController<LogChiefOfTypeOfProject>{
    @Autowired
    LogChiefOfTypeOfProjectServiceImpl logChiefOfTypeOfProjectService;
    @Override
    public IService getService() {
        return this.logChiefOfTypeOfProjectService;
    }
}
