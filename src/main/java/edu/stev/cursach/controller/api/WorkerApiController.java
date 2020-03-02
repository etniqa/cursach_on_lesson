package edu.stev.cursach.controller.api;

import edu.stev.cursach.model.Worker;
import edu.stev.cursach.service.classes.worker.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//TODO 02.03 = need to make lines with logs, make grud on repository and dataSet in different branch; delete btn; tasks from  new lecture"
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
