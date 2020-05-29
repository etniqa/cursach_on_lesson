package edu.stev.cursach.controller.api.controllers;

import edu.stev.cursach.controller.api.cmnInterface.ICommonApiController;
import edu.stev.cursach.model.pojos.Department;
import edu.stev.cursach.model.pojos.LogChiefOfTypeOfProject;
import edu.stev.cursach.service.classes.logChiefOfTypeOfProject.impls.LogChiefOfTypeOfProjectServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/log_chief_of_type_of_project")
@CrossOrigin("*")
public class LogChiefOfTypeOfProjectApiController implements ICommonApiController<LogChiefOfTypeOfProject> {
    @Autowired
    LogChiefOfTypeOfProjectServiceImpl logChiefOfTypeOfProjectService;

    private Logger logger = Logger.getLogger(LogChiefOfTypeOfProjectApiController.class.getName());

    @PostConstruct
    void initialize() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        this.logger.addHandler(consoleHandler);
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public IService getService() {
        return this.logChiefOfTypeOfProjectService;
    }

    @RequestMapping(value = "/get/active_chiefs", method = RequestMethod.GET)
    public List<LogChiefOfTypeOfProject> getActiveChiefs(){
        return this.logChiefOfTypeOfProjectService.getListOfActiveChiefs();
    }

    @RequestMapping(value = "/get/last_log_for_agreem/{agreemId}", method = RequestMethod.GET)
    public LogChiefOfTypeOfProject getLastLogForAgreem(@PathVariable("agreemId") String agreemId){
        return this.logChiefOfTypeOfProjectService.getLastLogForAgreem(agreemId);
    }
}
