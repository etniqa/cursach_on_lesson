package edu.stev.cursach.controller.api.controllers;

import edu.stev.cursach.controller.api.cmnInterface.ICommonApiController;
import edu.stev.cursach.model.pojos.Worker;
import edu.stev.cursach.service.classes.worker.impls.WorkerServiceImpl;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/worker")
public class WorkerApiController implements ICommonApiController<Worker> {
    @Autowired
    WorkerServiceImpl workerService;

    @Override
    public IService getService() {
        return this.workerService;
    }
}
