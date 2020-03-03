package edu.stev.cursach.controller.web;

import edu.stev.cursach.service.classes.equipment.impls.EquipmentServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/equipment")
public class EquipmentWebController {
    @Autowired
    EquipmentServiceImpls equipmentServiceImpls;

    @RequestMapping("/get/list")
    String getAll(Model model){
        model.addAttribute("equipments", equipmentServiceImpls.getAll());
        return "equipmentList";
    }
}
