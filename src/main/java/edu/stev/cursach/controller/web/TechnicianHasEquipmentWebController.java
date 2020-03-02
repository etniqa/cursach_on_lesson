package edu.stev.cursach.controller.web;

import edu.stev.cursach.service.classes.technicianHasEquipment.impls.TechnicianHasEquipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/technician_has_equipment")
public class TechnicianHasEquipmentWebController {
    @Autowired
    TechnicianHasEquipmentServiceImpl technicianHasEquipmentService;

    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("technicianHasEquipments", technicianHasEquipmentService.getAll());
        return "technicianHasEquipmentList";}
}
