package edu.stev.cursach.controller.web;

import edu.stev.cursach.service.classes.technicianHasEquipment.impls.TechnicianHasEquipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/technician_has_equipment")
public class TechnicianHasEquipmentWebController {
    @Autowired
    TechnicianHasEquipmentServiceImpl technicianHasEquipmentService;

    @RequestMapping("/get/list")
    String getAll(Model model){
        model.addAttribute("technicianHasEquipments", technicianHasEquipmentService.getAll());
        return "technicianHasEquipmentList";}

    @RequestMapping("/delete/{id}")
    String delete(@PathVariable("id") String id) {
        technicianHasEquipmentService.delete(id);
        return "redirect:/web/technician_has_equipment/get/list";
    }
}
