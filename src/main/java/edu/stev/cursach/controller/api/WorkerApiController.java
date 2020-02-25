package edu.stev.cursach.controller.api;

import edu.stev.cursach.model.Worker;
import edu.stev.cursach.service.worker.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/worker")
public class WorkerApiController {
    @Autowired
    WorkerServiceImpl workerService;

    @RequestMapping("/list")
    List<Worker> getAll(){
        return workerService.getAll();
    }
}
