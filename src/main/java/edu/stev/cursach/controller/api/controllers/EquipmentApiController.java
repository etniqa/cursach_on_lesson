package edu.stev.cursach.controller.api.controllers;

import edu.stev.cursach.controller.api.cmnInterface.ICommonApiController;
import edu.stev.cursach.model.pojos.Contract;
import edu.stev.cursach.model.pojos.Department;
import edu.stev.cursach.model.pojos.Equipment;
import edu.stev.cursach.model.pojos.Project;
import edu.stev.cursach.service.classes.equipment.impls.EquipmentServiceImpls;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/equipment")
@CrossOrigin("*")
public class EquipmentApiController implements ICommonApiController<Equipment> {
    @Autowired
    EquipmentServiceImpls equipmentServiceImpls;

    private Logger logger = Logger.getLogger(EquipmentApiController.class.getName());

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
        return this.equipmentServiceImpls;
    }
}
