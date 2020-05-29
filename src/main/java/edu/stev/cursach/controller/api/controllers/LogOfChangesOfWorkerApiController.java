package edu.stev.cursach.controller.api.controllers;

import edu.stev.cursach.controller.api.cmnInterface.ICommonApiController;
import edu.stev.cursach.dao.classes.logOfChangesOfWorker.impls.LogOfChangesOfWorkerDaoImpl;
import edu.stev.cursach.model.pojos.LogOfChangesOfWorker;
import edu.stev.cursach.service.classes.logOfChangesOfWorker.impls.LogOfChangesOfWorkerServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/log_of_changes_of_worker")
@CrossOrigin("*")
public class LogOfChangesOfWorkerApiController implements ICommonApiController<LogOfChangesOfWorker> {
    @Autowired
    LogOfChangesOfWorkerServiceImpl logOfChangesOfWorkerService;
    private Logger logger = Logger.getLogger(LogOfChangesOfWorkerApiController.class.getName());

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
        return this.logOfChangesOfWorkerService;
    }

    @RequestMapping(value = "/get/in_period/{dateFrom}/{dateTo}", method = RequestMethod.GET)
    public List<LogOfChangesOfWorker> getInPeriod(@PathVariable("dateFrom") String dateFrom,
                                                  @PathVariable("dateTo") String dateTo){
        System.out.println(dateFrom);
        System.out.println(dateTo);
        return this.logOfChangesOfWorkerService.getInPeriod(dateFrom, dateTo);
    }

    @RequestMapping(value = "/get/last_log_for_prediction_by_worker_id/{workerId}", method = RequestMethod.GET)
    public LogOfChangesOfWorker getLastLogForPredictionByWorkerId(@PathVariable("workerId") String workerId){
        return this.logOfChangesOfWorkerService.getLastLogForPredictionByWorkerId(workerId);
    }
}
