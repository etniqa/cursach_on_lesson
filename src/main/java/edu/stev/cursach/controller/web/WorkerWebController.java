package edu.stev.cursach.controller.web;

import edu.stev.cursach.service.classes.worker.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/worker")
public class WorkerWebController {
    @Autowired
    WorkerServiceImpl workerService;

    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("workers", workerService.getAll());
        return "workerList";
    }
}
