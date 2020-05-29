package edu.stev.cursach.controller.api.controllers;

import edu.stev.cursach.controller.api.cmnInterface.ICommonApiController;
import edu.stev.cursach.model.pojos.Organization;
import edu.stev.cursach.service.classes.organization.impls.OrganizationServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/organization")
@CrossOrigin("*")
public class OrganizationApiController implements ICommonApiController<Organization> {
    @Autowired
    OrganizationServiceImpl organizationService;
    private Logger logger = Logger.getLogger(OrganizationApiController.class.getName());

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
        return this.organizationService;
    }
    @RequestMapping(value = "/get/suborganizations", method = RequestMethod.GET)
    List<Organization> getSuborgs(){
        return this.organizationService.getSuborgs();
    }

}
