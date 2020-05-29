package edu.stev.cursach.controller.api.controllers;

import edu.stev.cursach.controller.api.cmnInterface.ICommonApiController;
import edu.stev.cursach.model.pojos.TechnicianHasEquipment;
import edu.stev.cursach.service.classes.technicianHasEquipment.impls.TechnicianHasEquipmentServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/technician_has_equipment")
@CrossOrigin("*")
public class TechnicianHasEquipmentApiController implements ICommonApiController<TechnicianHasEquipment> {
    @Autowired
    TechnicianHasEquipmentServiceImpl service;
    private Logger logger = Logger.getLogger(TechnicianHasEquipmentApiController.class.getName());

    @PostConstruct
    void initialize() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        System.out.println(consoleHandler.getLevel());
        consoleHandler.setLevel(Level.ALL);
        System.out.println(consoleHandler.getLevel());
        this.logger.addHandler(consoleHandler);
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }
    @Override
    public IService getService() {
        return this.service;
    }
}