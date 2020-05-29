package edu.stev.cursach.controller.api.controllers;

import edu.stev.cursach.controller.api.cmnInterface.ICommonApiController;
import edu.stev.cursach.model.pojos.LogOfChangesOfEquipment;
import edu.stev.cursach.model.pojos.LogOfChangesOfWorker;
import edu.stev.cursach.service.classes.logOfChangesOfEquipment.impls.LogOfChangesOfEquipmentServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/log_of_changes_of_equipment")
@CrossOrigin("*")
public class LogOfChangesOfEquipmentApiController implements ICommonApiController<LogOfChangesOfEquipment> {
    @Autowired
    LogOfChangesOfEquipmentServiceImpl logOfChangesOfEquipmentService;
    @Override
    public IService getService() {
        return this.logOfChangesOfEquipmentService;
    }

    private Logger logger = Logger.getLogger(LogOfChangesOfEquipmentApiController.class.getName());

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

    @RequestMapping(value = "/get/last_log_for_prediction_by_equip_id/{equipId}", method = RequestMethod.GET)
    public LogOfChangesOfEquipment getLastLogForPredictionByEquipId(@PathVariable("equipId") String equipId){
        return this.logOfChangesOfEquipmentService.getLastLogForPredictionByEquipId(equipId);
    }

    @RequestMapping(value = "/get/in_period/{dateFrom}/{dateTo}", method = RequestMethod.GET)
    public List<LogOfChangesOfEquipment> getInPeriod(@PathVariable("dateFrom") String dateFrom,
                                                     @PathVariable("dateTo") String dateTo){
        return this.logOfChangesOfEquipmentService.getInPeriod(dateFrom, dateTo);
    }
}